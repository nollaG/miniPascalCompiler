package codeGenerator;

import java.util.ArrayList;

public class RegisterManager {
	private ArrayList<Register> registerList;
	
	public RegisterManager() {
		registerList=new ArrayList<Register>();
		registerList.add(new Register("rax"));
		registerList.add(new Register("rbx"));
		registerList.add(new Register("rcx"));
		registerList.add(new Register("rdx"));
	}
	
	public Register getFreeRegister() throws GenerateException{
		for (int i=0;i<registerList.size();++i) {
			if (registerList.get(i).acquire())
				return registerList.get(i);
		}
		throw new GenerateException("Register allocation failed!");
	}
	
	public void clear() {
		for (int i=0;i<registerList.size();++i) {
			registerList.get(i).isFree=true;
		}
	}
	
	public boolean checkAllFree() {
		for (int i=0;i<registerList.size();++i) {
			if (registerList.get(i).isFree==false)
				return false;
		}
		return true;
	}
	
	public Register getRegisterByName(String s) {
		for (int i=0;i<registerList.size();++i) {
			if (registerList.get(i).registerName.equals(s)) {
				return registerList.get(i);
			}
		}
		return null;
	}
}
