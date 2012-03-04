import LProgramm.LProgram;
import TreeNodeTypes.TreeNode;

public class Main {

    public static void main(String[] args) throws Exception {

        //String t1 = "fact = {n -> n ? n * (fact n-1) : 1}| main = {x->x} 2";
        String t2 = "i = {y->y + y + z}";

        LProgram program = new LProgram(t2);

        //TreeNode tree = program.evaluate("{x-> {y-> (i x) + 2 }} 2 1");

        TreeNode tree = program.evaluate("{ x -> (i 2) + x} 1");

        System.out.print(tree);


    }

}
