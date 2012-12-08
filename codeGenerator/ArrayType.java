package codeGenerator;

public class ArrayType extends Type {
	Type elementType;
	int low,high;
	public ArrayType(Type e,int l,int h) {
		elementType=e;
		low=l;
		high=h;
	}
	@Override
	public int getTypeSize() {
		// TODO Auto-generated method stub
		if (high<low) return 0;
		return elementType.getTypeSize()*(high-low+1);
	}

}
