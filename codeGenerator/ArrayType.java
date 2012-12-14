package codeGenerator;

public class ArrayType extends Type {
	public Type elementType;
	public int low,high;
	
	public ArrayType(Type e) {
		elementType=e;
		low=0;
		high=0;
	}
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
	
	public String toString() {
		if (elementType!=null)
			return String.format("[Array] low=%d,high=%d,Type=%s",low,high,elementType.toString());
		else
			return String.format("[Array] low=%d,high=%d,Type=null",low,high);
	}

}
