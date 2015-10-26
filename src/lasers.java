import java.awt.Graphics;
import java.util.ArrayList;

public class lasers extends Thread {
	private ArrayList<Objects> projectiles = new ArrayList<>();
	private ArrayList<Object> trash = new ArrayList<>();

	public ArrayList<Objects> move(ArrayList<Objects> objs, int h, int w) {
		// TODO Auto-generated method stub
		projectiles.clear();
		projectiles.addAll(objs);
		if (projectiles.size() > 0) {
			for (Objects obj : projectiles) {
				obj.shoot();
				if (obj.getY() > h || obj.getX() > w || obj.getY() < 0 || obj.getX() < 0) trash.add(obj);
			}
			projectiles.removeAll(trash);
			trash.clear();
		}
		return projectiles;
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		for (Objects obj : projectiles) {
			obj.draw(g);
		}
	}
}
