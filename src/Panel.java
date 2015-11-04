import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final boolean pressed = false;
	private Timer gameTimer;
	private long time = System.currentTimeMillis();
	private double fps = 0;
	private ClipPlayer sound = new ClipPlayer();
	private SpriteSheet sheet = new SpriteSheet();
	private MapSheet map = new MapSheet();
	private Point center = new Point(0, 0);
	private ProjectileController manager = new ProjectileController();
	private ArrayList<Character> pressedKeys = new ArrayList<>();
	
	private ArrayList<Object> trash = new ArrayList<>();
	private BufferedImage playerImage = sheet.getSoldier1();
	private BufferedImage projectileImage = sheet.getProjectile();
	private Player player = new Player((this.getWidth() / 2) - (playerImage.getWidth() / 2), (this.getHeight() / 2) - (playerImage.getHeight() / 2), playerImage.getHeight(), playerImage.getWidth(), playerImage, 10, 1);
	private double hScale = 1;
	private double wScale = 1;
	private int vpX = 0, vpY = 0;
	

    private Graphics ge;
    public int butX, butY;

    private BufferedImage titleafter;

//	private lasers lasers = new lasers();

	public Panel() {
		this.setPreferredSize(new Dimension(1600, 900));
		gameTimer = new Timer(1, this);
		setUpBindings();
	}
	
	private void setUpBindings() {
		//examples of keybindings
		this.getInputMap().put(KeyStroke.getKeyStroke("W"), "Up");
		this.getInputMap().put(KeyStroke.getKeyStroke("released W"), "UpOff");
		this.getInputMap().put(KeyStroke.getKeyStroke("A"), "Left");
		this.getInputMap().put(KeyStroke.getKeyStroke("released A"), "LeftOff");
		this.getInputMap().put(KeyStroke.getKeyStroke("S"), "Down");
		this.getInputMap().put(KeyStroke.getKeyStroke("released S"), "DownOff");
		this.getInputMap().put(KeyStroke.getKeyStroke("D"), "Right");
		this.getInputMap().put(KeyStroke.getKeyStroke("released D"), "RightOff");
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
		butX = player.getX() - this.getWidth()/2 ;
		butY = player.getY() - this.getHeight()/2 ;
	}

	@Override
	public void paint(Graphics g) {
		
		
//		map.moveleft(100);
		//g.translate(1000, 0);
		//paint what is to be seen then the game has not yet started or has ended
		g.translate(butX, butY);
	//	System.out.println(player.getX() + " "+ player.getY() + " Player");
	//	System.out.println(butX + " " + butY+ " Map");
		if (!gameTimer.isRunning()) {

			BufferedImage swag=this.scaleTitle();
			g.drawImage(swag, 0, 0, null);

			return;
		} else {
			
			
		
			map.drawmap(0, 0, g, this.getWidth()  , this.getHeight() 
					);
			player.draw(g);
		manager.render(g);
	
			
			
	
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		update();
		repaint();
		
	}

	private void update() {
		// TODO Auto-generated method stub
		moveStuff();
		fps = (1000 / (System.currentTimeMillis() - time));
		time = System.currentTimeMillis();
		manager.tick();
	
		setName(fps + "");
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
		if (pressedKeys.contains(new Character('T'))) shoot();

//		for (Objects obj : projectiles) {
//			obj.shoot();
//			if (obj.getY() > this.getHeight() || obj.getX() > this.getWidth() || obj.getY() < 0 || obj.getX() < 0) trash.add(obj);
//		}
//		projectiles.removeAll(trash);
//		trash.clear();
	}

	private void right() {
		// TODO Auto-generated method stub
	//	map.moveleft(-1);
		player.move(player.getX() + 2, player.getY());
		butX = butX -2;

	}

	private void down() {
		// TODO Auto-generated method stub
		//map.moveup(-1);
		player.move(player.getX() , player.getY() + 2);
		butY = butY - 2;
	}

	private void left() {
		// TODO Auto-generated method stub
		//map.moveleft(1);
		player.move(player.getX() - 2, player.getY());
		butX = butX +2;
	}

	private void up() {
		// TODO Auto-generated method stub
		player.move(player.getX() , player.getY() - 2);
		butY = butY + 2;
		
	}

	@Override
	public void resize(Dimension d) {
		// TODO Auto-generated method stub
		hScale = getHeight() / 900.0;
		wScale = getWidth() / 1600.0;
		setPreferredSize(d);
		repaint();
		centerPlayer();
		player.setH(hScale);
		player.setW(wScale);
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

	public void shoot() {
		// TODO Auto-generated method stub
	//	System.out.print("fasdfasd");
	manager.addBullet(new Projectile(player.getX(), player.getY(), sheet.getProjectile(), 0));
	}


	private void centerPlayer() {
		// TODO Auto-generated method stub
//		System.out.println(player.getH() + " " + player.getW());
		center.setLocation(getWidth() / 2 - player.getW() / 2, getHeight() / 2 - player.getH() / 2);
		player.move(center.x, center.y);
	}

	private BufferedImage scaleTitle() {
		AffineTransform xform = new AffineTransform();
		xform.scale(2, 2);
		AffineTransformOp op = new AffineTransformOp(xform, AffineTransformOp.TYPE_BILINEAR);
		titleafter = op.filter(sheet.gettitle(), null);
			return titleafter;
	}

	public SpriteSheet getSheet() {
		return sheet;

	}
}
