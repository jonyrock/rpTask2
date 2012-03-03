
import Compiler.*;

public class Main {
    
    public static void main(String[] args) throws Exception{
        
        //String str = "{x -> {y -> x + y}}";

        String str = "foo = { {} } 1 32 x { { } } (12 + x) - (12 * x) foo  (4 * (8-9))";
        
        //String lstr = "{x -> {y -> x + y}} 1 2";
        //String lstr = "{n->n ? n * (fact n-1) : 1}";
        String  lstr = "fact = {n -> n ? n * (fact n-1) : 1}; main = {x->x} 2";
        
        //TreeNode root = new Parser(lstr).parse();

        LCompiler compiler = new LCompiler(lstr);
        
        
        System.out.println(compiler.program.toString());
        
        
        //Parser parser = new Parser(str);
        //parser.parse();
        
        
    }
    
}
