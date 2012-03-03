package Compiler.Parsing;

import Compiler.Parsing.Exceptions.ParsingException;
import TreeNodeTypes.FunctionNode;
import TreeNodeTypes.TreeNode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionParser extends Parser {


    public static final Pattern lambdaRegexPattern = Pattern.compile("\\{ *[^ ]+ *->.*[^ ].*\\}");
    public static final Pattern lambdaRegexArgument = Pattern.compile("\\{ *([a-z]+) *-> *(.*) *\\}");

    public FunctionParser(String expression) {

        super(expression);

    }

    @Override
    public TreeNode parse() throws ParsingException {

        Matcher m = lambdaRegexPattern.matcher(expression);
        if (!m.matches()) {
            throw new ParsingException("Wrong lambda expression: " + expression);
        }

        Matcher argMatcher = lambdaRegexArgument.matcher(expression);
        argMatcher.find();
        String arg = argMatcher.group(1);
        String body = argMatcher.group(2);

        return new FunctionNode(arg, new Parser(body).parse());

    }

}
