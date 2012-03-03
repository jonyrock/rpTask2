package TreeNodeTypes;


public class ConditionNode extends TreeNode{
    
    private TreeNode conditionTree;
    private TreeNode trueTree;
    private TreeNode falseTree;
    
    public ConditionNode(TreeNode conditionTree, 
                         TreeNode trueTree, TreeNode falseTree){
        
        this.conditionTree = conditionTree;
        this.trueTree = trueTree;
        this.falseTree = falseTree;
        
        this.conditionTree.parent = this;
        this.trueTree.parent = this;
        this.falseTree.parent = this;
        
    }

    @Override
    public int getValue() {
        throw new NullPointerException("Not implemented");
    }

    @Override
    public String toString() {
        return "?\n"+ this.conditionTree.toString() +
                trueTree.toString() + falseTree.toString();
    }

    @Override
    public TreeNode clone() {
        return new ConditionNode(this.conditionTree.clone(), 
                this.trueTree.clone(), this.falseTree.clone());
    }
    
}
