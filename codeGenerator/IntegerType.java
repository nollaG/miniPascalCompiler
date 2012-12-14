package codeGenerator;

public class IntegerType extends Type {
	int size;
	public IntegerType() {
		size=1;
	}

	@Override
	public int getTypeSize() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public String toString() {
		return "IntegerType";
	}

}
