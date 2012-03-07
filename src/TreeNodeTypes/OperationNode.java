package TreeNodeTypes;

import LProgramm.LProgramRuntimeException;

public class OperationNode extends TreeNode {

    public final String operationSign;
    protected TreeNode leftTree;
    protected TreeNode rightTree;

    public OperationNode(String operationSign, TreeNode left, TreeNode right) {

        this.operationSign = operationSign;
        this.leftTree = left;
        this.rightTree = right;

        this.leftTree.parent = this;
        this.rightTree.parent = this;

    }

    private OperationNode(String operationSign) {
        this.operationSign = operationSign;
    }

    @Override
    public String toString() {
        return "@\n" + this.operationSign + "\n" +
                leftTree.toString() + rightTree.toString();
    }

    @Override
    public OperationNode clone() {

        OperationNode n = new OperationNode(this.operationSign,
                this.leftTree.clone(), this.rightTree.clone());

        n.parent = this.parent;
        n.parentSubstitution = this.parentSubstitution;

        return n;

    }

    @Override
    protected boolean canReturnConstant() throws LProgramRuntimeException {

        return leftTree.canReturnConstant() &&
                rightTree.canReturnConstant();

    }

    @Override
    public TreeNode evaluate() throws LProgramRuntimeException {

        OperationNode t = this.clone();
        t.leftTree = t.leftTree.evaluate();
        t.rightTree = t.rightTree.evaluate();
        
        if(t.leftTree.canReturnConstant() && t.rightTree.canReturnConstant()){
            return t.getConstantValue();
        } 
        
        
        
        return t;
        
    }

    @Override
    public ConstantNode getConstantValue() throws LProgramRuntimeException {
        
        int leftValue = leftTree.getConstantValue().value;
        int rightValue = leftTree.getConstantValue().value;
        
        if (this.operationSign.endsWith("+")) {
            return new ConstantNode(leftValue + rightValue);
        }
        if (this.operationSign.endsWith("-")) {
            return new ConstantNode(leftValue - rightValue);
        }
        if (this.operationSign.endsWith("*")) {
            return new ConstantNode(leftValue * rightValue);
        }
        if (this.operationSign.endsWith("/")) {
            return new ConstantNode(leftValue / rightValue);
        }
        if (this.operationSign.endsWith("%")) {
            return new ConstantNode(leftValue % rightValue);
        }

        throw new IllegalArgumentException("Undefined sign");

    }
    
}
