package TreeNodeTypes;

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
    public TreeNode evaluate() {
        this.function.substitute(this.argument);
        return this.function.evaluate();
    }

    @Override
    public String toString() {
        return "a\n" + function.toString() + argument.toString();
    }

    @Override
    public TreeNode clone() {
        return new ApplyNode(this.function.clone(), this.argument.clone());
    }
    
}
