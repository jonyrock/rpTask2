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
                
        if(this.function.canSubstitute()){
            this.substituteArgumentOnce();
            return this.function.evaluate();
        }
                        
        return this.clone();

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
        return function.canReturnConstant();
    }

    @Override
    public int getConstantValue() throws LProgramRuntimeException {        
        return function.getConstantValue();
    }

    

    private void substituteArgumentOnce() throws LProgramRuntimeException {
        
        this.function.substitute(this.argument.evaluate());
        
    }

}
