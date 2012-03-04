package TreeNodeTypes;


import LProgramm.LProgramRuntimeException;

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

    private ConditionNode() {
    }

    @Override
    public TreeNode evaluate() throws LProgramRuntimeException {

        if (conditionTree.canReturnConstant()) {

            if (conditionTree.getConstantValue() > 0) {
                return trueTree.evaluate();
            } else {
                return falseTree.evaluate();
            }

        }

        ConditionNode evalChildsTree = new ConditionNode();
        evalChildsTree.conditionTree = this.conditionTree.clone();
        evalChildsTree.trueTree = this.trueTree.evaluate();
        evalChildsTree.falseTree = this.falseTree.evaluate();

        return evalChildsTree;

    }

    @Override
    public String toString() {
        return "?\n" + this.conditionTree.toString() +
                trueTree.toString() + falseTree.toString();
    }

    @Override
    public TreeNode clone() {
        return new ConditionNode(this.conditionTree.clone(),
                this.trueTree.clone(), this.falseTree.clone());
    }

    @Override
    protected boolean canReturnConstant() throws LProgramRuntimeException {

        return conditionTree.canReturnConstant() &&
                trueTree.canReturnConstant() && falseTree.canReturnConstant();

    }

    @Override
    public int getConstantValue() throws LProgramRuntimeException {

        if (conditionTree.getConstantValue() > 0) {
            return trueTree.getConstantValue();
        }

        return falseTree.getConstantValue();

    }


}
