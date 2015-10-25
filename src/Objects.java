import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Objects {
	public static Panel panel;
	private Rectangle myrect;
	private int x, y, h, w;
	private Image img;
	private Image img2;
	private boolean canAnimate = false;
	private int animation = 0;
	private boolean changeImg = true;
	private boolean destroyed = false;
	private static ArrayList<Integer> backroundColors = new ArrayList<>();

	public Objects(int x, int y, int h, int w, Image img) {
		this.h = h;
		this.img = img;
		this.w = w;
		this.x = x;
		this.y = y;
		this.myrect = new Rectangle(x - w / 3, y, w * 2, h);
		populateBackroundColors();
	}

	private void populateBackroundColors() {
		// TODO Auto-generated method stub
		int x = 5;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				for (int j2 = 0; j2 < x; j2++) {
					backroundColors.add(new Integer(new Color(i, 255 - j2, j).getRGB()));
				}
			}
		}
	}

	public void addImage(Image img) {
		// TODO Auto-generated method stub
		this.img2 = img;
		canAnimate = true;
	}

	public void draw(boolean changeImg, Graphics g) {
		if (!destroyed) {
			this.changeImg = changeImg;
			g.drawImage(getImage(), x, y, w, h, panel);
			this.changeImg = true;
		}
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if (!destroyed) {
			BufferedImage img = (BufferedImage) getImage();
			for (int i = 0; i < img.getHeight(); i++) {
				for (int j = 0; j < img.getWidth(); j++) {
					if (!(backroundColors.contains(new Integer(img.getRGB(j, i))))) {
						g.setColor(new Color(img.getRGB(j, i)));
						g.drawLine(x + j, y + i, x + j, y + i);
					}
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void move(double x, double y) {
		// TODO Auto-generated method stub
		this.x = (int) x;
		this.y = (int) y;
		myrect.move((int) x - w / 3, (int) y);
	}

	private Image getImage() {
		// TODO Auto-generated method stub
		if (canAnimate) {
			if (animation == 0) {
				if (changeImg) {
					animation++;
				}
				return img;
			}
			if (changeImg) {
				animation--;
			}
			return img2;
		}
		return img;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void shoot() {

	}

	public void destroy() {
		destroyed = true;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public Rectangle getRect() {
		return myrect;
	}

//	
//	
//	New Setter methods used to change in locations for all objects
//	cuz it sucks adding these in on every stupid class
//	aka codeing 101 kiddiot (not sponsored by wizard 101)
//	
//	

	public int addY(int addY) {
		this.y = addY + this.y;
		return this.y;
	}

	public int addX(int addX) {
		x = addX + x;
		return x;
	}

	public int SetX(int newX) {
		x = newX;
		return x;
	}

	public int Sety(int newY) {
		y = newY;
		return y;
	}

	public void setH(int h) {
		this.h = h;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public int getW() {
		return w;
	}
}
