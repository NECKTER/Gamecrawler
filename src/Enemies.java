import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Enemies extends Object {

	//Okay Loves The Cavalrie has arrived 
	int posX, posY, hp, damage;
	BufferedImage h;
	
	
	
	public Enemies (int x,int y, BufferedImage b,  int rotationidkifdothis, int health, int dam){
		hp = health;
		damage = dam;
		posX = x;
		posY = y;
		h = b;
		
		
	}
	public void drawkiddo(Graphics g){
		g.drawImage(h, posX, posY, null );
	
	}
	public int getdamage(){
		return damage;
	}
	public void tick(int playerX, int playerY){
		System.out.println( Math.sqrt( Math.pow(playerX - posX, 2) + Math.pow(playerY - posY, 2) ));
		if((float) Math.sqrt( Math.pow(playerX - posX, 2) + Math.pow(playerY - posY, 2) ) < 800){
			if(playerX > posX){
				posX = posX +  2;
			}else{
				posX=posX- 2;
			}
			if(playerY > posY){
				posY =posY + 2;
			}else{
				posY= posY -2;
			}
	
			
		}
	}
	
}
