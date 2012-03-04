package TreeNodeTypes;


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
    public TreeNode evaluate() {
        return this.clone();
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
    public TreeNode clone() {
        return new VarNonValueNode(this.codeName);
    }
}
