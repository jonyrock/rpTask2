package compiler.parsing;

import compiler.parsing.exceptions.ParsingException;
import treenodetypes.OperationNode;
import treenodetypes.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperationParser extends Parser {

    public static final List<String> ALLOWED_SIGNS = Arrays.asList("*", "/", "+", "-", "%");

    public OperationParser(ArrayList<String> levelTokens) {

        super(null);

        if (levelTokens.size() != 3)
            throw new IllegalArgumentException("Expect 3 terms for binary operation");

        super.levelTokens = levelTokens;

    }

    @Override
    public TreeNode parse() throws ParsingException {

        if (isSign(levelTokens.get(1))) {
            return new OperationNode(levelTokens.get(1),
                    new Parser(levelTokens.get(0)).parse(),
                    new Parser(levelTokens.get(2)).parse());
        } else {
            throw new ParsingException("Expected sign but got: " +
                    levelTokens.get(1));
        }

    }

    public static boolean isSign(String sign) {
        return ALLOWED_SIGNS.contains(sign);
    }

}
