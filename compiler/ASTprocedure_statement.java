/* Generated By:JJTree: Do not edit this line. ASTprocedure_statement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package compiler;

import java.util.ArrayList;

import codeGenerator.Component;
import codeGenerator.GenerateException;
import codeGenerator.GeneratorContext;
import codeGenerator.Type;

public
class ASTprocedure_statement extends SimpleNode {
  public ASTprocedure_statement(int id) {
    super(id);
  }

  public ASTprocedure_statement(Pascal p, int id) {
    super(p, id);
  }
  
  public Object generateCode(GeneratorContext gc) throws GenerateException{
	  if (children!=null && children.length>0) {
		  if (children[0]!=null && children[0] instanceof ASTprocedure_identifier) {
			  ASTprocedure_identifier api=(ASTprocedure_identifier)children[0];
			  if (api.children!=null && api.children.length>0 && api.children[0]!=null && api.children[0] instanceof ASTidentifier) {
				  Token procedure_token=((ASTidentifier)api.children[0]).getToken();
				  if (gc.globalProcedureMap.containsKey(procedure_token.image)) {
					  //TODO:have procedure
				  } else {
					  throw new GenerateException(String.format("Don't have Procedure '%s'!", procedure_token.image),procedure_token);
				  }
				  
				  
				  
				  if (children.length>1) {
					  if (children[1]!=null && children[1] instanceof ASTactual_parameter_list) {
						  ArrayList<Type> at=((ASTactual_parameter_list)children[1]).getParameterList(gc);
						  if (!gc.globalProcedureMap.get(procedure_token.image).checkParameter(at)) {
							  throw new GenerateException("Parameter Error!\n",procedure_token);
						  }
					  }
				  } else {
					  if (!gc.globalProcedureMap.get(procedure_token.image).checkParameter(new ArrayList<Type>())) {
						  throw new GenerateException("Parameter Error!\n",procedure_token);
					  }
				  }
			  } else {
				  throw new GenerateException("Something Very Bad!\n");
			  }
			  return null;
		  }
	  }
	  throw new GenerateException("Something Very Bad!\n");
  }

}
/* JavaCC - OriginalChecksum=f0df0906fca8189ccc79580671a9787c (do not edit this line) */
