import Parsing.Parser;
import TreeNodeTypes.TreeNode;

public class Main {
    
    public static void main(String[] args) throws Exception{
        
        //String str = "{x -> {y -> x + y}}";

        String str = "foo = { {} } 1 32 x { { } } (12 + x) - (12 * x) foo  (4 * (8-9))";
        
        String lstr = "{x -> {y -> x + y}} 1 2";
        TreeNode root = new Parser(lstr).parse();
        
        System.out.println(root);
        
        
        //Parser parser = new Parser(str);
        //parser.parse();
        
        
    }
    
}
