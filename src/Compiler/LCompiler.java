package Compiler;

import Compiler.Parsing.Exceptions.ParsingException;
import Compiler.Parsing.Parser;
import TreeNodeTypes.TreeNode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LCompiler {

    public TreeNode program;

    private String sourceCode;

    public static final Pattern defTermRegexPattern = Pattern.compile(" *([a-z]+) *=(.+)");

    public LCompiler(String sourceCode) throws ParsingException {
        this.sourceCode = new Preprocessor(sourceCode).preprocess();
        this.program = new TreeNode();
        fillNamesMapping();
    }

    private void fillNamesMapping() throws ParsingException {

        String[] defTerm = sourceCode.split(";");

        for (String term : defTerm) {

            Matcher termMatcher = defTermRegexPattern.matcher(term);
            if (!termMatcher.find()) {
                throw new ParsingException("Wrong def expression: " + term);
            }

            String arg = termMatcher.group(1);
            String body = termMatcher.group(2);

            this.program.context.put(arg, new Parser(body).parse());

        }

    }


}
