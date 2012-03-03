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

    private FunctionNode(String argName) {
        this.argName = argName;
    }

    @Override
    public String toString() {
        return "f\n" + super.context.get(argName) + "\n" + this.body.toString();
    }

    @Override
    public TreeNode clone() {

        FunctionNode newTree = new FunctionNode(this.argName);
        newTree.context = super.cloneContext();
        newTree.body = this.body.clone();

        return newTree;

    }

    @Override
    protected boolean canReturnConstant() {
        return body.canReturnConstant();
    }

    @Override
    public int getConstantValue() {
        return body.getConstantValue();
    }

    
}
