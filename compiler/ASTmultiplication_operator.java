/* Generated By:JJTree: Do not edit this line. ASTmultiplication_operator.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package compiler;

public
class ASTmultiplication_operator extends SimpleNode {
	private String opt;
  public ASTmultiplication_operator(int id) {
    super(id);
  }

  public ASTmultiplication_operator(Pascal p, int id) {
    super(p, id);
  }
  public void setOpt(String o) {
	  opt=o;
  }
  public String toString() { return "multiplication_operator \"" + opt +"\"";}

public String getOpt() {
	// TODO Auto-generated method stub
	return opt;
}
}
/* JavaCC - OriginalChecksum=695065028cc6e5a8e2ee6dabef185186 (do not edit this line) */
