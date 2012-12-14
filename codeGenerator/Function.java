package codeGenerator;

import java.util.LinkedList;

public class Function extends Procedure{
	public Type resultType;
	public Function() {super();}
	public Function(String n,Type t) {
		super(n);
		resultType=t;
	}
	

	public String toString() {
		return String.format("Function:%s\n" +
				"ParameterList:%s\n" +
				"ReturnType:%s\n" +
				"LocalVariableList:%s\n",this.name,this.parameterlistToString(),resultType.toString(),this.localvariableToString());
	}
}
