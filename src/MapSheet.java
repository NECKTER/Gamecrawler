import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class MapSheet {
	private BufferedImage map01;
	public int xholder = 0, yholder = 0;
	private boolean ispressureX = false, ispressureY = false;

	public MapSheet() {
		try {

			map01 = ImageIO.read(SpriteSheet.class.getResourceAsStream("images/Page 0.jpg"));
		} catch (IOException e) {
		}
	}

	public void drawmap(int playerX, int playerY, Graphics g, int screenwidth, int screenheight) {
		g.drawImage(map01, xholder, yholder, map01.getWidth(), map01.getHeight(), null);
	}

	public boolean moveleft(int playermoveX) {
		if (xholder + playermoveX > 1200 || xholder + playermoveX < 0) {
			ispressureX = true;
			return true;
		} else {
			xholder = xholder + playermoveX;
		}
		ispressureX = false;
		return ispressureX;
	}

	public boolean moveup(int playermoveY) {
		if (yholder + playermoveY > 1200 || yholder + playermoveY < 0) {
			ispressureY = true;
			return true;
		} else {
			yholder = yholder + playermoveY;
		}
		ispressureY = false;
		return ispressureY;
	}
	//public int[][] Putin(){
	//int [][]Stage 1=new int {
		
//	}
		
//	}

	public int getholderX() {
		return xholder;
	}

	public int getholderY() {
		return yholder;
	}
}