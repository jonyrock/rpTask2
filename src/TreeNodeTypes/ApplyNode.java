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
    public TreeNode evaluate() throws LProgramRuntimeException {
        
        this.function = this.function.evaluate();
        
        this.substituteArgumentOnce();
        
        return this.function.evaluate();

    }


    @Override
    public void substitute(TreeNode treeNode) throws LProgramRuntimeException {
        
        // TODO: нужно вместо этого очередь
        this.function.substitute(treeNode);
        
    }

    @Override
    public String toString() {
        return "a\n" + function.toString() + argument.toString();
    }

    @Override
    public TreeNode clone() {
        return new ApplyNode(this.function.clone(), this.argument.clone());
    }

    @Override
    protected boolean canReturnConstant() throws LProgramRuntimeException {
        //this.substituteArgumentOnce();
        return function.canReturnConstant();
    }

    @Override
    public int getConstantValue() throws LProgramRuntimeException {
        this.substituteArgumentOnce();
        return function.getConstantValue();
    }

    private boolean argumentSubstituted = false;

    private void substituteArgumentOnce() throws LProgramRuntimeException {

        if (argumentSubstituted)
            return;

        this.function.substitute(this.argument.clone());
        argumentSubstituted = true;

    }

}
