package codeGenerator;

import java.util.ArrayList;
import java.util.LinkedList;

public class Procedure {
	public String name="";
	public ArrayList<Component> parameter_list;
	public ArrayList<Component> localvariable_list;
	public Procedure() {
		parameter_list=new ArrayList<Component>();
		localvariable_list=new ArrayList<Component>();
	}
	public Procedure(String n) {
		name=n;
		parameter_list=new ArrayList<Component>();
		localvariable_list=new ArrayList<Component>();
	}
	public boolean addParameter(Component t) {
		int toffset=0;
		for (int i=0;i<parameter_list.size();++i) {
			if (parameter_list.get(i).name.equals(t.name))
				return false;
			toffset+=parameter_list.get(i).type.getTypeSize();
		}
		t.offset=toffset;
		parameter_list.add(t);
		return true;
	}
	public boolean addLocalVariable(Component t) {
		int toffset=0;
		for (int i=0;i<localvariable_list.size();++i) {
			if (localvariable_list.get(i).name.equals(t.name))
				return false;
			toffset+=localvariable_list.get(i).type.getTypeSize();
		}
		t.offset=toffset;
		localvariable_list.add(t);
		return true;
	}
	protected String parameterlistToString() {
		String tmp="";
		for (int i=0;i<parameter_list.size();++i) {
			Component t=parameter_list.get(i);
			tmp+=String.format("\n  %s ",t.toString());
		}
		return tmp;
	}	
	
	protected String localvariableToString() {
		String tmp="";
		for (int i=0;i<localvariable_list.size();++i) {
			Component t=localvariable_list.get(i);
			tmp+=String.format("\n  %s ",t.toString());
		}
		return tmp;
	}
	
	public String toString() {
		return String.format("Procedure:%s\n" +
				"ParameterList:%s\n" +
				"LocalVariableList:%s\n",this.name,this.parameterlistToString(),this.localvariableToString());
	}
}