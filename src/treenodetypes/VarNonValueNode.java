package treenodetypes;


public class VarNonValueNode extends TreeNode {

    final String codeName;
    static int varNum;

    public VarNonValueNode() {
        this.codeName = "$" + (varNum++);
    }

    public VarNonValueNode(String codeName) {
        this.codeName = codeName;
    }


    @Override
    public TreeNode copy() {
        TreeNode n = new VarNonValueNode(this.codeName);
        n.parent = this.parent;
        n.parentSubstitution = this.parentSubstitution;
        return n;
    }

    @Override
    protected boolean isTerm() {
        return false;
    }

    // printers
    @Override
    public String clearNameColumn() {
        return codeName;
    }

    @Override
    public String toStringColumn() {
        return "x\n" + codeName + "\n";
    }


}
