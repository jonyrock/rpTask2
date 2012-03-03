package TreeNodeTypes;


public class VarNote extends TreeNode {


    private String name;

    public VarNote(String name) {
        this.name = name;
    }

    @Override
    public TreeNode evaluate() {
        throw new NullPointerException("Not implemented");
    }

    @Override
    public String toString() {
        
        TreeNode n = super.findVarInContext(this.name);
        
        if(n!= null){
            return "x\n" + n.toString() + "\n";
        }
        
        return "x\n" + name + "\n";
        
    }

    @Override
    public TreeNode clone() {        
        return new VarNote(this.name);        
    }
    
}
