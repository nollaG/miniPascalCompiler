package gui;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.*;
public class PascalFrame extends JFrame
{
	Control control;
	public PascalFrame(Control c,PascalMenuBar menuBar,PascalEditor edit,PascalConsole cle)
	{
		this.setSize(1366,768);
		this.getContentPane().add(cle,BorderLayout.SOUTH);
		this.getContentPane().add(menuBar,BorderLayout.NORTH);
		this.getContentPane().add(edit,BorderLayout.CENTER);
		this.setTitle("miniPascal IDE");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		control = c;
	}
}
