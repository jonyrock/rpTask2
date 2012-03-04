public class Main {

    public static void main(String[] args) throws Exception {

        //String t1 = "fact = {n -> n ? n * (fact n-1) : 1}| main = {x->x} 2";
        String t2 = "main = {x->{y->y x z}} 10; i = {x->x + x}";

        LProgram program = new LProgram(t2);
        
        System.out.print(program.evaluate("i 2"));


    }

}
