package Parsing;

import Parsing.Exceptions.ParsingException;
import TreeNodeTypes.ConstantNode;
import TreeNodeTypes.TreeNode;

public class ConstantParser extends Parser {

    public ConstantParser(String expression) {
        super(expression);
    }

    @Override
    public TreeNode parse() throws ParsingException {

        int val = 0;
        try {
            val = Integer.parseInt(this.expression);
        } catch (java.lang.NumberFormatException e) {
            throw new ParsingException("Can't parse constant");
        }

        return new ConstantNode(val);
        
    }
}
