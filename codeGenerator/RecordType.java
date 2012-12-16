package codeGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class RecordType extends Type {
	public ArrayList<Component> componentList;
	public RecordType() {
		componentList=new ArrayList<Component>();
	}
	public boolean addComponent(Component t) {
		int tot=0;
		for (int i=0;i<componentList.size();++i) {
			if (componentList.get(i).name.equals(t.name))
				return false;
			tot+=componentList.get(i).type.getTypeSize();
		}
		t.offset=tot;
		componentList.add(t);
		return true;
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
	public String toString() {
		String tmp="[Record] ";
		Iterator<Component> it=componentList.iterator();
		while (it.hasNext()) {
			Component tmp2=it.next();
			tmp+=String.format("name=%s,Type=%s;",tmp2.name,tmp2.type.toString());
		}
		return tmp;
	}

}
