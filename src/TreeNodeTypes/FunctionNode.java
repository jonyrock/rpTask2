package TreeNodeTypes;

public class FunctionNode extends TreeNode {

    TreeNode body;
    public final String argName;

    public FunctionNode(String argName, TreeNode body) {
        this.argName = argName;
        this.body = body;
    }

    @Override
    public String toString() {
        return "f\n"+ this.argName + "\n" + this.body.toString();                
    }


}
