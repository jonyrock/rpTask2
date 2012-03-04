package TreeNodeTypes;

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
    public TreeNode evaluate() {

        if (this.canReturnConstant()) {

            return new ConstantNode(this.getConstantValue());

        } else {

            OperationNode newOperation = new OperationNode(this.operationSign);

            newOperation.leftTree = this.leftTree.evaluate();
            newOperation.rightTree = this.rightTree.evaluate();

            return newOperation;

        }
    }

    @Override
    public String toString() {
        return "@\n" + this.operationSign + "\n" +
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
