package TreeNodeTypes;


import LProgramm.LProgramRuntimeException;

public class VarNode extends TreeNode {


    private String name;


    public VarNode(String name) {
        this.name = name;
    }

    private TreeNode getTreeValue() {

        return super.findVarInContext(this.name);

    }


    @Override
    public String toString() {

        if (getTreeValue() != null) {
            return "x\n" + getTreeValue().toString();
        }

        return "x\n" + name + "\n";

    }

    @Override
    public TreeNode copy() {

        VarNode n = new VarNode(this.name);
        n.parent = this.parent;
        n.parentSubstitution = this.parentSubstitution;
        return n;

    }

    @Override
    public TreeNode evaluate() throws LProgramRuntimeException {

        TreeNode t = getTreeValue();

        if (t != null) {
            if (t.isTerm()) {
                TreeNode tEval = t.evaluate();
                tEval.parent = this.parent;
                return tEval;
            }
        }

        return this.copy();

    }

    @Override
    protected boolean isTerm() {
        return getTreeValue() != null;
    }

}
