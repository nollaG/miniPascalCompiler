package codeGenerator;

public class Register {
	public String registerName;
	public boolean isFree;
	
	public Register(String name) {
		registerName=name;
		isFree=true;
	}
	
	
	public boolean acquire() {
		if (isFree) {
			isFree=false;
			return true;
		} else {
			return false;
		}
	}
	
	public void release() throws GenerateException{
		if (!isFree) {
			isFree=true;
		} else {
			throw new GenerateException("Something is Wrong!Duplicate free register!\n");
		}
	}
	
	public String getLowByte() {
		return registerName.substring(1, 2)+"l";
	}
	
	public String toString() {
		return registerName;
	}
}
