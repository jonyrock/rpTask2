package TreeNodeTypes;

import java.util.HashMap;
import java.util.Set;

public class TreeNode {
    
    public HashMap<String, TreeNode> context;
    public TreeNode parent;
    
    public TreeNode(){
        this.context = new HashMap<String, TreeNode>();        
    }
    
    public int getValue(){
        return 0;
    }
    
    @Override
    public String toString(){
        
        Set<String> keys = context.keySet();
        String res = "";
        
        for(String str : keys){
            res += str + "\n";
            res += context.get(str).toString();
        }
        
        return res;
        
    }
    
    // return null if can't find
    protected TreeNode findVarInContext(String name){
                        
        if(this.context.containsKey(name)){
            return this.context.get(name);
        }
        
        if(this.parent == null){
            return null;
        }
        
        return parent.findVarInContext(name);
        
        
    }
    
}
