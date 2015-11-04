import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Projectile {

	private int x,y;
	private BufferedImage p;
	private double theta;
	
	public Projectile(int xx, int yy, BufferedImage c, double angle){
		p = c;
		x = xx;
		y = yy;
		theta = angle;
	}
	
	public void tack(){
		y = y + 2;
	}
	
	public void Render(Graphics g){
		g.drawImage(p, x, y, null);
	}
}
