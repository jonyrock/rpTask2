package compiler;

public class Preprocessor {

    private static final String[][] REPLACEMENTS = {
            {"-", " - "},
            {"- >", "->"},
            {"+", " + "},
            {"*", " * "},
            {"/", " / "},
            {"?", " ? "},
            {":", " : "},
            {"(", " ( "},
            {")", " ) "}
    };

    public final String programm;

    public Preprocessor(String programm) {
        this.programm = programm;
    }

    public String preprocess() {

        String step = programm;
        for (String[] replacement : REPLACEMENTS) {
            step = step.replace(replacement[0], replacement[1]);
        }

        while (step.contains("  ")) {
            step = step.replace("  ", " ");
        }

        return step;

    }

}
