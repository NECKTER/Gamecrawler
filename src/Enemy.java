import java.awt.Image;

public class Enemy extends Objects {
	int dex, dey;
	double dumbbutt;
	boolean idle = true, agro = false;

	public Enemy(int x, int y, int h, int w, Image img, int health, int hyperlvl, int damage, boolean isrange) {
		super(x, y, h, w, img);
		// TODO Auto-generated constructor stub

	}

	public void framecall() {
		if (agro == false) {
			dloc();
		} else {

		}
	}

	public void dloc() {
		//random idle
		if (idle = true) {
			dumbbutt = Math.random() * 50;
			dex = this.getX() + (int) dumbbutt;
			dumbbutt = Math.random() * 50;
			dey = this.getY() + (int) dumbbutt;
			idle = false;
		} else {
			if (dex != this.getX()) {
				if (dex < this.getX()) {
					this.move(dex, this.getY());
				} else {
					this.move(this.getX() + 5, this.getY());
				}
			}
			if (dey != this.getY()) {
				if (dey < this.getY()) {
					this.move(this.getX(), dey);
				} else {
					this.move(this.getX(), this.getY() + 5);
				}
			}
			if (this.getX() == dex && this.getY() == dey) {
				idle = true;
			}
		}

	}
}
