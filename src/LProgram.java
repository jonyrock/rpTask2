import Compiler.LCompiler;
import Compiler.Parsing.Exceptions.ParsingException;
import Compiler.Parsing.Parser;
import TreeNodeTypes.TreeNode;


public class LProgram {

    private final TreeNode root;

    public LProgram(String defsSource) throws ParsingException {

        LCompiler compiler = new LCompiler(defsSource);
        this.root = compiler.program;

    }

    public TreeNode term(String name) {
        return root.context.get(name);
    }

    public TreeNode evaluate(String expression) throws ParsingException{
        
        TreeNode tree = new Parser(expression).parse();
        tree.parent = root;
                
        return tree.evaluate();
        
    }

}
