package TreeNodeTypes;


public class OperationNode extends TreeNode{
    
    public final String operationSign;
    protected TreeNode leftTree;
    protected TreeNode rightTree;
    
    public OperationNode(String operationSign, TreeNode left, TreeNode right){
        this.operationSign = operationSign;
        this.leftTree = left;
        this.rightTree = right;
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
    
}
