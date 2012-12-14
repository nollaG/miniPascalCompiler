package codeGenerator;

public class RealType extends Type {
	int size;
	public RealType() {
		size=1;
	}
	@Override
	public int getTypeSize() {
		// TODO Auto-generated method stub
		return size;
	}

	public String toString() {
		return "RealType";
	}
}
