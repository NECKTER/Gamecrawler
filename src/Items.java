import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Items extends Objects {
	private Map<String, Integer> Stats = new HashMap<String, Integer>();
	private String type = "";
	private String name = "";
	private static File nouns = new File(Items.class.getResource("text/ItemNames").getFile());
	private static File adjectives = new File(Items.class.getResource("text/ItemAdjectives").getFile());
	private static ArrayList<String> nounlist = new ArrayList<>();
	private static ArrayList<String> adjlist = new ArrayList<>();
	private Scanner scanner;

	public Items(int x, int y, int h, int w, Image img, String type) {
		super(x, y, h, w, img);
		setupStats();
		scan();
		randomName();
	}

	public void randomName() {
		int ran = (int) (Math.random() * adjlist.size());
		name = adjlist.get(ran);
		ran = (int) (Math.random() * nounlist.size());
		name += " " + nounlist.get(ran);
	}

	private void scan() {
		try {
			scanner = new Scanner(nouns);
			System.out.println("noun file found");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("nouns does not esist");
		}
		while (scanner.hasNext()) {
			nounlist.add(scanner.next());
		}
		try {
			scanner = new Scanner(adjectives);
			System.out.println("adjectives file found");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("adjectives does not esist");
		}
		while (scanner.hasNext()) {
			adjlist.add(scanner.next());
		}
	}

	private void setupStats() {
		Stats.put("damage", 0);
		Stats.put("armor", 0);
		Stats.put("speed", 0);
		Stats.put("ammo", 0);
	}

	public void setDamage(int damage) {
		// TODO Auto-generated method stub
		Stats.replace("damage", damage);
	}

	public void getDamage() {
		Stats.get("damage");
	}

	public void setArmor(int armor) {
		// TODO Auto-generated method stub
		Stats.replace("armor", armor);
	}

	public void getArmor() {
		Stats.get("armor");
	}

	public void setSpeed(int speed) {
		// TODO Auto-generated method stub
		Stats.replace("speed", speed);
	}

	public void getSpeed() {
		Stats.get("speed");
	}

	public void setAmmo(int ammo) {
		// TODO Auto-generated method stub
		Stats.replace("ammo", ammo);
	}

	public void getAmmo() {
		Stats.get("ammo");
	}

	public String getName() {
		return name;
	}
}
