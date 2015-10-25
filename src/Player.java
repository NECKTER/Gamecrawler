import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Objects {
	private int health;
	private int damage;
	private int armor = 0;
	private ArrayList<Items> items = new ArrayList<Items>();
	private int isXbound = 1, isYbound = 1;
	private int corX, corY;
	private int movespeed = 1;
	private int moverequest;

	public Player(int x, int y, int h, int w, BufferedImage img, int health, int damage) {
		super(x, y, h, w, img);
		health = this.health;

		// TODO Auto-generated constructor stub
	}

	private void addItem(Items item) {
		// TODO Auto-generated method stub
		items.add(item);
	}

	public ArrayList<Items> getItems() {
		return items;
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

	public void Up() {
		if (isYbound == -1) {
			this.addY(-1);
		} else {
			moverequest = 1;
		}

	}

	public void Down() {
		if (isYbound == 1) {
			this.addY(-1);
		} else {
			moverequest = 3;
		}

	}

	public void Left() {
		if (isXbound == -1) {
			this.addX(-1);
		} else {
			moverequest = 4;
		}
	}

	public void Right() {
		if (isXbound == 1) {
			this.addX(1);
		} else
			if (isXbound == 0) {
				moverequest = 2;
			}
	}

	public int getRe() {
		return moverequest;
	}

}
