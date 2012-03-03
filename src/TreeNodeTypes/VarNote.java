package TreeNodeTypes;


public class VarNote extends TreeNode {


    private String name;

    public VarNote(String name) {
        this.name = name;
    }

    @Override
    public int getValue() {
        throw new NullPointerException("Not implemented");
    }

    @Override
    public String toString() {
        return "x\n" + name + "\n";
    }
}
