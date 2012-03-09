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
    public String toString() {
        return "x\n" + codeName + "\n";
    }

    @Override
    public String clearName() {
        return codeName;
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
}
