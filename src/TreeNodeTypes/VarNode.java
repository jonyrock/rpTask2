package TreeNodeTypes;


import LProgramm.LProgramRuntimeException;

public class VarNode extends TreeNode {


    private String name;

    private boolean cashedTreeValue = false;
    private TreeNode valueTree = null;


    public VarNode(String name) {
        this.name = name;
    }

    private TreeNode getTreeValue() {

        if (valueTree != null) {
            return valueTree;
        }

        if (!cashedTreeValue) {
            valueTree = super.findVarInContext(this.name);
            cashedTreeValue = true;
        }

        return valueTree;

    }


    @Override
    public String toString() {

        if (getTreeValue() != null) {
            return "x\n" + getTreeValue().toString() + "\n";
        }

        return "x\n" + name + "\n";

    }

    @Override
    public TreeNode clone() {
        return new VarNode(this.name);
    }

    @Override
    public TreeNode evaluate() throws LProgramRuntimeException {

        if (getTreeValue() != null) {
            return this.getTreeValue().evaluate();
        }

        return this.clone();

    }

    @Override
    protected boolean canReturnConstant() throws LProgramRuntimeException {

        if (getTreeValue() == null)
            return false;

        return getTreeValue().canReturnConstant();

    }

    @Override
    public int getConstantValue() throws LProgramRuntimeException {
        return getTreeValue().getConstantValue();
    }


    @Override
    public void substitute(TreeNode treeNode) throws LProgramRuntimeException {

        if (getTreeValue() == null) {
            return;
        }

        getTreeValue().substitute(treeNode);

    }
}
