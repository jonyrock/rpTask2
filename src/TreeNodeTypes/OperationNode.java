package TreeNodeTypes;


import Compiler.Parsing.Exceptions.ParsingException;

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
    public TreeNode evaluate() {
        if(this.canReturnConstant()){
            return new ConstantNode(this.getConstantValue());
        } else {
            return this.clone();
        }
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

    @Override
    protected boolean canReturnConstant() {

        return leftTree.canReturnConstant() && 
                rightTree.canReturnConstant();

    }

    @Override
    public int getConstantValue() {
        
        if(this.operationSign.endsWith("+")){
            return leftTree.getConstantValue() + 
                    rightTree.getConstantValue();
        }
        if(this.operationSign.endsWith("-")){
            return leftTree.getConstantValue() -
                    rightTree.getConstantValue();
        }
        if(this.operationSign.endsWith("*")){
            return leftTree.getConstantValue() *
                    rightTree.getConstantValue();
        }
        if(this.operationSign.endsWith("/")){
            return leftTree.getConstantValue() /
                    rightTree.getConstantValue();
        }
        if(this.operationSign.endsWith("%")){
            return leftTree.getConstantValue() %
                    rightTree.getConstantValue();
        }
        
        throw new IllegalArgumentException("Undefined sign");
        
    }

}
