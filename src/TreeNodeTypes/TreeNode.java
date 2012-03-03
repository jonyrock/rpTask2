package TreeNodeTypes;

import java.util.HashMap;
import java.util.Set;

public class TreeNode {
    
    public HashMap<String, TreeNode> context; 
    
    public TreeNode(){
        this.context = new HashMap<String, TreeNode>();
    }
    
    public int getValue(){
        return 0;
    }
    
    public String contextToString(){
        
        Set<String> keys = context.keySet();
        String res = "";
        
        for(String str : keys){
            res += keys + "\n";
        }
        
        return res;
        
    }
    
}
