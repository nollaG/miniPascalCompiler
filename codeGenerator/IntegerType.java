package codeGenerator;

public class IntegerType extends Type {
	int size;
	public IntegerType() {
		size=4;
	}

	@Override
	public int getTypeSize() {
		// TODO Auto-generated method stub
		return size;
	}

}
