package treenodetypes;


import lprogramm.exceptions.LProgramRuntimeException;

public class ConditionNode extends TreeNode {

    private TreeNode conditionTree;
    private TreeNode trueTree;
    private TreeNode falseTree;

    public ConditionNode(TreeNode conditionTree,
                         TreeNode trueTree, TreeNode falseTree) {

        this.conditionTree = conditionTree;
        this.trueTree = trueTree;
        this.falseTree = falseTree;

        this.conditionTree.parent = this;
        this.trueTree.parent = this;
        this.falseTree.parent = this;

    }


    @Override
    public ConditionNode copy() {

        ConditionNode n = new ConditionNode(this.conditionTree.copy(),
                this.trueTree.copy(), this.falseTree.copy());

        n.parent = this.parent;
        n.parentSubstitution = this.parentSubstitution;

        return n;
    }

    @Override
    public TreeNode evaluate() throws LProgramRuntimeException {

        ConditionNode t = this.copy();
        t.conditionTree = t.conditionTree.evaluate();
        if (t.conditionTree.canReturnConstant()) {
            if (t.conditionTree.getConstantValue().value > 0) {
                return t.trueTree.evaluate();
            } else {
                return t.falseTree.evaluate();
            }
        }

        return t;
    }

    // printers

    @Override
    public String toString() {
        return "(" + this.conditionTree + " ? " + trueTree + " : " + falseTree + ")";
    }

    @Override
    public String toStringColumn() {
        return "?\n" + this.conditionTree.toStringColumn() + trueTree.toStringColumn() + falseTree.toStringColumn();
    }

}
