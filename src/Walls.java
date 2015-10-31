import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;



public class Walls extends Object {
	private BufferedImage image;
	private boolean solid;
	public void draw(Graphics g,int x, int y,int heightWidth) {
		g.drawImage(image, x, y, heightWidth, heightWidth, null);
	}
	public boolean isSolid() {
		return solid;
	}
	public BufferedImage getImage() {
		return image;
	}


}
