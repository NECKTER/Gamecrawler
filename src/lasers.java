import java.awt.Graphics;
import java.util.ArrayList;

public class Lasers extends Thread implements Runnable {
	private static ArrayList<Objects> projectiles = new ArrayList<>();
	private static ArrayList<Objects> trash = new ArrayList<>();
	private static int h = 0, w = 0;
	private static Panel panel;

	public Lasers(ArrayList<Objects> objs, int h, int w, Panel panel) {
		// TODO Auto-generated constructor stub
		projectiles.addAll(objs);
		Lasers.h = h;
		Lasers.w = w;
		Lasers.panel = panel;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (projectiles.size() > 0) {
			for (Objects obj : projectiles) {
				obj.shoot();
				if (obj.getY() > h || obj.getX() > w || obj.getY() < 0 || obj.getX() < 0) trash.add(obj);
			}
			panel.removeProjectiles(trash);
		}
		yield();
	}
}
