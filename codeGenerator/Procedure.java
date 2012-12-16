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
		t.offset=toffset+2;
		parameter_list.add(t);
		return true;
	}
	public boolean addLocalVariable(Component t) {
		int toffset=t.type.getTypeSize();
		for (int i=0;i<localvariable_list.size();++i) {
			if (localvariable_list.get(i).name.equals(t.name))
				return false;
			toffset+=localvariable_list.get(i).type.getTypeSize();
		}
		t.offset=toffset;
		localvariable_list.add(t);
		return true;
	}
	public int getTotalStackSize() {
		int total=0;
		for (int i=0;i<localvariable_list.size();++i) {
			total+=localvariable_list.get(i).type.getTypeSize();
		}
		return total;
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
	
	public boolean checkParameter(ArrayList<Type> ac) {
		if (ac.size()!=parameter_list.size()) return false;
		for (int i=0;i<ac.size();++i) {
			if (ac.get(i)!=parameter_list.get(i).type)
				return false;
		}
		return true;
	}
	
	public String toString() {
		return String.format("Procedure:%s\n" +
				"ParameterList:%s\n" +
				"LocalVariableList:%s\n",this.name,this.parameterlistToString(),this.localvariableToString());
	}
}
