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
    public int getValue() {
        throw new NullPointerException("Not implemented");
    }

    @Override
    public String toString() {
        return codeName;
    }

    @Override
    public TreeNode clone() {
        return new VarNonValueNode(this.codeName);
    }
}
