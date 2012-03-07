package LProgramm;

import Compiler.LCompiler;
import Compiler.Preprocessor;
import Compiler.Parsing.Exceptions.ParsingException;
import Compiler.Parsing.Parser;
import TreeNodeTypes.FunctionNode;
import TreeNodeTypes.TreeNode;
import TreeNodeTypes.VarNode;


public class LProgram {

    private final TreeNode root;

    public LProgram(String defsSource) throws ParsingException {

        LCompiler compiler = new LCompiler(defsSource);
        this.root = compiler.program;

    }

    public TreeNode term(String name) {
        return root.context.get(name);
    }

    public TreeNode evaluate(String expression) throws ParsingException, LProgramRuntimeException {

        expression = new Preprocessor(expression).preprocess();

        
        VarNode evalNode = new VarNode("evalNode");
        evalNode.parent = root;
        
        TreeNode tree = new Parser(expression).parse();
        tree.parent = evalNode;

        TreeNode evalTree = tree.evaluate();
        evalTree.parent = evalNode;

        return evalTree;

    }

}
