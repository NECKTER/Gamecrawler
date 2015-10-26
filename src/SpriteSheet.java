import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private BufferedImage page1;
	private BufferedImage page2;
	private BufferedImage page3;
	private BufferedImage soldier1;
	private BufferedImage wormstraight;
	private BufferedImage wormmoving;
	private BufferedImage soldier2;
	private BufferedImage squidrest;
	private BufferedImage squidprecum;
	private BufferedImage squidcumming;
	private BufferedImage robot;
	private BufferedImage soldier3;
	private BufferedImage projectile;

	public SpriteSheet() {
		try {
			page1 = ImageIO.read(SpriteSheet.class.getResourceAsStream("images/Page 0.jpg"));
			page2 = ImageIO.read(SpriteSheet.class.getResourceAsStream("images/Page 1.jpg"));
			page3 = ImageIO.read(SpriteSheet.class.getResourceAsStream("images/Page 2.jpg"));
		} catch (IOException e) {
		}
		soldier1 = page1.getSubimage(150, 130, 400 - 150, 330 - 130);
		wormstraight = page1.getSubimage(225, 535, 235, 93);
		wormmoving = page1.getSubimage(237, 700, 234, 93);
		soldier2 = page1.getSubimage(616, 504, 257, 189);
		projectile = page1.getSubimage(683, 800, 836 - 683, 860 - 800);
		squidrest = page2.getSubimage(560, 75, 170, 120);
		squidprecum = page2.getSubimage(514, 257, 217, 101);
		squidcumming = page2.getSubimage(437, 433, 296, 93);
		robot = page2.getSubimage(376, 886, 118, 167);
		soldier3 = page2.getSubimage(629, 872, 181, 142);
	}

	public BufferedImage getSoldier1() {
		return soldier1;
	}

	public BufferedImage wormStraight() {
		return wormstraight;
	}

	public BufferedImage wormMoving() {
		return wormmoving;
	}

	public BufferedImage getSoldier2() {
		return soldier2;
	}

	public BufferedImage getsquidRest() {
		return squidrest;
	}

	public BufferedImage getsquidPrecum() {
		return squidprecum;
	}

	public BufferedImage getsquidCumming() {
		return squidcumming;
	}

	public BufferedImage robot() {
		return robot;
	}

	public BufferedImage getSoldier3() {
		return soldier3;
	}

	public BufferedImage getProjectile() {
		return projectile;
	}
}
