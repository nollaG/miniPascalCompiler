package codeGenerator;

public class Component extends Variable {
	public int offset;
	public boolean isVar=false; //used in function or procedure
	public Component(String n,Type t) {
		super(n,t);
		offset=0;
	}
	public String toString() {
		if (isVar) 
			return String.format("<var> %s,%s,off=%d",this.name,this.type.toString(),this.offset);
		else
			return String.format("%s,%s,off=%d",this.name,this.type.toString(),this.offset);
	}
}
