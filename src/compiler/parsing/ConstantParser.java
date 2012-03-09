package compiler.parsing;

import compiler.parsing.exceptions.ParsingException;
import treenodetypes.ConstantNode;
import treenodetypes.TreeNode;

public class ConstantParser extends Parser {

    public ConstantParser(String expression) {
        super(expression);
    }

    @Override
    public TreeNode parse() throws ParsingException {

        try {
            return new ConstantNode(Integer.parseInt(super.expression));
        } catch (java.lang.NumberFormatException e) {
            throw new ParsingException("Can't parse constant");
        }

    }
}
