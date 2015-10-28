import java.awt.Graphics;
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
		for (Objects obj : projectiles) {
			obj.draw(g);
		}
		yield();
	}
}
