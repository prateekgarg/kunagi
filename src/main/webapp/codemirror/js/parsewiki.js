var WikiParser = Editor.Parser = (function() {

	var run = 0;

	function log(message) {
		//if (console && run <= 2)
		//	console.log(message);
	}

	var tokenizeWiki = (function() {

		function next(source) {
			if (source.endOfLine())
				throw "end-of-line";
			var ch = source.next();
			//log("consumed: '" + ch + "'");
			return ch;
		}

		function reset(source) {
			var s = source.get();
			log("reset: " + s);
			source.push(s);
		}

		function header(depth) {
			var endmarker = ' ';
			for (i = 0; i < depth; i++) {
				endmarker += '=';
			}
			return function(source, setState) {
				// log("header(" + source.peek() + ")")
				for (i = 0; i < depth; i++) {
					next(source);
				}
				next(source);
				// log("header-1(" + source.peek() + ")")
				var marker = '';
				while (!source.endOfLine()) {
					var ch = next(source);
					if (ch == ' ') {
						marker = ' ';
						continue;
					}
					if (ch != '=') {
						marker = '';
						continue;
					}
					marker += ch;
					if (source.endOfLine() && marker == endmarker) {
						setState(begin);
						return 'wiki-h' + depth;
					}
				}
				reset(source);
				setState(normal);
				return null;
			};
		}

		function list(source, setState) {
			// log("list(" + source.peek() + ")")
			next(source);
			next(source);
			if (source.endOfLine()) {
				setState(begin);
			} else {
				setState(normal);
			}
			return 'wiki-list';
		}

		function wrapper(prefix, suffix, style) {
			return function(source, setState) {
				log("wrapper(" + source.peek() + ")");
				for (i = 0; i < prefix.length; i++) {
					next(source);
				}
				while (!source.endOfLine()) {
					if (source.lookAhead(suffix)) {
						log("wrapper-1(" + source.peek() + "," + suffix + ")");
						for (i = 0; i < suffix.length; i++) {
							next(source);
						}
						log("wrapper-2(" + source.peek() + ")");
						setState(normal);
						return style;
					}
					next(source);
				}
				reset(source);
				next(source);
				setState(normal);
				return null;
			};
		}

		function code(source, setState) {
			//log("code(" + source.peek() + ")");
			while (!source.endOfLine()) {
				var ch = source.peek();
				if (ch == '<') {
					if (source.lookAhead('</code>')) {
						log("code-3(" + source.peek() + ")");
						next(source);
						next(source);
						next(source);
						next(source);
						next(source);
						next(source);
						next(source);
						setState(normal);
						return "wiki-code";
					}
				}
				next(source);
			}
			return "wiki-code";
		}

		function normal(source, setState) {
			//log("normal(" + source.peek() + ")");
			var prev = ' ';
			while (!source.endOfLine()) {
				var prevIsAlphaNum
				var ch = source.peek();
				if (/\s/.test(prev)) {
					if (ch == '<' && source.lookAhead('<code>')) {
						setState(wrapper('<code>', '</code>', 'wiki-code'));
						return 'wiki-text';
					}
					if (ch == "'" && source.lookAhead("'''''")) {
						setState(wrapper("'''''", "'''''", 'wiki-bold-italic'));
						return 'wiki-text';
					}
					if (ch == "'" && source.lookAhead("'''")) {
						setState(wrapper("'''", "'''", 'wiki-bold'));
						return 'wiki-text';
					}
					if (ch == "'" && source.lookAhead("''")) {
						setState(wrapper("''", "''", 'wiki-italic'));
						return 'wiki-text';
					}
				}
				prev = ch;
				next(source);
			}
			setState(begin);
			return 'wiki-text';
		}

		function begin(source, setState) {
			//log("begin(" + source.peek() + ")")
			var ch = source.peek();

			if (ch == '=') {
				if (ch == '=' && source.lookAhead('= ')) {
					setState(header(1));
					return null;
				}
				if (source.lookAhead('== ')) {
					setState(header(2));
					return null;
				}
				if (source.lookAhead('=== ')) {
					setState(header(3));
					return null;
				}
				if (source.lookAhead('==== ')) {
					setState(header(4));
					return null;
				}
			}

			if (ch == '<' && source.lookAhead('<code>')) {
				setState(code);
				return null;
			}

			if ((ch == '*' && source.lookAhead('* ')) || (ch == '#' && source.lookAhead('# '))) {
				setState(list);
				return null;
			}

			setState(normal)
			return null;
		}

		return function(source, startState) {
			run++;
			return tokenizer(source, startState || begin);
		};

	})();

	function indentWiki(inBraces, inRule, base) {
		return function(nextChars) {
			return base;
		};
	}

	function parseWiki(source, basecolumn) {
		basecolumn = basecolumn || 0;
		tokens = tokenizeWiki(source);

		var iter = {
			next : function() {
				var token = tokens.next();
				var style = token.style;
				var content = token.content;

				// console.log("content: "+content);

				if (content == '\n') {
					token.indentation = indentWiki(false, false, basecolumn);
				}

				return token;
			},

			copy : function() {
				var _tokenState = tokens.state;
				return function(source) {
					tokens = tokenizeWiki(source, _tokenState);
					return iter;
				};
			}
		};
		return iter;
	}

	return {
		make : parseWiki
	};
})();
