import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Zombie extends Entity{

	Stewie stewie; 
	Rectangle rect;
	int health;
	ImageIcon ic;
	public Zombie(int x, int y, Stewie s, int health) {
		super(x, y);
		stewie = s;
		this.health = health;
		// TODO Auto-generated constructor stub
	}
	public void move(){
		if(getY() > stewie.getY())
			y--;
		if(getY()<stewie.getY())
			y++;
		if(getX()<stewie.getX())
			x++;
		if(getX()>stewie.getX())
			x--;	
	}
	public int getHealth(){
		return health;
	}
	public void decreaseHealth(int amount){
		health-=amount;
	}


	public void draw(Graphics g){
		
		g.drawImage(getPlayerImg(), x, y, null);
	}
	public Image getPlayerImg() {
		// TODO Auto-generated method stub
		
		ic = new ImageIcon(getClass().getResource("/resources/meg.png"));
		height = ic.getIconHeight();
		width = ic.getIconWidth();
		return ic.getImage();
		
		
	
	}
	public Rectangle getBounds() {
		return new Rectangle(x-20,y, width, height);
	}
	
}
