package Compiler.Parsing;

import Compiler.Parsing.Exceptions.ParsingException;
import TreeNodeTypes.ApplyNode;
import TreeNodeTypes.TreeNode;

import java.util.ArrayList;

public class Parser {

    protected final String expression;

    protected ArrayList<String> levelTokens = null;

    public Parser(String expression) {
        
        this.expression = expression;

    }

    public TreeNode parse() throws ParsingException {
        
        if (levelTokens == null){
            fillLevelTokens();
        }

        if (levelTokens.size() == 3) {
            String sign = levelTokens.get(1);
            if (sign.equals("+") || sign.equals("-") ||
                    sign.equals("*") || sign.equals("/")) {

                return new OperationParser(levelTokens).parse();

            }
        }

        raiseBracketsForOperations();
        
        if(levelTokens.size() == 5){
            if(levelTokens.get(1).equals("?")){
                return new ConditionParser(this.levelTokens).parse();
            }
        }

        if (levelTokens.size() == 1) {
            return singleParse();
        }

        // application case

        String lastExp = levelTokens.get(levelTokens.size() - 1);
        levelTokens.remove(levelTokens.size() - 1);


        return new ApplyNode(this.parse(), new Parser(lastExp).parse());

    }

    private void raiseBracketsForOperations() {
        raiseBracketsForOperation("*");
        raiseBracketsForOperation("/");
        raiseBracketsForOperation("-");
        raiseBracketsForOperation("+");
    }

    private void raiseBracketsForOperation(String operation) {
        int i;
        while ((i = levelTokens.indexOf(operation)) > 0) {
            levelTokens.set(i,
                    "(" + levelTokens.get(i - 1) + " " + operation + " "
                            + levelTokens.get(i + 1) + ")"
            );
            levelTokens.remove(i - 1);
            // offset to left
            levelTokens.remove(i);
        }
    }

    private TreeNode singleParse() throws ParsingException {

        char firstChar = this.levelTokens.get(0).charAt(0);

        if (firstChar == '{') {
            return new FunctionParser(this.levelTokens.get(0)).parse();
        }

        if (firstChar == '(') {
            String cutExpression = this.levelTokens.get(0);
            cutExpression = cutExpression.substring(1, cutExpression.length() - 1);
            return new Parser(cutExpression).parse();
        }

        if (Character.isDigit(firstChar)) {
            return new ConstantParser(this.levelTokens.get(0)).parse();
        }
        if (Character.isLetter(firstChar)) {
            return new VarParser(this.levelTokens.get(0)).parse();
        }

        throw new ParsingException("Can't detect term");


    }

    private void fillLevelTokens() throws ParsingException {

        levelTokens = new ArrayList<String>();

        int cursor = 0;
        while (cursor < expression.length()) {

            if (expression.charAt(cursor) == ' ') {
                cursor++;
                continue;
            }

            if (expression.charAt(cursor) == '(') {

                int begin = cursor;
                int end = getTokenOpenBracket(cursor, '(', ')');

                this.levelTokens.add(expression.substring(begin, end));

                cursor = end;

            } else if (expression.charAt(cursor) == '{') {

                int begin = cursor;
                int end = getTokenOpenBracket(cursor, '{', '}');

                this.levelTokens.add(expression.substring(begin, end));

                cursor = end;

            } else {

                int begin = cursor;
                int end = getTokenWhileNoSpace(cursor);

                this.levelTokens.add(expression.substring(begin, end));

                cursor = end;

            }

        }

    }

    // return position after term
    private int getTokenWhileNoSpace(int i) throws ParsingException {

        while (expression.charAt(i) == ' ') {
            i++;
            if (i == expression.length()) {
                return i;
            }
        }

        while (true) {

            i++;
            if (i == expression.length()) {
                return i;
            }

            if (expression.charAt(i) == ' ') {
                return i;
            }

        }

    }

    // return position after term       
    private int getTokenOpenBracket(int i, char openChar, char closeChar) throws ParsingException {

        if (expression.charAt(i) != openChar) {
            throw new ParsingException("Expected \"" + openChar + "\"");
        }

        int count = 1;

        while (count != 0) {

            i++;

            if (expression.length() == i) {
                throw new ParsingException("Expected \"" + closeChar + "\" but rich end of expression");
            }


            if (expression.charAt(i) == openChar) {
                count++;
                continue;
            }

            if (expression.charAt(i) == closeChar) {
                count--;
                continue;
            }

        }

        i++;

        return i;

    }

}
