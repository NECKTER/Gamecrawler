import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Objects {
	public static Panel panel;
	private Rectangle myrect;
	private int x, y;
	private double w;
	private double h;
	private BufferedImage original;
	private BufferedImage img;
	private BufferedImage img2;
	private boolean canAnimate = false;
	private int animation = 0;
	private boolean changeImg = true;
	private boolean destroyed = false;
	private static ArrayList<Integer> backroundColors = new ArrayList<>();
	private double rotation = 0;

	public Objects(int x, int y, int h, int w, BufferedImage img3) {
		this.h = h;
		this.img = img3;
		this.original = img3;
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

	public void addImage(BufferedImage img) {
		// TODO Auto-generated method stub
		this.img2 = img;
		canAnimate = true;
	}

	public void draw(boolean changeImg, Graphics g) {
		if (!destroyed) {
			this.changeImg = changeImg;
			g.drawImage(getImage(), x, y, (int) w, (int) h, panel);
			this.changeImg = true;
		}
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if (!destroyed) {
			BufferedImage img = rotate((BufferedImage) getImage(), Math.toRadians(rotation), (int) rotation);
			for (int i = 0; i < img.getHeight(); i++) {
				for (int j = 0; j < img.getWidth(); j++) {
					if (!(backroundColors.contains(new Integer(img.getRGB(j, i)))) && img.getRGB(j, i) != 0) {
						g.setColor(new Color(img.getRGB(j, i)));
						g.drawLine(x + j - img.getWidth() / 2, y + i - img.getHeight() / 2, x + j - img.getWidth() / 2, y + i - img.getHeight() / 2);
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
		myrect.move((int) ((int) x - w / 3), (int) y);
	}

	private Image getImage() {
		// TODO Auto-generated method stub
		if (canAnimate) {
			if (animation == 0) {
				if (changeImg) {
					animation++;
				}
				return original;
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

	public void setH(double d) {
		this.h = d;
		scale();
	}

	public void setW(double d) {
		this.w = d;
		scale();
	}

	public double getH() {
		return h;
	}

	public double getW() {
		return w;
	}

	public double getRotation() {
		return rotation;
	}

	public void setRotation(double angle) {
		this.rotation = angle;
	}

	private void scale() {
		AffineTransform xform = new AffineTransform();
		xform.scale(h, w);
		AffineTransformOp op = new AffineTransformOp(xform, AffineTransformOp.TYPE_BILINEAR);
		img = op.filter(original, null);
	}

	public void shoot() {
		// TODO Auto-generated method stub
		int x = 30;
		double y = x * Math.tan(Math.toRadians(this.rotation));
		if (!(rotation >= -90.0 && rotation <= 90.0)) x *= -1;
		if ((rotation >= 90.0 && rotation <= 270.0)) y *= -1;
		move(this.x + x, this.y + y);
	}

	private BufferedImage rotate(BufferedImage image, double _theta, int _thetaInDegrees) {

		AffineTransform xform = new AffineTransform();

		if (image.getWidth() > image.getHeight()) {
			xform.setToTranslation(0.5 * image.getWidth(), 0.5 * image.getWidth());
			xform.rotate(_theta);

			int diff = image.getWidth() - image.getHeight();

			switch (_thetaInDegrees) {
			case 90:
				xform.translate(-0.5 * image.getWidth(), -0.5 * image.getWidth() + diff);
				break;
			case 180:
				xform.translate(-0.5 * image.getWidth(), -0.5 * image.getWidth() + diff);
				break;
			default:
				xform.translate(-0.5 * image.getWidth(), -0.5 * image.getWidth());
				break;
			}
		} else
			if (image.getHeight() > image.getWidth()) {
				xform.setToTranslation(0.5 * image.getHeight(), 0.5 * image.getHeight());
				xform.rotate(_theta);

				int diff = image.getHeight() - image.getWidth();

				switch (_thetaInDegrees) {
				case 180:
					xform.translate(-0.5 * image.getHeight() + diff, -0.5 * image.getHeight());
					break;
				case 270:
					xform.translate(-0.5 * image.getHeight() + diff, -0.5 * image.getHeight());
					break;
				default:
					xform.translate(-0.5 * image.getHeight(), -0.5 * image.getHeight());
					break;
				}
			} else {
				xform.setToTranslation(0.5 * image.getWidth(), 0.5 * image.getHeight());
				xform.rotate(_theta);
				xform.translate(-0.5 * image.getHeight(), -0.5 * image.getWidth());
			}

		AffineTransformOp op = new AffineTransformOp(xform, AffineTransformOp.TYPE_BILINEAR);

		return op.filter(image, null);
	}
}
