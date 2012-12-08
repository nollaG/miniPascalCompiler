package gui;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class PascalMenuBar  extends JMenuBar
{
	Control control;
	public PascalMenuBar(Control c)
	{
		control = c;
		PascalActionListener menuListener = new PascalActionListener(control);
		JMenu file = new JMenu("File");
		JMenu parse = new JMenu("Parse");
		file.setMnemonic(KeyEvent.VK_F);
		parse.setMnemonic(KeyEvent.VK_P);
		this.add(file);
		this.add(parse);
		JMenuItem newMenuItem = new JMenuItem("新建");
		newMenuItem.setActionCommand("new");
		JMenuItem openMenuItem = new JMenuItem("打开");
		openMenuItem.setActionCommand("open");
		JMenuItem saveMenuItem = new JMenuItem("保存");
		saveMenuItem.setActionCommand("save");
		JMenuItem saveAsMenuItem = new JMenuItem("另存为");
		saveAsMenuItem.setActionCommand("saveAs");
		JMenuItem saveConsoleMenuItem = new JMenuItem("存储输出");
		saveConsoleMenuItem.setActionCommand("saveConsole");
		JMenuItem quitMenuItem = new JMenuItem("退出");
		quitMenuItem.setActionCommand("quit");
		JMenuItem laMenuItem = new JMenuItem("词法分析");
		laMenuItem.setActionCommand("lexAnalysis");
		JMenuItem saMenuItem = new JMenuItem("语法分析");
		saMenuItem.setActionCommand("synAnalysis");
		JMenuItem pcMenuItem = new JMenuItem("词法检查");
		pcMenuItem.setActionCommand("parCheck");
		JMenuItem agMenuItem = new JMenuItem("汇编生成");
		agMenuItem.setActionCommand("asmGenerate");
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke('N',InputEvent.CTRL_DOWN_MASK));
		openMenuItem.setAccelerator(KeyStroke.getKeyStroke('O',InputEvent.CTRL_DOWN_MASK));
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke('S',InputEvent.CTRL_DOWN_MASK));
		quitMenuItem.setAccelerator(KeyStroke.getKeyStroke('Q',InputEvent.CTRL_DOWN_MASK));

		
		newMenuItem.addActionListener(menuListener);
		openMenuItem.addActionListener(menuListener);
		saveMenuItem.addActionListener(menuListener);
		saveAsMenuItem.addActionListener(menuListener);
		quitMenuItem.addActionListener(menuListener);
		saveConsoleMenuItem.addActionListener(menuListener);
		laMenuItem.addActionListener(menuListener);
		saMenuItem.addActionListener(menuListener);
		pcMenuItem.addActionListener(menuListener);
		agMenuItem.addActionListener(menuListener);
		file.add(newMenuItem);
		file.add(openMenuItem);
		file.add(saveMenuItem);
		file.add(saveAsMenuItem);
		file.add(saveConsoleMenuItem);
		file.add(quitMenuItem);
		parse.add(laMenuItem);
		parse.add(saMenuItem);
		parse.add(pcMenuItem);
		parse.add(agMenuItem);
		
	}
}
