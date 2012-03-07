package TreeNodeTypes;


import LProgramm.LProgramRuntimeException;

public class ConstantNode extends TreeNode {

    final int value;

    public ConstantNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "!\n" + value + "\n";
    }

    @Override
    public TreeNode clone() {

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
}
