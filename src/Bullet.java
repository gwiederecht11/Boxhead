import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class Bullet extends Weapon{

	int speedY;
	int ammo = 10;
	public Bullet(int x, int y, int dir) {
		super(x, y, dir);
	}
	public Bullet(int x, int y) {
		super(x, y);
	}
	public void move(){
		
		if(dir==1){
			
			speed = -10;//gotta make the bullets fast
		}
		if(dir==2){
			speed = 10;
		}
		if(dir==3){
			speed = 0;
			speedY = -10;
		}
		if(dir==4){
			speed = 0;
			speedY = 10;
		}
		
		
		x+=speed;
		y+=speedY;
		//System.out.println("X "+x+" Y "+y);
	}


	public Image getPlayerImg() {
		// TODO Auto-generated method stub
		
		ImageIcon ic = null;
		if(dir==1 || dir==2)
			ic = new ImageIcon(getClass().getResource("/resources/bulletleftright.png"));
		else
			ic = new ImageIcon(getClass().getResource("/resources/bulletupdown.png"));
		width = ic.getIconWidth();
		height = ic.getIconHeight();
		return ic.getImage();
		
		
	
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, 15,15 );
	}
	

}
