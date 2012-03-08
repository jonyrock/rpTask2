import Compiler.Parsing.Exceptions.ParsingException;
import LProgramm.LProgram;
import TreeNodeTypes.TreeNode;

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
                TreeNode tree = program.evaluate(args[1]);
                System.out.print(tree);
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

        if (wasError)
            System.exit(1);

        return null;

    }

    private static void printHelp() {
        System.out.println("Written by Alexey Velikiy, Krasko Evgeniy. APTU 2012.");
        System.out.println("Usage: <FILE> [EXPR]");
        System.out.println("Example 1: input.txt");
        System.out.println("Example 2: input.txt \" {x->x + 1}{x->x + 1} 2 \" ");
        System.out.println("Parse definitions from FILE and evaluate EXPR if it is.");
    }

}
