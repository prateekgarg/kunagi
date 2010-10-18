var WikiParser = Editor.Parser = (function() {
	
	var tokenizeWiki = (function() {
	    
		function line(source, cls) {
			while(!source.endOfLine()) source.next();
			return cls;
		}

		function normal(source, setState) {
			var ch = source.next();
			
//			if (inCode) return line(source, 'wiki-code');
//			
			if (ch=='<') {
				if (source.lookAhead('code>')) {
					setState(inCode)
					return line(source, 'wiki-normal');
				}
			}
			
			if(ch == '=') {
				if (source.lookAhead(' ')) return line(source, 'wiki-h1');
				if (source.lookAhead('= ')) return line(source, 'wiki-h2');
				if (source.lookAhead('== ')) return line(source, 'wiki-h3');
				if (source.lookAhead('=== ')) return line(source, 'wiki-h4');
			}
			
			if(ch=='*' || ch=='#') {
				if (source.lookAhead(' ')) return line(source, 'wiki-list');
			}
					
			return line(source, 'wiki-default');
	    }
		
		function inCode(source, setState) {
			var ch = source.next();

			if (ch=='<') {
				if (source.lookAhead('/code>')) {
					setState(normal)
					return null;
				}
			}
			
			return line(source, 'wiki-code');
		}
	    	
	    return function(source, startState) {
	    	return tokenizer(source, startState || normal);
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
				next: function() {
					var token = tokens.next();
					var style = token.style;
					var content = token.content;
					
					if(content == '\n') {
						token.indentation = indentWiki(false, false, basecolumn);
					}
					
					return token;
				},
				
				copy: function() {
					return function(source) {
						source = tokenizer(source, tokenizeWiki);
						return iter;
					};
				}
		};
		return iter;
	}
	
	return {
		make: parseWiki
	};
})();
