import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Demon extends Zombie{
	
	Stewie stewie;
	int health;
	public Demon(int x, int y, Stewie s, int health) {
		super(x, y,s, health );
		stewie = s;
		this.health = health;
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g){
		
		g.drawImage(getPlayerImg(), x, y, null);
	}
	
	public Image getPlayerImg() {
		// TODO Auto-generated method stub
		
		ImageIcon ic = new ImageIcon(getClass().getResource("/resources/lois.png"));
		height = ic.getIconHeight();
		width = ic.getIconWidth();
		return ic.getImage();
		
		
		
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y, width, height);
	}

}
