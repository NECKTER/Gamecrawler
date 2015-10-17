import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private BufferedImage main;

	public SpriteSheet() {
		try {
			main = ImageIO.read(SpriteSheet.class.getResourceAsStream("images/angry_birds.png"));
		} catch (IOException e) {
		}
	}
}
