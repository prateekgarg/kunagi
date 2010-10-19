var WikiParser = Editor.Parser = (function() {

    var tokenizeWiki = (function() {

        function header(depth) {
            var endmarker = ' ';
            for (i = 0; i < depth; i++) {
                endmarker += '=';
            }
            return function(source, setState) {
                for (i = 1; i < depth; i++) {
                    source.next();
                }
                var marker = '';
                while (!source.endOfLine()) {
                    var ch = source.next();
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
                setState(normal);
                return null;
            };
        }

        function list(source, setState) {
            setState(normal);
            return 'wiki-list';
        }

        function normal(source, setState) {
            while (!source.endOfLine()) {
                var ch = source.next();
                
            }
            setState(begin);
            return 'wiki-text';
        }

        function begin(source, setState) {
            var ch = source.next();

            if (ch == '=') {
                if (source.lookAhead(' ')) {
                    setState(header(1));
                    return null;
                }
                if (source.lookAhead('= ')) {
                    setState(header(2));
                    return null;
                }
                if (source.lookAhead('== ')) {
                    setState(header(3));
                    return null;
                }
                if (source.lookAhead('=== ')) {
                    setState(header(4));
                    return null;
                }
            }

            if ((ch == '*' || ch == '#') && source.equals(' ')) {
                setState(list)
                return null;
            }

            setState(normal)
            return null;
        }

        return function(source, startState) {
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
                return function(source) {
                    source = tokenizer(source, tokenizeWiki);
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
