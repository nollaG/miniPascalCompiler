package codeGenerator;

import java.util.Iterator;
import java.util.LinkedList;

public class RecordType extends Type {
	private LinkedList<Component> componentList;
	public RecordType() {
		componentList=new LinkedList<Component>();
	}
	public void addComponent(Component t) {
		componentList.add(t);
	}
	public void clearComponent() {
		componentList.clear();
	}
	@Override
	public int getTypeSize() {
		// TODO Auto-generated method stub
		int total=0;
		Iterator<Component> ti=componentList.iterator();
		while (ti.hasNext()) {
			total+=ti.next().type.getTypeSize();
		}
		return total;
	}

}
