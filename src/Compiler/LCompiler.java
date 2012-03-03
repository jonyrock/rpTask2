package Compiler;

import Compiler.Parsing.Exceptions.ParsingException;
import Compiler.Parsing.Parser;
import TreeNodeTypes.TreeNode;

public class LCompiler {
    
    public TreeNode program;
    
    private String sourceCode;
    
    public LCompiler(String sourceCode) throws ParsingException {
        this.sourceCode = new Preprocessor(sourceCode).preprocess();
        this.program = new Parser(this.sourceCode).parse();
    }
    
    private void fillNamesMapping(){
                
    }
    
    
}
