import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class MapSheet {
	private BufferedImage Black;
	public int xholder = 0, yholder = 0;
	private boolean ispressureX = false, ispressureY = false;

	public MapSheet() {
		try {

			Black = ImageIO.read(SpriteSheet.class.getResourceAsStream("images/black.png"));
		} catch (IOException e) {
		}
	}

	public void drawmap(int playerX, int playerY, Graphics g, int screenwidth, int screenheight) {
		g.drawImage(Black, xholder, yholder, Black.getWidth(), Black.getHeight(), null);
		g.drawImage(Black, xholder, yholder+Black.getHeight(), Black.getWidth(), Black.getHeight(), null);
		g.drawImage(Black, xholder, yholder-Black.getHeight(), Black.getWidth(), Black.getHeight(), null);
		g.drawImage(Black, xholder+Black.getWidth(), yholder, Black.getWidth(), Black.getHeight(), null);
		g.drawImage(Black, xholder-Black.getWidth(), yholder, Black.getWidth(), Black.getHeight(), null);
		g.drawImage(Black, xholder-Black.getWidth(), yholder-Black.getHeight(), Black.getWidth(), Black.getHeight(), null);
		g.drawImage(Black, xholder+Black.getWidth(), yholder-Black.getHeight(), Black.getWidth(), Black.getHeight(), null);
		g.drawImage(Black, xholder+Black.getWidth(), yholder+Black.getHeight(), Black.getWidth(), Black.getHeight(), null);
		g.drawImage(Black, xholder-Black.getWidth(), yholder+Black.getHeight(), Black.getWidth(), Black.getHeight(), null);
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
	public int[][] stageGenerator(){
	int [][]Stage1=new int[20][20];
		for(int i=0; i<19;i++){
			for (int l=0;l<19;l++){
				if(i==0 || i==19){
					Stage1[i][l]=1;
				}
				else{
					if(l==0 ||l==19){
						Stage1[i][l]=1;
					}
					else{
						Stage1[i][l]=0;
					}
				}
			}
		}

		return Stage1;
	}

	public int getholderX() {
		return xholder;
	}

	public int getholderY() {
		return yholder;
	}
}