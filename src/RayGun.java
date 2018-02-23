import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
public class RayGun extends Bullet {
	int speedY;
	int damage = 8;
	public RayGun(int x, int y, boolean wide) {
		super(x, y);
		
		// TODO Auto-generated constructor stub
	}
	public RayGun(int x, int y, int dir, boolean wide){
		super(x, y, dir); 
		
	}
	
	public void move() {
		if(dir==1){    //left
			speed = -30;//gotta make the bullets fast
		}
		if(dir==2){   //right
			speed = 30;
		}
		if(dir==3){    //down
			speed = 0;
			speedY = -30;
		}
		if(dir==4){   //up
			speed = 0;
			speedY = 30;
		}
		
		x+=speed;
		y+=speedY;
		//System.out.println("X "+x+" Y "+y);
	}
	
	public void draw(Graphics g) {
		if(dir==1){
			g.drawImage(getPlayerImg(), x-80, y,  null);
			}
		if(dir==2){
			g.drawImage(getPlayerImg(), x+60, y, null);
			}	
		if(dir==3){
			g.drawImage(getPlayerImg(), x+10, y-90,  null);
			}
		if(dir==4){
			g.drawImage(getPlayerImg(), x+10, y+40,  null);
			}
	}
	public Image getPlayerImg() {
		ImageIcon ic = null;
		if(dir==1)
			ic = new ImageIcon(getClass().getResource("/resources/laserleft.gif"));
		if(dir==2)
			ic = new ImageIcon(getClass().getResource("/resources/laserright.gif"));
		if(dir==3)
			ic = new ImageIcon(getClass().getResource("/resources/laserup.gif"));
		if(dir==4)
			ic = new ImageIcon(getClass().getResource("/resources/laserdown.gif"));
		width = ic.getIconWidth();
		height = ic.getIconHeight();
		return ic.getImage();
	}
	public int damage(){
		return damage;
	}
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, width, height);
	}
	
}
