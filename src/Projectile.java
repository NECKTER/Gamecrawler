import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Projectile {

	private int x,y;
	private int xorigin, yorigin;
	private BufferedImage p;
	private double theta;
	
	public Projectile(int xx, int yy, BufferedImage c, double angle){
		p = c;
		x = xx;
		y = yy;
		xorigin = xx;
		yorigin = yy;
		theta = angle;
	}
	
	public void tack(){
		y = y + 2;
	}
	
	public void Render(Graphics g){
		g.drawImage(p, x, y, null);
	}
	public int getXorg(){
		return xorigin;
	}
	public int getYorg(){
		return yorigin;
	}
}
