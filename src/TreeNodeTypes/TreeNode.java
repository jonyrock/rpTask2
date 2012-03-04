package TreeNodeTypes;

import java.util.HashMap;
import java.util.Set;

public class TreeNode {

    public HashMap<String, TreeNode> context;
    public TreeNode parent;

    public TreeNode() {
        this.context = new HashMap<String, TreeNode>();
    }

    public TreeNode evaluate() {
        throw new NullPointerException("Not implemented");
    }

    public TreeNode clone() {
        
        TreeNode newTree = new TreeNode();
        newTree.context = this.cloneContext();

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

//        HashMap<String, TreeNode> newContext = new HashMap<String, TreeNode>(context.size());
//
//        for (String key : this.context.keySet()) {
//            newContext.put(key, this.context.get(key).clone());
//        }

//         return newContext;
        return (HashMap<String, TreeNode>) this.context.clone();

    }
    
    protected boolean canReturnConstant(){
        return false;
    }
    
    public int getConstantValue(){
        throw new NullPointerException("Not implemented");
    }
    
    public void substitute(TreeNode treeNode){
        throw new NullPointerException("Not implemented");
    }
    
    public String clearName(){
        return this.toString();
    }
    
}
