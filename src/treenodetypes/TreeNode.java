package treenodetypes;

import lprogramm.exceptions.LProgramRuntimeException;

import java.util.HashMap;
import java.util.Set;

public class TreeNode {

    public HashMap<String, TreeNode> context;
    public TreeNode parent;

    protected TreeNode parentSubstitution = null;

    public TreeNode() {
        this.context = new HashMap<String, TreeNode>();
    }

    public TreeNode evaluate() throws LProgramRuntimeException {
        throw new NullPointerException("Not implemented");
    }

    public TreeNode copy() {

        TreeNode newTree = new TreeNode();
        newTree.context = this.cloneContext();
        newTree.parent = this.parent;
        newTree.parentSubstitution = this.parentSubstitution;

        return newTree;

    }

    @Override
    public String toString() {

        Set<String> keys = context.keySet();
        String res = "";

        for (String str : keys) {
            res += str + "\n";
            res += context.get(str).toString();
        }

        return res;

    }

    // return null if can't find
    protected TreeNode findVarInContext(String name) {

        if (this.context.containsKey(name)) {
            return this.context.get(name);
        }

        if (this.parent == null) {
            return null;
        }

        return parent.findVarInContext(name);


    }

    protected HashMap<String, TreeNode> cloneContext() {

        HashMap<String, TreeNode> newContext =
                new HashMap<String, TreeNode>(context.size());

        for (String key : this.context.keySet()) {
            TreeNode n = this.context.get(key).copy();
            n.parent = this.parent;
            newContext.put(key, n);
        }

        return newContext;

        //return (HashMap<String, TreeNode>) this.context.copy();

    }

    protected boolean canReturnConstant() throws LProgramRuntimeException {
        return false;
    }

    public ConstantNode getConstantValue() throws LProgramRuntimeException {
        throw new NullPointerException("Not implemented");
    }

    public void substitute(TreeNode treeNode) throws LProgramRuntimeException {
        this.parentSubstitution = treeNode.copy();
    }

    public String clearName() {
        return this.toString();
    }

    protected boolean isTerm() {
        return true;
    }

}
