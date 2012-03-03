package Compiler;

public class Preprocessor {

    public final String programm;

    public Preprocessor(String programm) {
        this.programm = programm;
    }

    public String preprocess() {

        String step = programm.replace("-", " - ");
        step = step.replace("- >", "->");
        step = step.replace("+", " + ");
        step = step.replace("*", " * ");
        step = step.replace("/", " / ");
        //step.
        
        while (step.contains("  ")) {
            step = step.replace("  ", " ");
        }

        return step;

    }

}
