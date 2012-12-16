package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PascalActionListener implements ActionListener{

	Control control;
	public PascalActionListener(Control c)
	{
		control = c;
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String command = evt.getActionCommand();
		if("open".equals(command)) {
			control.pressedOpenButton();
			return;
		}
		if("new".equals(command)) {
			control.pressedNewButton();
			return;
		}
		if("save".equals(command)) {
			control.pressedSaveButton();
			return;
		}
		if("saveAs".equals(command)) {
			control.pressedSaveAsButton();
			return;
		}
		if("saveConsole".equals(command)) {
			control.pressedSaveConsoleButton();
			return;
		}
		if ("quit".equals(command)) {
			System.exit(0);
		}
		if("lexAnalysis".equals(command)) {
			control.pressLexAnalysisButton();
		}
		if("synAnalysis".equals(command)) {
			control.pressSynAnalysisButton();
		}
		if ("parCheck".equals(command)) {
			control.pressTypeCheckingButton();
		}
		if ("asmGenerate".equals(command)) {
			control.pressAsmGenerateButton();
		}
	}

}
