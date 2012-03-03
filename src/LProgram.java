import TreeNodeTypes.TreeNode;
import Compiler.LCompiler;
import Compiler.Parsing.Exceptions.ParsingException;


public class LProgram {
    
    private final TreeNode root;
        
    
    public LProgram(String defsSource) throws ParsingException {

        LCompiler compiler = new LCompiler(defsSource);
        this.root = compiler.program;
        
    } 
    
    public TreeNode term(String name){
        return root.context.get(name);
    }
    
}
