package treenodetypes;


import lprogramm.exceptions.LProgramRuntimeException;

public class VarNode extends TreeNode {


    private String name;


    public VarNode(String name) {
        this.name = name;
    }

    private TreeNode getTreeValue() {

        return super.findVarInContext(this.name);

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

        if (t != null && t.isTerm()) {
            TreeNode tEval = t.copy().evaluate();
            tEval.parent = this.parent;
            return tEval;
        }

        return this.copy();

    }

    @Override
    protected boolean isTerm() {
        //return getTreeValue() != null;
        return false;
    }

    // printers
    @Override
    public String toString() {

        TreeNode t = getTreeValue();

        if (t != null && !t.isTerm()) {
            return t.toString();
        }

        return name;

    }

    @Override
    public String toStringColumn() {

        TreeNode t = getTreeValue();

        if (t != null && !t.isTerm()) {
            return "x\n" + t.toStringColumn();
        }

        return "x\n" + name + "\n";

    }


}   
