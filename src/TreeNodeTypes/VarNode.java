package TreeNodeTypes;


import LProgramm.LProgramRuntimeException;

public class VarNode extends TreeNode {


    private String name;

    private boolean cashedTreeValue = false;
    private TreeNode valueTree = null;


    public VarNode(String name) {
        this.name = name;
    }

    private TreeNode getTreeValue() {

//        if (valueTree != null) {
//            return valueTree;
//        }
//
//        if (!cashedTreeValue) {
//            valueTree = super.findVarInContext(this.name);
//            cashedTreeValue = true;
//        }
        // TODO оптимизировать запросыы на верх, хранить только
        // ссылку в контексте 
        TreeNode t = super.findVarInContext(this.name);

        return t;

    }


    @Override
    public String toString() {

        if (getTreeValue() != null) {
            return "x\n" + getTreeValue().toString() + "\n";
        }

        return "x\n" + name + "\n";

    }

    @Override
    public TreeNode clone() {

        VarNode n = new VarNode(this.name);
        n.parent = this.parent;
        n.parentSubstitution = this.parentSubstitution;
        return n;

    }

    @Override
    public TreeNode evaluate() throws LProgramRuntimeException {
        TreeNode t = this.findVarInContext(this.name);
        if(t != null){
            return t.evaluate();
        }
        return this.clone();
    }
    
}
