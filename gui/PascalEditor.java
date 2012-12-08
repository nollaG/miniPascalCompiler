package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import javax.swing.text.Document;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
public class PascalEditor extends JPanel
{
	public RSyntaxTextArea codeEditor;
	private RTextScrollPane scrPane;
	Control control;
	public PascalEditor(Control c)
	{
		this.setLayout(new BorderLayout());
		codeEditor=new RSyntaxTextArea();
		scrPane=new RTextScrollPane(codeEditor);
		codeEditor.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_DELPHI);
		scrPane.setHorizontalScrollBar(scrPane.createHorizontalScrollBar());
		scrPane.setVerticalScrollBar(scrPane.createVerticalScrollBar());
		scrPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(scrPane,BorderLayout.CENTER);
		control = c;
		
	}
}
