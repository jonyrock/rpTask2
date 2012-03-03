package Parsing;

import Parsing.Exceptions.ParsingException;
import TreeNodeTypes.OperationNode;
import TreeNodeTypes.TreeNode;

import java.util.ArrayList;

public class OperationParser extends Parser {

    public OperationParser(ArrayList<String> levelTokens) {
        super(null);
        if (levelTokens.size() != 3)
            throw new IllegalArgumentException("Expect 3 terms");

        super.levelTokens = levelTokens;
    }

    @Override
    public TreeNode parse() throws ParsingException {

        if (super.levelTokens.size() != 3) {
            throw new ParsingException("Expect binary operation");
        }


        return new OperationNode(levelTokens.get(1),
                new Parser(levelTokens.get(0)).parse(),
                new Parser(levelTokens.get(2)).parse());

        //return new FunctionNode(arg, new Parser(body).parse());

    }

}
