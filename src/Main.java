import compiler.parsing.exceptions.ParsingException;
import lprogramm.LProgram;
import treenodetypes.TreeNode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        if (args.length < 1) {
            printHelp();
            return;
        }

        String defs = getDefs(args[0]);

        LProgram program = null;

        try {
            program = new LProgram(defs);
        } catch (ParsingException e) {
            System.err.println("Parsing defs error: " + e.getMessage());
            printHelp();
            System.exit(2);
        }

        if (args.length < 2) {
            System.out.println(program.root);
        } else {
            try {
                TreeNode tree = program.evaluate("{x->(x 1)+(x 1)}{x->x+x}");
                System.out.println(tree.toString());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }

    private static String getDefs(String path) {

        FileReader reader = null;
        boolean wasError = false;

        try {

            reader = new FileReader(path);
            BufferedReader bf = new BufferedReader(reader);
            String s = "";

            while (bf.ready()) {
                s += bf.readLine();
            }

            return s;

        } catch (FileNotFoundException e) {

            System.out.println("Can't open file");
            wasError = true;

        } catch (IOException e) {

            System.err.println(e.getMessage());

        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        if (wasError) {
            System.exit(1);
        }

        return null;

    }

    private static void printHelp() {
        System.out.println("Written by Alexey Velikiy, Evgeniy Krasko. APTU 2012.");
        System.out.println("Usage: rpTask2 <FILE> [EXPR]");
        System.out.println("Parse definitions from FILE and evaluate EXPR if it is.");
        System.out.println();
        System.out.println("example 1: rpTask2 input.txt");
        System.out.println("example 2: rpTask2 input.txt \" {x-> defF x + 1} 2 \" ");
        System.out.println("In example 2 function defF defined in file input.txt");
        System.out.println("with others like this: \"defF = {x->x*x}; id={x->x}; pi = 314\"");

    }

}
