package compiler;

import java.io.ByteArrayInputStream;
import java.io.StringReader;

public class PascalCompiler {
    private static final int RW_FIRST = PascalConstants.AND;
    private static final int RW_LAST  = PascalConstants.WRITELN;

    private static final int SS_FIRST = PascalConstants.PLUS;

    private static final String specials[] = {
        "PLUS", "MINUS", "STAR", "SLASH", "COLON_EQUALS",
        "DOTDOT", "DOT", "COMMA", "SEMICOLON", "COLON", "QUOTE", "UP_ARROW",
        "EQUALS", "NOT_EQUALS", "LESS_THAN", "LESS_EQUALS",
        "GREATER_THAN", "GREATER_EQUALS",
        "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACKET", "RIGHT_BRACKET",
        "LEFT_BRACE", "RIGHT_BRACE"
    };
	public static String lexicalAnalysis(String in) {
		StringReader sr=new StringReader(in);
        SimpleCharStream scs = new SimpleCharStream(sr);
        PascalTokenManager mgr = new PascalTokenManager(scs);
        
        StringBuilder line=new StringBuilder();
        try{
        	for (Token t=mgr.getNextToken();t.kind!=PascalConstants.EOF;t=mgr.getNextToken()) {
        		int kind=t.kind;
        		if ((kind >= RW_FIRST) && (kind <= RW_LAST)) {
        			line.append("Reserved Words :"+t.image);
        		}
        		else if (kind == PascalConstants.IDENTIFIER) {
        			line.append("Identifier     :"+t.image);
        		}
        		else if (kind == PascalConstants.STRING) {
        			line.append("String         :"+t.image);
        		}
        		else if (kind == PascalConstants.INTEGER_NUM) {
        			line.append("Integer        :"+t.image);
        		}
        		else if (kind == PascalConstants.REAL_NUM) {
        			line.append("Real           :"+t.image);
        		}
        		else {
        			line.append("Special symbol :"+specials[t.kind - SS_FIRST]+ " -> " + t.image);
        		}
        		line.append("\n");
        	}
        	return line.toString();
        }catch(TokenMgrError e1) {
        	return "Lexical Analysis Error!\n"+e1.getMessage();
        }
    }
	public static String syntaxParsing(String in) {
		ByteArrayInputStream stream = new ByteArrayInputStream(in.getBytes());
		Pascal parser=new Pascal(stream);
		StringBuilder result=new StringBuilder();
		try{
			ASTprogram n=parser.program();
			n.dump(">",result,0);
			return result.toString();
		}catch(TokenMgrError e1) {
        	return "Lexical Analysis Error!\n"+e1.getMessage();
		}catch(ParseException e2){
			return "Syntax Parsing Error!\n"+e2.getMessage();
		}
	}
}
