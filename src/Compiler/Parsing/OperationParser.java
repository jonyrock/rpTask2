package Compiler.Parsing;

import Compiler.Parsing.Exceptions.ParsingException;
import TreeNodeTypes.OperationNode;
import TreeNodeTypes.TreeNode;

import java.util.ArrayList;

public class OperationParser extends Parser {

    public OperationParser(ArrayList<String> levelTokens) {

        super(null);

        if (levelTokens.size() != 3)
            throw new IllegalArgumentException("Expect 3 terms for binary operation");

        super.levelTokens = levelTokens;

    }

    @Override
    public TreeNode parse() throws ParsingException {
        
        if(!OperationParser.isSign(levelTokens.get(1))){
            throw new ParsingException("Expected sign but got: " + 
                    levelTokens.get(1));
        }

        return new OperationNode(levelTokens.get(1),
                new Parser(levelTokens.get(0)).parse(),
                new Parser(levelTokens.get(2)).parse());

    }

    public static boolean isSign(String sign) {

        if (sign.equals("+")) {
            return true;
        }
        if (sign.equals("-")) {
            return true;
        }
        if (sign.equals("*")) {
            return true;
        }
        if (sign.equals("/")) {
            return true;
        }
        if (sign.equals("%")) {
            return true;
        }

        return false;
    }


}
