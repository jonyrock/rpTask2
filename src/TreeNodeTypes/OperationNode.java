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
    public TreeNode evaluate() throws LProgramRuntimeException {

        this.leftTree = leftTree.evaluate();
        this.rightTree = rightTree.evaluate();

        if (this.canReturnConstant()) {

            return new ConstantNode(this.getConstantValue());

        } else {
            
            return this.clone();

        }
    }

    @Override
    public String toString() {
        return "@\n" + this.operationSign + "\n" +
                leftTree.toString() + rightTree.toString();
    }

    @Override
    public TreeNode clone() {

        TreeNode n = new OperationNode(this.operationSign,
                this.leftTree.clone(), this.rightTree.clone());

        n.parent = this.parent;

        return n;

    }

    @Override
    protected boolean canReturnConstant() throws LProgramRuntimeException {

        return leftTree.canReturnConstant() &&
                rightTree.canReturnConstant();

    }

    @Override
    public int getConstantValue() throws LProgramRuntimeException {

        if (this.operationSign.endsWith("+")) {
            return leftTree.getConstantValue() +
                    rightTree.getConstantValue();
        }
        if (this.operationSign.endsWith("-")) {
            return leftTree.getConstantValue() -
                    rightTree.getConstantValue();
        }
        if (this.operationSign.endsWith("*")) {
            return leftTree.getConstantValue() *
                    rightTree.getConstantValue();
        }
        if (this.operationSign.endsWith("/")) {
            return leftTree.getConstantValue() /
                    rightTree.getConstantValue();
        }
        if (this.operationSign.endsWith("%")) {
            return leftTree.getConstantValue() %
                    rightTree.getConstantValue();
        }

        throw new IllegalArgumentException("Undefined sign");

    }

}
