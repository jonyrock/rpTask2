package TreeNodeTypes;


public class VarNote extends TreeNode {


    private String name;

    private boolean cashedTreeValue = false;
    private TreeNode valueTree = null;


    public VarNote(String name) {
        this.name = name;
    }

    private TreeNode getTreeValue() {
        
        if(valueTree != null){            
            return valueTree;
        }
        
        if (!cashedTreeValue) {
            valueTree = super.findVarInContext(this.name);            
            cashedTreeValue = true;                               
        }
        
        return valueTree;
        
    }

    @Override
    public TreeNode evaluate() {
        throw new NullPointerException("Not implemented");
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
        return new VarNote(this.name);
    }

    @Override
    protected boolean canReturnConstant() {
        
        if(getTreeValue() == null)
            return false;
        
        return getTreeValue().canReturnConstant();
        
    }

    @Override
    public int getConstantValue() {
        return getTreeValue().getConstantValue();
    }

}
