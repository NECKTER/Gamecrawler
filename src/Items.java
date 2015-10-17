import java.awt.Image;
import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class Items extends Objects {
	Map<String, Integer>Stats = new HashMap<String, Integer>();
	String type = "";
	File nouns = new File(Items.class.getResourceAsStream("text/Item names").toString());
	File adjectives = new File(Items.class.getResourceAsStream("text/Item names").toString());
	
	public Items(int x, int y, int h, int w, Image img, String type) {
		super(x, y, h, w, img);
		setupStats();
		// TODO Auto-generated constructor stub
		System.out.println(nouns.);
	}
	private void setupStats() {
		// TODO Auto-generated method stub
		Stats.put("damage", 0);
		Stats.put("armor", 0);
		Stats.put("speed", 0);
		Stats.put("ammo", 0);
	}
	
	public void setDamage(int damage) {
		// TODO Auto-generated method stub
		Stats.replace("damage", damage);
	}
	
	public void getDamage(){
		Stats.get("damage");
	}

	public void setArmor(int armor) {
		// TODO Auto-generated method stub
		Stats.replace("armor", armor);
	}
	
	public void getArmor(){
		Stats.get("armor");
	}

	public void setSpeed(int speed) {
		// TODO Auto-generated method stub
		Stats.replace("speed", speed);
	}
	
	public void getSpeed(){
		Stats.get("speed");
	}
	
	public void setAmmo(int ammo) {
		// TODO Auto-generated method stub
		Stats.replace("ammo", ammo);
	}
	
	public void getAmmo(){
		Stats.get("ammo");
	}
}
