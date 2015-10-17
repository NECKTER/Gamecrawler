import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Frame extends JFrame implements ActionListener {
	Panel panel;

	public Frame() {
		super("Neon Shivam");
		setLayout(new BorderLayout());
		createMenus();
		setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new Panel();
		this.add(panel);
		pack();
		this.setVisible(true);
	}

	private void createMenus() {
		// TODO Auto-generated method stub
		JMenuBar menuBar = new JMenuBar();
		menuBar.setVisible(true);
		JMenu fileMenu = new JMenu("Game");
		JMenuItem newItem = new JMenuItem("Start");
		newItem.addActionListener(this);// this allows the JMenuItem called newItem to tell the Frame that someone has chosen "new"
		fileMenu.add(newItem);
		menuBar.add(fileMenu);
		//menuBar.setUI(new BasicMenuBarUI());
		setJMenuBar(menuBar);
		//add(menuBar, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		panel.startGame();
	}
}
