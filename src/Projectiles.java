import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Projectiles extends Objects {

	public Projectiles(int x, int y, int h, int w, BufferedImage img3) {
		super(x, y, h, w, img3);
		// TODO Auto-generated constructor stub
	}

	public Projectiles(int x, int y, int h, int w, double rotation, BufferedImage img) {
		super(x, y, h, w, rotate(img, Math.toRadians(rotation), (int) rotation));
		// TODO Auto-generated constructor stub
		setRotation(rotation);
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if (!destroyed) {
			Map<Color, ArrayList<Point>> colorMap = new HashMap<Color, ArrayList<Point>>();
			ArrayList<Color> colorList = new ArrayList<>();
			for (int i = 0; i < img.getHeight(); i++) {
				for (int j = 0; j < img.getWidth(); j++) {
					if (!(backroundColors.contains(new Integer(img.getRGB(j, i)))) && img.getRGB(j, i) != 0) {
						Color temp = new Color(img.getRGB(j, i));
						if (!colorList.contains(temp)) {
							colorList.add(temp);
						}
						colorMap.putIfAbsent(temp, new ArrayList<Point>());
						colorMap.get(temp).add(new Point(x + j - img.getWidth() / 2, y + i - img.getHeight() / 2));
					}
				}
			}
			for (Color color : colorList) {
				g.setColor(color);
				for (Point p : colorMap.get(color)) {
					g.drawLine((int) p.x, (int) p.y, (int) p.x, (int) p.y);
				}
			}
		}
	}

	protected BufferedImage getImage() {
		// TODO Auto-generated method stub
		return img;
	}

}
