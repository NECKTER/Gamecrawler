import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private BufferedImage main;
	private BufferedImage player;
	

	public SpriteSheet() {
		try {
			main = ImageIO.read(SpriteSheet.class.getResourceAsStream("images/angry_birds.png"));
			player = ImageIO.read(SpriteSheet.class.getResourceAsStream("images/Shivum.png"));
		} catch (IOException e) {
		}
	}
	public BufferedImage getImg(){
		return player;
	}
}
