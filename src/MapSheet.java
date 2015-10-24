import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MapSheet {
	private BufferedImage map01;
	private int xholder = 0, yholder = 0;
	private boolean ispressureX = false, ispressureY = false;

	public MapSheet() {
		try {

			map01 = ImageIO.read(SpriteSheet.class.getResourceAsStream("images/Shivum.png"));
		} catch (IOException e) {
		}
	}

	public void drawmap(int playerX, int playerY, Graphics g, int screenwidth, int screenheight) {
		g.drawImage(map01, xholder, yholder, map01.getWidth(), map01.getHeight(), null);
	}

	public boolean moveleft(int playermoveX) {
		if (xholder > 1200 || xholder < 0) {
			return true;
		} else {
			xholder = xholder + playermoveX + xholder;
		}
		return ispressureX;
	}

	public boolean moveup(int playermoveY) {
		if (xholder > 1200 || xholder < 0) {
			return true;
		} else {
			xholder = yholder - playermoveY + yholder;
		}
		return ispressureY;
	}

}