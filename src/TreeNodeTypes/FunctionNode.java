package TreeNodeTypes;

import LProgramm.LProgramRuntimeException;

public class FunctionNode extends TreeNode {

    TreeNode body;
    protected final String argName;
    protected boolean substitutedArg = false;

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
    public TreeNode clone() {

        FunctionNode n = new FunctionNode(this.argName);
        n.parent = this.parent;
        n.context = super.cloneContext();
        n.body = this.body.clone();
        n.body.parent = n;
        n.substitutedArg = this.substitutedArg;

        return n;

    }

    @Override
    protected boolean canReturnConstant() throws LProgramRuntimeException {
        return body.canReturnConstant();
    }

    @Override
    public int getConstantValue() throws LProgramRuntimeException {
        return body.getConstantValue();
    }

    @Override
    public TreeNode evaluate() throws LProgramRuntimeException {

        super.context.put(argName, super.context.get(argName).evaluate());
        this.body = body.evaluate();

        if (substitutedArg)
            return body.clone();

        return this.clone();

    }

    @Override
    public void substitute(TreeNode treeNode) throws LProgramRuntimeException {
        
        if(!canSubstitute())
            return;
        
        super.context.put(argName, treeNode);
        substitutedArg = true;

    }

    @Override
    public boolean canSubstitute() {
        return !substitutedArg;
    }

}
