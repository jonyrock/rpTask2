import TreeNodeTypes.TreeNode;

public class Main {

    public static void main(String[] args) throws Exception {

        //String t1 = "fact = {n -> n ? n * (fact n-1) : 1}| main = {x->x} 2";
        String t2 = "i = {y->y}";

        LProgram program = new LProgram(t2);

        TreeNode tree = program.evaluate("{x-> x+2}");
        
        
        System.out.print(tree);


    }

}
