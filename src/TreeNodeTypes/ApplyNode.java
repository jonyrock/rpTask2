package TreeNodeTypes;

import LProgramm.LProgramRuntimeException;

public class ApplyNode extends TreeNode {

    private TreeNode function;
    private TreeNode argument;


    public ApplyNode(TreeNode function, TreeNode argument) {

        this.function = function;
        this.argument = argument;

        this.function.parent = this;
        this.argument.parent = this;

    }

    @Override
    public String toString() {
        return "a\n" + function.toString() + argument.toString();
    }

    @Override
    public ApplyNode copy() {

        ApplyNode t = new ApplyNode(this.function.copy(), this.argument.copy());
        t.parent = this.parent;
        t.parentSubstitution = this.parentSubstitution;

        return t;
    }

    @Override
    public TreeNode evaluate() throws LProgramRuntimeException {

        ApplyNode evalTree = this.copy();

        evalTree.argument = evalTree.argument.evaluate();
        evalTree.function = evalTree.function.evaluate();
        evalTree.function.substitute(evalTree.argument);
        evalTree.function = evalTree.function.evaluate();

        if (this.parentSubstitution != null) {
            evalTree.function.substitute(this.parentSubstitution.evaluate());
            evalTree.function = evalTree.function.evaluate();
        }


        if (evalTree.function.isTerm()) {
            return evalTree.function;
        } else {
            return evalTree;
        }

    }


}












