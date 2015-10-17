import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MapSheet {
	private BufferedImage map01;
	

	public MapSheet() {
		try {
			
			map01 = ImageIO.read(SpriteSheet.class.getResourceAsStream("images/Shivum.png"));	
		} catch (IOException e) {
		}
	}
	
		public void drawmap(int playerX, int playerY, Graphics g, int screenwidth, int screenhieght ){
			g.drawImage(map01, 0, 0, 1600, 1600, null);
		}
	
}