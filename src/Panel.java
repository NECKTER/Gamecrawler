import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener {
	private Timer gameTimer;
	private ClipPlayer sound = new ClipPlayer();
	private SpriteSheet sheet = new SpriteSheet();
	private MapSheet map = new MapSheet();
	private ArrayList<Character> pressedKeys = new ArrayList<>();

	//private Items item = new Items(0, 0, 0, 0, null, "main");

	public Panel() {
		this.setPreferredSize(new Dimension(1600, 900));
		gameTimer = new Timer(1, this);
		setUpBindings();
	}

	private void setUpBindings() {
		//examples of keybindings
		this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "shoot");
		this.getInputMap().put(KeyStroke.getKeyStroke("released SPACE"), "shootOff");
		this.getInputMap().put(KeyStroke.getKeyStroke("W"), "Up");
		this.getInputMap().put(KeyStroke.getKeyStroke("released W"), "UpOff");
		this.getInputMap().put(KeyStroke.getKeyStroke("A"), "Left");
		this.getInputMap().put(KeyStroke.getKeyStroke("released A"), "LeftOff");
		this.getInputMap().put(KeyStroke.getKeyStroke("S"), "Down");
		this.getInputMap().put(KeyStroke.getKeyStroke("released S"), "DownOff");
		this.getInputMap().put(KeyStroke.getKeyStroke("D"), "Right");
		this.getInputMap().put(KeyStroke.getKeyStroke("released D"), "RightOff");
		this.getActionMap().put("shoot", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!pressedKeys.contains(new Character(' ')))pressedKeys.add(new Character(' '));
				System.out.println(pressedKeys);
			}
		});
		this.getActionMap().put("shootOff", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pressedKeys.contains(new Character(' '))) pressedKeys.remove(new Character(' '));
				System.out.println(pressedKeys);
			}
		});
		this.getActionMap().put("Up", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!pressedKeys.contains(new Character('W')))pressedKeys.add(new Character('W'));
				System.out.println(pressedKeys);
			}
		});
		this.getActionMap().put("UpOff", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pressedKeys.contains(new Character('W'))) pressedKeys.remove(new Character('W'));
				System.out.println(pressedKeys);
			}
		});
		this.getActionMap().put("Left", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!pressedKeys.contains(new Character('A')))pressedKeys.add(new Character('A'));
				System.out.println(pressedKeys);
			}
		});
		this.getActionMap().put("LeftOff", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pressedKeys.contains(new Character('A'))) pressedKeys.remove(new Character('A'));
				System.out.println(pressedKeys);
			}
		});
		this.getActionMap().put("Down", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!pressedKeys.contains(new Character('S')))pressedKeys.add(new Character('S'));
				System.out.println(pressedKeys);
			}
		});
		this.getActionMap().put("DownOff", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pressedKeys.contains(new Character('S'))) pressedKeys.remove(new Character('S'));
				System.out.println(pressedKeys);
			}
		});
		this.getActionMap().put("Right", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!pressedKeys.contains(new Character('D')))pressedKeys.add(new Character('D'));
				System.out.println(pressedKeys);
			}
		});
		this.getActionMap().put("RightOff", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pressedKeys.contains(new Character('D'))) pressedKeys.remove(new Character('D'));
				System.out.println(pressedKeys);
			}
		});
	}

	public void startGame() {
		// setup game then start timer
		gameTimer.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		map.drawmap(0, 0, g, this.getWidth(), this.getHeight());
//		map.moveleft(100);
		//paint what is to be seen then the game has not yet started or has ended
		if (!gameTimer.isRunning()) {

			return;
		}
		//paint game stuff

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// do stuff and then repaint

		update();
		repaint();
		//System.out.println(item.getName());
		//item.randomName();
	}

	private void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void resize(Dimension d) {
		// TODO Auto-generated method stub
		setPreferredSize(d);
		repaint();
	}
}
