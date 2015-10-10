import java.awt.Image;
import java.util.ArrayList;


public class Player extends Objects {
	private int health;
	private int damage;
	private int armor = 0;
	

	public Player(int x, int y, int h, int w, Image img, int health, int damage) {
		super(x, y, h, w, img);
		health = this.health;
		// TODO Auto-generated constructor stub
	}

	public int getHealth() {
		return health;
	}
	public int getArmor() {
		return armor;
	}
	public int getDamage() {
		return damage;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
}
