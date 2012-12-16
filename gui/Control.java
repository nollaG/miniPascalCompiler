package gui;
import javax.swing.*;

import compiler.ParseException;
import compiler.PascalCompiler;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Control {
	PascalConsole console;
	PascalFrame frame;
	PascalMenuBar menuBar;
	PascalEditor editor;
	boolean newFile;
	File fileOpened;
	public Control()
	{
		newFile = true;
	}
	public void windowSetup()
	{	
		console = new PascalConsole(this,250);
		menuBar = new PascalMenuBar(this);
		editor = new PascalEditor(this); 
		frame = new PascalFrame(this,menuBar,editor,console);
	}
	public void windowShow()
	{
		frame.setVisible(true);
	}
	public void pressedOpenButton()
	{
		int result;
		JFileChooser fc = new JFileChooser("./");
		result = fc.showOpenDialog(frame);
		if(result != JFileChooser.APPROVE_OPTION)
			return;
		File file = fc.getSelectedFile();
		fileOpened = file;
		try {
			FileReader reader = new FileReader(file);
			editor.codeEditor.read(reader, null);
			reader.close();
			newFile = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void pressedNewButton()
	{
		if(newFile == false || editor.codeEditor.getText() .isEmpty() == false)
			pressedSaveAsButton();
		editor.codeEditor.setText("");
		newFile = true;
	}
	public void pressedSaveAsButton()
	{
		int result;
		JFileChooser fc = new JFileChooser("./");
		result = fc.showSaveDialog(frame);
		if(result != JFileChooser.APPROVE_OPTION)
			return;
		File file = fc.getSelectedFile();
		try {
			FileWriter writer = new FileWriter(file);
			editor.codeEditor.write(writer);
			writer.close();
			newFile = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void pressedSaveButton()
	{
		if(newFile == true)
		{
			pressedSaveAsButton();
			return;
		}
		try {
			FileWriter writer = new FileWriter(fileOpened);
			editor.codeEditor.write(writer);
			writer.close();
			newFile = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void pressedSaveConsoleButton()
	{
		int result;
		JFileChooser fc = new JFileChooser("./");
		result = fc.showSaveDialog(frame);
		if(result != JFileChooser.APPROVE_OPTION)
			return;
		File file = fc.getSelectedFile();
		try {
			FileWriter writer = new FileWriter(file);
			PrintWriter outputStream=new PrintWriter(writer);
			String[] lines=console.getText().split("\n");
			for (int i=0;i<lines.length;++i) {
				outputStream.println(lines[i]);
			}
			outputStream.close();
			writer.close();
			newFile = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void pressLexAnalysisButton()
	{
		console.setText(PascalCompiler.lexicalAnalysis(editor.codeEditor.getText()));
	}
	public void pressSynAnalysisButton()
	{
		console.setText(PascalCompiler.syntaxParsing(editor.codeEditor.getText()));
	}
	public void pressTypeCheckingButton() {
		console.setText(PascalCompiler.typeChecking());
	}
	public void pressAsmGenerateButton() {
		console.setText(PascalCompiler.codeGenerate());
	}
}
