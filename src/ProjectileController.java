import java.awt.Graphics;
import java.util.LinkedList;

public class ProjectileController {
private LinkedList<Projectile> b = new LinkedList<Projectile>();
Projectile TempBullet;

public void tick(){
	for(int t = 0; t < b.size(); t++){
		TempBullet = b.get(t);
		TempBullet.tack();
			
		}
	}
public void render(Graphics g){
	for(int t = 0; t < b.size(); t++){
		TempBullet = b.get(t);
		
		TempBullet.Render(g);
}}

public void addBullet(Projectile p){
	System.out.println(b.size());
	b.add(p);
}
public void removieBullet(Projectile p){
	b.remove(p);
}


}
	

