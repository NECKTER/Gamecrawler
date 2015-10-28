import java.awt.Graphics;
import java.util.ArrayList;

public class Lasers extends Thread implements Runnable {
	private ArrayList<Objects> projectiles = new ArrayList<>();
	private ArrayList<Object> trash = new ArrayList<>();
	private int h = 0, w = 0;
	private Panel panel;

	public Lasers(ArrayList<Objects> objs, int h, int w, Panel panel) {
		// TODO Auto-generated constructor stub
		projectiles.addAll(objs);
		this.h = h;
		this.w = w;
		this.panel = panel;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (projectiles.size() > 0) {
			for (Objects obj : projectiles) {
				obj.shoot();
				if (obj.getY() > h || obj.getX() > w || obj.getY() < 0 || obj.getX() < 0) trash.add(obj);
			}
			projectiles.removeAll(trash);
			trash.clear();
		}
		panel.setProjectiles(projectiles);
		yield();
	}
}
