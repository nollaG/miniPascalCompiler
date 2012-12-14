package codeGenerator;

public class CharType extends Type {
	int size;
	public CharType() {
		size=1;
	}
	@Override
	public int getTypeSize() {
		// TODO Auto-generated method stub
		return size;
	}

	public String toString() {
		return "CharType";
	}
}
