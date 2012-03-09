package compiler.parsing;

import compiler.parsing.exceptions.ParsingException;
import treenodetypes.TreeNode;
import treenodetypes.VarNode;

public class VarParser extends Parser {

    public VarParser(String expression) {
        super(expression);
    }

    @Override
    public TreeNode parse() throws ParsingException {
        return new VarNode(expression);
    }
}
