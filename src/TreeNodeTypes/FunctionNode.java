package TreeNodeTypes;

public class FunctionNode extends TreeNode {

    TreeNode body;
    protected final String argName;

    public FunctionNode(String argName, TreeNode body) {        
        
        this.body = body;
        this.body.parent = this;
        this.argName = argName;
        
        super.context.put(argName, new VarNonValueNode());
        
    }

    @Override
    public String toString() {
        return "f\n"+ super.context.get(argName) + "\n" + this.body.toString();                
    }


}
