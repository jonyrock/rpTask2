package compiler.parsing;

import compiler.parsing.exceptions.ParsingException;
import treenodetypes.FunctionNode;
import treenodetypes.TreeNode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionParser extends Parser {


    public static final Pattern LAMBDA_REGEX_PATTERN = Pattern.compile("\\{ *[^ ]+ *->.*[^ ].*\\}");
    public static final Pattern LAMBDA_REGEX_ARGUMENT = Pattern.compile("\\{ *([a-z]+) *-> *(.*) *\\}");

    public FunctionParser(String expression) {

        super(expression);

    }

    @Override
    public TreeNode parse() throws ParsingException {

        Matcher m = LAMBDA_REGEX_PATTERN.matcher(expression);
        if (!m.matches()) {
            throw new ParsingException("Wrong lambda expression: " + expression);
        }

        Matcher argMatcher = LAMBDA_REGEX_ARGUMENT.matcher(expression);
        argMatcher.find();
        String arg = argMatcher.group(1);
        String body = argMatcher.group(2);

        return new FunctionNode(arg, new Parser(body).parse());

    }

}
