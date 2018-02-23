import java.util.*;
import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
public class Shotgun extends Weapon{
	int speedY;
	
	boolean wide= false;
	public Shotgun(int x, int y, boolean wide) {
		super(x, y);
		this.wide= wide;
		// TODO Auto-generated constructor stub
	}
	public Shotgun(int x, int y, int dir, boolean wide){
		super(x, y, dir); 
		this.wide= wide;
	}

	
	public void move() {
		if(dir==1){    //left
			speed = -10;//gotta make the bullets fast
		}
		if(dir==2){   //right
			speed = 10;
		}
		if(dir==3){    //down
			speed = 0;
			speedY = -10;
		}
		if(dir==4){   //up
			speed = 0;
			speedY = 10;
		}
		
		x+=speed;
		y+=speedY;
		//System.out.println("X "+x+" Y "+y);
	}
		
	
	public void draw(Graphics g) {
		if(dir==1){
			g.drawImage(getPlayerImg(), x, y, 20, 20, null);
			g.drawImage(getPlayerImg(), x-10, y+6, 20, 20, null);
			g.drawImage(getPlayerImg(), x-10, y-6, 20, 20, null);
			}
		if(dir==2){
			g.drawImage(getPlayerImg(), x, y, 20, 20, null);
			g.drawImage(getPlayerImg(), x-10, y+6, 20, 20, null);
			g.drawImage(getPlayerImg(), x-10, y-6, 20, 20, null);
			}
		if(dir==3){
			g.drawImage(getPlayerImg(), x, y, 20, 20, null);
			g.drawImage(getPlayerImg(), x+6, y-10, 20, 20, null);
			g.drawImage(getPlayerImg(), x-6, y-10, 20, 20, null);
			}
		if(dir==4){
			g.drawImage(getPlayerImg(), x, y, 20, 20, null);
			g.drawImage(getPlayerImg(), x+6, y-10, 20, 20, null);
			g.drawImage(getPlayerImg(), x-6, y-10, 20, 20, null);
			}
		
	}
	public void setWideOrNah(boolean width){
		wide=width;
	}

	
	public Image getPlayerImg() {
		ImageIcon ic = null;
		if(dir==1)
			ic = new ImageIcon(getClass().getResource("/resources/shotgunLeft.png"));
		if(dir==2)
			ic = new ImageIcon(getClass().getResource("/resources/shotgunRight.png"));
		if(dir==3)
			ic = new ImageIcon(getClass().getResource("/resources/shotgunDown.png"));
		if(dir==4)
			ic = new ImageIcon(getClass().getResource("/resources/shotgunUp.png"));
		width = ic.getIconWidth();
		height = ic.getIconHeight();
		return ic.getImage();
	}
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 20, 20);
	}
	public int damage(){
		return 3;
	}
	
	
	

}
