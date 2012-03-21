package treenodetypes;


import lprogramm.exceptions.LProgramRuntimeException;

public class ConstantNode extends TreeNode {

    final int value;

    public ConstantNode(int value) {
        this.value = value;
    }


    @Override
    public TreeNode copy() {

        ConstantNode n = new ConstantNode(this.value);
        n.parent = this.parent;
        n.parentSubstitution = this.parentSubstitution;
        return n;

    }

    // return this
    @Override
    public TreeNode evaluate() throws LProgramRuntimeException {

        return this;
    }

    @Override
    protected boolean canReturnConstant() throws LProgramRuntimeException {
        return true;
    }

    @Override
    public ConstantNode getConstantValue() throws LProgramRuntimeException {
        return this;
    }

    // printers

    @Override
    public String toString() {
        return value + "";
    }

    @Override
    public String toStringColumn() {
        return "!\n" + value + "\n";
    }

}
