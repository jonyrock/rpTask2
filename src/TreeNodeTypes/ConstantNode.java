package TreeNodeTypes;


public class ConstantNode extends TreeNode {


    final int value;

    public ConstantNode(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "!\n" + value + "\n";
    }

    @Override
    public TreeNode clone() {
        return new ConstantNode(this.value);
    }
    
}
