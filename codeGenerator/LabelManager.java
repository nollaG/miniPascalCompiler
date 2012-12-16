package codeGenerator;

public class LabelManager {
	private int labelCount;
	public LabelManager() {
		clear();
	}
	
	public void clear() {
		labelCount=0;
	}
	
	public Label getNewLabel() {
		return new Label(String.format(".L%d", labelCount++));
	}
}
