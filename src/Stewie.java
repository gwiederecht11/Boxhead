import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class Stewie extends Entity {
	int speed = 5;
	int health;
	ImageIcon ic;
	public Stewie(int x, int y, int dir, int health) {
		super(x, y, dir);
		this.health= health;
		ic = new ImageIcon(getClass().getResource("resources/S"
				+ "tewie.png"));
		width = ic.getIconWidth();
		height = ic.getIconHeight();
	}
	public void draw(Graphics g){
		
		g.drawImage(getPlayerImg(), x, y, null);

	}
	public int getHealth(){
		return health;
	}
	public void decreaseHealth(int amount){
		health-=amount;
	}
	public Image getPlayerImg() {
		if(ic!=null)
			return ic.getImage();
		return null;

	
	}
	
	public void stop(){
		speed = 0;
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y, width, height);
	}
	public void increaseHealth(int i) {
		// TODO Auto-generated method stub
		health+=i;
	}

}
