import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
	private Point center = new Point(0, 0);
	private ArrayList<Character> pressedKeys = new ArrayList<>();
	private BufferedImage playerImage = sheet.getSoldier1();
	private Player player = new Player((this.getWidth() / 2) - (playerImage.getWidth() / 2), (this.getHeight() / 2) - (playerImage.getHeight() / 2), playerImage.getHeight(), playerImage.getWidth(), playerImage, 10, 1);

//	private Items item = new Items(0, 0, 0, 0, null, "test");

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
				if (!pressedKeys.contains(new Character(' '))) pressedKeys.add(new Character(' '));
//				System.out.println(item.getName());
//				item.randomName();
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
			}
		});
		this.getActionMap().put("Up", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!pressedKeys.contains(new Character('W'))) pressedKeys.add(new Character('W'));
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
			}
		});
		this.getActionMap().put("Left", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!pressedKeys.contains(new Character('A'))) pressedKeys.add(new Character('A'));
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
			}
		});
		this.getActionMap().put("Down", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!pressedKeys.contains(new Character('S'))) pressedKeys.add(new Character('S'));
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
			}
		});
		this.getActionMap().put("Right", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (!pressedKeys.contains(new Character('D'))) pressedKeys.add(new Character('D'));
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
			}
		});
	}

	public void startGame() {
		// setup game then start timer
		gameTimer.start();
		centerPlayer();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
//		map.moveleft(100);
		//paint what is to be seen then the game has not yet started or has ended
		if (!gameTimer.isRunning()) {
			return;
		}
		map.drawmap(0, 0, g, this.getWidth(), this.getHeight());
		player.draw(g);
		//paint game stuff

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// do stuff and then repaint
		update();
		repaint();
	}

	private void update() {
		// TODO Auto-generated method stub
		moveStuff();
	}

	private void moveStuff() {
		// TODO Auto-generated method stub
		if (pressedKeys.contains(new Character('W')) && pressedKeys.contains(new Character('S'))) {
			pressedKeys.remove(new Character('W'));
			pressedKeys.remove(new Character('S'));
		}
		if (pressedKeys.contains(new Character('A')) && pressedKeys.contains(new Character('D'))) {
			pressedKeys.remove(new Character('A'));
			pressedKeys.remove(new Character('D'));
		}
		if (pressedKeys.contains(new Character('W'))) up();
		if (pressedKeys.contains(new Character('A'))) left();
		if (pressedKeys.contains(new Character('S'))) down();
		if (pressedKeys.contains(new Character('D'))) right();
	}

	private void right() {
		// TODO Auto-generated method stub
		map.moveleft(-1);

	}

	private void down() {
		// TODO Auto-generated method stub
		map.moveup(-1);

	}

	private void left() {
		// TODO Auto-generated method stub
		map.moveleft(1);
	}

	private void up() {
		// TODO Auto-generated method stub
		map.moveup(1);

	}

	@Override
	public void resize(Dimension d) {
		// TODO Auto-generated method stub
		setPreferredSize(d);
		repaint();
		centerPlayer();
	}

	public void rotatePlayer() {
		// TODO Auto-generated method stub
		if (getMousePosition() != null) {
			double x = getMousePosition().getX() - center.getX();
			double y = getMousePosition().getY() - center.getY();
			double angle = Math.toDegrees(Math.atan(y / x));
			if (x < 0) angle += 180;
			player.setRotation(angle);
		}
	}

	private void centerPlayer() {
		// TODO Auto-generated method stub
		player.setH(((getHeight() / 900.0)));
		player.setW(((getWidth() / 1600.0)));
//		System.out.println(player.getH() + " " + player.getW());
		center.setLocation(getWidth() / 2 - player.getW() / 2, getHeight() / 2 - player.getH() / 2);
		player.move(center.getX(), center.getY());
	}
}
