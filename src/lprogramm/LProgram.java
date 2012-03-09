package lprogramm;

import compiler.LCompiler;
import compiler.Preprocessor;
import compiler.parsing.Parser;
import compiler.parsing.exceptions.ParsingException;
import lprogramm.exceptions.LProgramRuntimeException;
import treenodetypes.TreeNode;
import treenodetypes.VarNode;


public class LProgram {

    public final TreeNode root;

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
