package codeGenerator;

public class Variable {
	public String name;
	public Type type;
	public Variable(String n,Type t) {
		name=n;
		type=t;
	}
	public String toString() {
		return String.format("%s,%s",this.name,this.type.toString());
	}
}
