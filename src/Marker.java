import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Marker extends Thread implements Runnable {
	private ArrayList<Objects> projectiles = new ArrayList<>();
	private Graphics g;

	public Marker(Graphics g, ArrayList<Objects> objs) {
		// TODO Auto-generated constructor stub
		this.g = g;
		projectiles.addAll(objs);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Point lastDrawn = new Point(0, 0);
		for (Objects obj : projectiles) {
			if (Math.sqrt(Math.pow((lastDrawn.getX() - obj.getX()), 2) + Math.pow((lastDrawn.getY() - obj.getY()), 2)) > 100) {
				obj.draw(g);
				lastDrawn = new Point(obj.getX(), obj.getY());
			}
		}
		yield();
	}
}
