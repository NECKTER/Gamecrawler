import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Frame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Panel panel;
	private long lastTurn = System.currentTimeMillis();

	public Frame() {
		super("0");
		setLayout(new BorderLayout());
		createMenus();
		setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new Panel();
		this.add(panel);
		pack();
		this.setVisible(true);
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				panel.shoot();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				if (System.currentTimeMillis() - lastTurn > 10) {
					lastTurn = System.currentTimeMillis();
					panel.rotatePlayer();
					setTitle(panel.getName());
				}
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				if (System.currentTimeMillis() - lastTurn > 10) {
					lastTurn = System.currentTimeMillis();
					panel.rotatePlayer();
				}
			}
		});
		addComponentListener(new ComponentListener() {

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentResized(ComponentEvent e) {

//				System.out.println(e.getComponent().getHeight());
//				System.out.println(e.getComponent().getWidth());
				panel.resize(new Dimension(e.getComponent().getWidth(), e.getComponent().getHeight()));

			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub

			}
		});
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
