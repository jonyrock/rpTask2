package TreeNodeTypes;

public class ApplyNode extends TreeNode {

    private TreeNode function;
    private TreeNode argument;

    public ApplyNode(TreeNode function, TreeNode argument) {

        this.function = function;        
        this.argument = argument;
        
        this.function.parent = this;
        // and no setting parent for argument

    }

    @Override
    public int getValue() {
        throw new NullPointerException("Not implemented");
    }

    @Override
    public String toString() {
        return "a\n" + function.toString() + argument.toString();
    }
}
