package TreeNodeTypes;


public class OperationNode extends TreeNode{
    
    public final String operationSign;
    protected TreeNode leftTree;
    protected TreeNode rightTree;
    
    public OperationNode(String operationSign, TreeNode left, TreeNode right){        
        
        this.operationSign = operationSign;        
        this.leftTree = left;
        this.rightTree = right;
        
        this.leftTree.parent = this;
        this.rightTree.parent = this;
        
    }

    @Override
    public int getValue() {
        throw new NullPointerException("Not implemented");
    }

    @Override
    public String toString() {
        return "@\n"+ this.operationSign + "\n" + 
                leftTree.toString() + rightTree.toString();
    }

    @Override
    public TreeNode clone() {
                        
        return new OperationNode(this.operationSign,
                this.leftTree.clone(), this.rightTree.clone());
        
    }
}
