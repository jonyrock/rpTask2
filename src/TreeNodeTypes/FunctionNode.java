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

        FunctionNode newTree = new FunctionNode(this.argName);
        newTree.context = super.cloneContext();
        newTree.body = this.body.clone();

        return newTree;

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

        if (super.context.get(argName).canReturnConstant()) {

            return body.evaluate();

        } else {

            FunctionNode newFun = new FunctionNode(this.argName);
            newFun.context = super.cloneContext();
            newFun.body = this.body.evaluate();
            newFun.body.parent = this;

            return newFun;

        }

    }

    @Override
    public void substitute(TreeNode treeNode) throws LProgramRuntimeException {

        if (!substitutedArg) {

            super.context.put(argName, treeNode);
            substitutedArg = true;

        } else {

            body.substitute(super.context.get(argName));
            super.context.put(argName, treeNode);

        }

    }
}
