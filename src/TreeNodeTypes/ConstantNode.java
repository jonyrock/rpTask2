package TreeNodeTypes;


public class ConstantNode extends TreeNode {

    final int value;

    public ConstantNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "!\n" + value + "\n";
    }

    @Override
    public TreeNode clone() {

        ConstantNode n = new ConstantNode(this.value);
        n.parent = this.parent;
        n.parentSubstitution = this.parentSubstitution;
        return n;

    }


}
