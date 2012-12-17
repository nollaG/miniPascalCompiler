/* Generated By:JJTree: Do not edit this line. ASTif_statement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package compiler;


import codeGenerator.GenerateException;
import codeGenerator.GeneratorContext;
import codeGenerator.Label;
import codeGenerator.Register;

public
class ASTif_statement extends SimpleNode {
  public ASTif_statement(int id) {
    super(id);
  }

  public ASTif_statement(Pascal p, int id) {
    super(p, id);
  }
  public Object generateCode(GeneratorContext gc) throws GenerateException{
	  if (gc.generate) {
		  if (children!=null && children.length==2) { //noelse
			  if (children[0]!=null && children[0] instanceof ASTexpression)
				  if (children[1]!=null && children[1] instanceof ASTstatement) {
					  Register expReg=((ASTexpression)children[0]).generateCode(gc);
					  Label endif=gc.labelManager.getNewLabel();
					  gc.code.append(String.format("cmp %s,0\n",expReg));
					  gc.code.append(String.format("je %s\n",endif));
					  expReg.release();
					  ((ASTstatement)children[1]).generateCode(gc);
					  gc.code.append(String.format("%s: ", endif));
					  return null;
				  }
		  } else {
			  if (children!=null && children.length==3) {
				  if (children[0]!=null && children[0] instanceof ASTexpression)
					  if (children[1]!=null && children[1] instanceof ASTstatement)
						  if (children[2]!=null && children[2] instanceof ASTstatement) {
							  Register expReg=((ASTexpression)children[0]).generateCode(gc);
							  Label falseLabel=gc.labelManager.getNewLabel();
							  Label endif = gc.labelManager.getNewLabel();
							  gc.code.append(String.format("cmp %s,0\n",expReg));
							  gc.code.append(String.format("je %s\n",falseLabel));
							  expReg.release();
							  ((ASTstatement)children[1]).generateCode(gc);
							  gc.code.append(String.format("jmp %s\n", endif));
							  gc.code.append(String.format("%s: ", falseLabel));
							  ((ASTstatement)children[2]).generateCode(gc);
							  gc.code.append(String.format("%s: ", endif));
							  return null;
						  }

			  }
		  }
	  } else {
		  simpleGenerate(gc);
	  }
	  return null;
  }

}
/* JavaCC - OriginalChecksum=f0a863d5cd1eca7a9580982db1993182 (do not edit this line) */
