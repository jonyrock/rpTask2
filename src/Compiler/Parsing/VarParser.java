package Compiler.Parsing;

import Compiler.Parsing.Exceptions.ParsingException;
import TreeNodeTypes.TreeNode;
import TreeNodeTypes.VarNote;

public class VarParser extends Parser{
    
    public VarParser(String expression){
        super(expression);
    }

    @Override
    public TreeNode parse() throws ParsingException {
        return new VarNote(expression);
    }
}
