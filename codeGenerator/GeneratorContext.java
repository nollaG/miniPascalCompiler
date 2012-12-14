package codeGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import compiler.*;

public class GeneratorContext {
	public StringBuilder code;
	public ArrayList<Variable> globalVariableList;
	public HashMap<String,Type> globalTypeMap;
	public HashMap<String,Function> globalFunctionMap;
	public HashMap<String,Procedure> globalProcedureMap;
	public Procedure currentProcedureOrFunction;
	
	private void Reset() 
	{
		code=new StringBuilder();
		globalVariableList.clear();
		globalTypeMap.clear();
		globalFunctionMap.clear();
		globalProcedureMap.clear();
		currentProcedureOrFunction=null;
		
		globalTypeMap.put("integer", new IntegerType());
		globalTypeMap.put("char", new CharType());
		globalTypeMap.put("real", new RealType());
	}
	public GeneratorContext() 
	{
		code=new StringBuilder();
		globalVariableList=new ArrayList<Variable>();
		globalTypeMap=new HashMap<String,Type>();
		globalFunctionMap=new HashMap<String,Function>();
		globalProcedureMap=new HashMap<String,Procedure>();
		
		Reset();
	}
	public String globalVariableListToString() {
		String tmp="";
		for (int i=0;i<globalVariableList.size();++i) {
			Variable t=globalVariableList.get(i);
			tmp+=String.format("\n  %s ",t.toString());
		}
		return tmp;
	}
	public boolean addGlobalVariable(Variable v) {
		for (int i=0;i<globalVariableList.size();i++)
			if (globalVariableList.get(i).name.equals(v.name))
				return false;
		globalVariableList.add(v);
		return true;
	}
	
	public Variable getComponent(String t) {
		if (currentProcedureOrFunction!=null) {
			for (int i=0;i<currentProcedureOrFunction.localvariable_list.size();++i) {
				if (currentProcedureOrFunction.localvariable_list.get(i).name.equals(t))
					return currentProcedureOrFunction.localvariable_list.get(i);
			}
			for (int i=0;i<currentProcedureOrFunction.parameter_list.size();++i) {
				if (currentProcedureOrFunction.parameter_list.get(i).name.equals(t))
					return currentProcedureOrFunction.parameter_list.get(i);
			}
		}
		for (int i=0;i<globalVariableList.size();++i) {
			if (globalVariableList.get(i).name.equals(t))
				return globalVariableList.get(i);
		}
		return null;
	}
}
