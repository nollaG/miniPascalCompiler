package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
public class PascalConsole extends JPanel{
	Control control;
	JTextArea text;
	public PascalConsole(Control c,int height) {
		// TODO Auto-generated constructor stub
		control = c;
		this.setPreferredSize(new Dimension(1366,height));
		text=new JTextArea();
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setEditable(false);
		JScrollPane textWithScrollBar = new JScrollPane(text);
		textWithScrollBar.setPreferredSize(new Dimension(1350,height-20));
		textWithScrollBar.setHorizontalScrollBar(textWithScrollBar.createHorizontalScrollBar());
		textWithScrollBar.setVerticalScrollBar(textWithScrollBar.createVerticalScrollBar());
		textWithScrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		textWithScrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(textWithScrollBar,BorderLayout.CENTER);
	}
	
	public void setText(String s) {
		text.setText(s);
	}
	public String getText() {
		return text.getText();
	}
}
