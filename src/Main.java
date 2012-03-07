import LProgramm.LProgram;
import TreeNodeTypes.TreeNode;

public class Main {

    public static void main(String[] args) throws Exception {

        String t2 = "i = {y->y + y};";
        String t3 = "fact = {n -> n ? n * (fact n-1) : 1};";
        String t4 = "succ = {y-> y + 1}; m = {x -> succc x};";

        LProgram program = new LProgram(t4);
                        
        TreeNode tree = program.evaluate("{y-> (succ y) + (succ y) } 1");
        
       
        System.out.print(tree);


    }

}
