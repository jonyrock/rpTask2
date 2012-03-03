
import Compiler.*;

public class Main {
    
    public static void main(String[] args) throws Exception{
                                
        String t1 = "fact = {n -> n ? n * (fact n-1) : 1}| main = {x->x} 2";
        String t2 = "main = {x->{y->y x z}} 10;";
                      
        LCompiler compiler = new LCompiler(t2);     
        
        
        System.out.println(compiler.program.toString());                               
        
    }
    
}
