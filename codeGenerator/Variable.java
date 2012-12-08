package codeGenerator;

public class Variable {
	public String name;
	public Type type;
	public int offset=-1; //if offset==-1 means global variable
	public Variable(String n,Type t) {
		name=n;
		type=t;
	}
}
