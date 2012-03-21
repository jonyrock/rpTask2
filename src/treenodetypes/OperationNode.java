package treenodetypes;

import lprogramm.exceptions.LProgramRuntimeException;

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


    @Override
    public OperationNode copy() {

        OperationNode n = new OperationNode(this.operationSign,
                this.leftTree.copy(), this.rightTree.copy());

        n.parent = this.parent;
        n.parentSubstitution = this.parentSubstitution;

        return n;

    }


    @Override
    public TreeNode evaluate() throws LProgramRuntimeException {

        OperationNode t = this.copy();
        t.leftTree = t.leftTree.evaluate();
        t.rightTree = t.rightTree.evaluate();

        if (t.leftTree.canReturnConstant() && t.rightTree.canReturnConstant()) {
            return t.getConstantValue();
        }


        return t;

    }

    @Override
    public ConstantNode getConstantValue() throws LProgramRuntimeException {

        int leftValue = leftTree.getConstantValue().value;
        int rightValue = rightTree.getConstantValue().value;

        if (operationSign.length() != 1) {
            throw new IllegalArgumentException("Undefined sign");
        }

        switch (operationSign.charAt(0)) {
            case '+':
                return new ConstantNode(leftValue + rightValue);
            case '-':
                return new ConstantNode(leftValue - rightValue);
            case '*':
                return new ConstantNode(leftValue * rightValue);
            case '/':
                return new ConstantNode(leftValue / rightValue);
            case '%':
                return new ConstantNode(leftValue % rightValue);
            default:
                throw new IllegalArgumentException("Undefined sign");
        }
    }


    // printers
    @Override
    public String toString() {
        return "(" + leftTree.toString() + " " + this.operationSign + " "
                + rightTree.toString() + ")";
    }

    @Override
    public String toStringColumn() {
        return "@\n" + this.operationSign + "\n" +
                leftTree.toStringColumn() + rightTree.toStringColumn();
    }

}
