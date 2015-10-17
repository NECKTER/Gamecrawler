import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private BufferedImage main, map01;
	

	public SpriteSheet() {
		try {
			main = ImageIO.read(SpriteSheet.class.getResourceAsStream("images/angry_birds.png"));
			map01 = ImageIO.read(SpriteSheet.class.getResourceAsStream("images/Shivum.png"));	
		} catch (IOException e) {
		}
	}
	public BufferedImage getMap(){
		return map01;
	}
}
