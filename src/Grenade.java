import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
public class Grenade extends Weapon{

	int time = 0;
	int explosionH;
	int explosionW;
	public Grenade(int x, int y, int dir) {
		super(x, y, dir);
		// TODO Auto-generated constructor stub
	}

	
	public void move() {
		if(dir==1){
			for(int s = 0; s<200;s++){
				x--;
			}
				
		}
		if(dir==2){
			for(int s = 0; s<200;s++){
				x++;
			}
				
		}
		if(dir==3){
			for(int s = 0; s<200;s++){
				y--;
			}
				
		}
		if(dir==4){
			for(int s = 0; s<200;s++)
				y++;
		}
		
	}
	public void explode(Graphics g){
		//g.drawImage(getSmallExplosion(), x, y, null);
		g.drawImage(getBigExplosion(), x-30, y-5, null);

	}
	
	public void increaseTime(int i){
		time +=i;
		
	}
	public int getTime(){
		return time;
	}

	@Override
	public Image getPlayerImg() {
		// TODO Auto-generated method stub
		ImageIcon ic = new ImageIcon(getClass().getResource("/resources/grenade.png"));
		width = ic.getIconWidth();
		height = ic.getIconHeight();
		return ic.getImage();
			
	}

	private Image getBigExplosion() {
		// TODO Auto-generated method stub
		ImageIcon ic = new ImageIcon(getClass().getResource("/resources/bigexplosion.png"));
		explosionW = ic.getIconWidth();
		explosionH = ic.getIconHeight();
		return ic.getImage();	
	}
//	public Image getSmallExplosion(){ //trying to make it look like an animation
//		ImageIcon ic = null;
////		if(time>300)
////			ic = new ImageIcon(getClass().getResource("/resources/bigExplosion.png"));
////		else if(time>=150)
//			ic = new ImageIcon(getClass().getResource("/resources/smallExplosion.png"));
//		explosionW = ic.getIconWidth();
//		explosionH = ic.getIconHeight();
//		return ic.getImage();
//	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,explosionW,explosionH);
	}
	
	

}
