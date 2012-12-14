package codeGenerator;

import compiler.Token;

public class GenerateException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6050134156070220518L;

	public GenerateException(String s) {
		super(s);
	}
	
	public GenerateException(String s,Token t) {
		super(init(s,t));
	}
	
	private static String init(String s,Token t) {
		if (t!=null)
			return String.format("%s\nLine %d,Column %d.\n",s,t.beginLine,t.beginColumn);
		else
			return s+"\n";
	}
}
