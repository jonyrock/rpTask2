package TreeNodeTypes;

import LProgramm.LProgramRuntimeException;

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
        return "f\n" + super.context.get(argName).clearName() + "\n"
                + this.body.toString();
    }

    @Override
    public FunctionNode clone() {

        FunctionNode n = new FunctionNode(this.argName);
        n.parent = this.parent;
        n.context = super.cloneContext();
        n.body = this.body.clone();
        n.body.parent = n;

        return n;

    }

    @Override
    public void substitute(TreeNode treeNode) throws LProgramRuntimeException {
        this.context.put(argName, treeNode.clone());        
    }

    @Override
    public TreeNode evaluate() throws LProgramRuntimeException {
        //TODO add case when not defined vars

        FunctionNode n = this.clone();
        n.body = n.body.evaluate();

        if (n.body.canReturnConstant()) {
            return n.body;
        } else {
            return n;
        }
        
    }
}
