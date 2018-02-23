import java.applet.Applet;

import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.IOException;


import javax.swing.ImageIcon;
public abstract class Weapon extends Entity {
	int ammo;
	int damage = 1;
	public Weapon(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public Weapon(int x, int y, int dir){
		super(x, y, dir); 
	}
	public boolean canFire(){
		
		return status;
		
	}
	public abstract void move();
	
	public void draw(Graphics g){
		
		if(dir==1)
			g.drawImage(getPlayerImg(), x, y+25, null);
		if(dir==2)
			g.drawImage(getPlayerImg(), x+80, y+25, null);
		if(dir==3)
			g.drawImage(getPlayerImg(), x+40, y, null);
		if(dir==4)
			g.drawImage(getPlayerImg(), x+40, y+50, null);

	}

		// TODO Auto-generated method stub

	
	
	public abstract Image getPlayerImg();
	public abstract Rectangle getBounds();
	
	public int damage(){
		return damage;
	}
	public int getAmmo(){
		return ammo;
	}
	public void setDamage(int d){
		damage = d;
	}
	
		
		
	}
	

