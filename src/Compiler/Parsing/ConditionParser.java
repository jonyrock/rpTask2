package Compiler.Parsing;

import Compiler.Parsing.Exceptions.ParsingException;
import TreeNodeTypes.ConditionNode;
import TreeNodeTypes.TreeNode;

import java.util.ArrayList;

public class ConditionParser extends Parser {

    public ConditionParser(ArrayList<String> levelTokens) {
        super(null);
        if (levelTokens.size() != 5)
            throw new IllegalArgumentException("Expect 5 terms for condition");

        super.levelTokens = levelTokens;
    }

    @Override
    public TreeNode parse() throws ParsingException {
        
        if(!levelTokens.get(1).equals("?")){
            throw new ParsingException("Expect \"?\" in condition");
        }
        if(!levelTokens.get(3).equals(":")){
            throw new ParsingException("Expect \":\" in condition");
        }
        
        return new ConditionNode(
                new Parser(levelTokens.get(0)).parse(),
                new Parser(levelTokens.get(2)).parse(),
                new Parser(levelTokens.get(4)).parse()
        );


    }

}
