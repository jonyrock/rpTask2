import LProgramm.LProgram;
import TreeNodeTypes.TreeNode;

public class Main {

    public static void main(String[] args) throws Exception {

        String defs = "fact = {n -> n ? n * (fact n-1) : 1}; succ = {y-> y + 1}; m = {x -> succ x};";


        LProgram program = new LProgram(defs);


        //TreeNode tree = program.evaluate("1");
        //TreeNode tree = program.evaluate("{y-> y + 1} 1");
        //TreeNode tree = program.evaluate("m 1");
        //TreeNode tree = program.evaluate("sdf 2");
        //TreeNode tree = program.evaluate("{y-> (succ y) + (succ y) } 1");
        //TreeNode tree = program.evaluate("{a -> {b -> a + b }} 4 3");
        //TreeNode tree = program.evaluate("x?2:1");
        //TreeNode tree = program.evaluate("{x-> x ? x + x:x*x} 5");
        //TreeNode tree = program.evaluate("fact 5");

        TreeNode tree = program.evaluate("fact");

        System.out.print(tree);


    }

}
