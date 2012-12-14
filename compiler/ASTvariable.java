/* Generated By:JJTree: Do not edit this line. ASTvariable.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package compiler;

import codeGenerator.GenerateException;
import codeGenerator.GeneratorContext;
import codeGenerator.Type;
import codeGenerator.IntegerType;
import codeGenerator.Variable;
import codeGenerator.ArrayType;
import codeGenerator.RecordType;

public
class ASTvariable extends SimpleNode {
  public ASTvariable(int id) {
    super(id);
  }

  public ASTvariable(Pascal p, int id) {
    super(p, id);
  }

  public Object generateCode(GeneratorContext gc) throws GenerateException{//return variable type
	  return getType(gc);
  }
  public Type getType(GeneratorContext gc) throws GenerateException {
	  Type currentType=null;
	  if (children!=null) {
		  for (int i=0;i<children.length;++i) {
			  if (children[i]!=null && children[i] instanceof ASTidentifier) {
				  Variable tv=gc.getComponent(((ASTidentifier)children[i]).getName());
				  if (tv!=null) {
					  currentType=tv.type;
					  continue;
				  } else {
					  throw new GenerateException(String.format("No Such Variable '%s'!",((ASTidentifier)children[i]).getName()),((ASTidentifier)children[i]).getToken());
				  }
			  }
			  if (children[i]!=null && children[i] instanceof ASTindexed_suffix) {
				  ASTindexed_suffix ais=(ASTindexed_suffix)children[i];
				  if (ais.children!=null && ais.children[0]!=null && ais.children[0] instanceof ASTexpression_list) {
					  ASTexpression_list ael=(ASTexpression_list)ais.children[0];
					  if (ael.children!=null) {
						  for (int j=0;j<ael.children.length;++j) {
							  if (((ASTexpression)ael.children[j]).getType(gc) instanceof IntegerType) {
							  if (currentType instanceof ArrayType) {
								  currentType=((ArrayType)currentType).elementType;
							  } else {
								  throw new GenerateException("Invalid Array reference!",((ASTexpression)ael.children[j]).currentToken);
							  }
							  } else {
								  throw new GenerateException("index expression must be Integer!",((ASTexpression)ael.children[j]).currentToken);
							  }
						  }
					  }
					  
				  } else {
					  throw new GenerateException("Something Very Bad!\n");
				  }
			  }
			  if (children[i]!=null && children[i] instanceof ASTcomponent_suffix) {
				  Token t=((ASTidentifier)((ASTfield_identifier)((ASTcomponent_suffix)children[i]).children[0]).children[0]).getToken();
				  if (currentType instanceof RecordType) {
					  RecordType rt=(RecordType)currentType;
					  boolean flag=false;
					  for (int j=0;j<rt.componentList.size();++j) {
						  if (rt.componentList.get(j).name.equals(t.image)) {
							  currentType=rt.componentList.get(j).type;
							  flag=true;
							  break;
						  }
					  }
					  if (!flag) {
						  throw new GenerateException("Invalid Record reference!",t);
					  }
				  } else {
					  throw new GenerateException("Invalid Record reference!",t);
				  }
			  }
		  }
		  if (currentType==null)
			  throw new GenerateException("Something Very Bad!\n");
		/*  if (currentType instanceof ArrayType || currentType instanceof RecordType) 
			  throw new GenerateException("Invalid variable reference!",((SimpleNode)children[0]).currentToken);*/
		  return currentType;
	  }
	  throw new GenerateException("Something Very Bad!\n");
  }
}
/* JavaCC - OriginalChecksum=f22a5019d9a21f5c27e0fe80955ce4d3 (do not edit this line) */
