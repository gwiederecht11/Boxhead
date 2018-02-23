import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Claymore extends Weapon{
	int ammo = 5;
	int ewidth, eheight;
	public Claymore(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	public void draw(Graphics g){
		g.drawImage(getPlayerImg(), x, y, null);
	}
	public void drawExplosion(Graphics g){
		g.drawImage(getBigExplosion(), x-50, y, null);

	}

	@Override
	public Image getPlayerImg() {
		// TODO Auto-generated method stub
		ImageIcon ic = new ImageIcon(getClass().getResource("/resources/claymore.png"));
		width = ic.getIconWidth();
		height = ic.getIconHeight();
		return ic.getImage();
	}
	

	public Image getBigExplosion(){
		ImageIcon ic = new ImageIcon(getClass().getResource("/resources/bigexplosion.png"));
		ewidth = ic.getIconWidth();
		eheight = ic.getIconHeight();
		return ic.getImage();
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,width, height);
	}
	public Rectangle getExplosionBounds(){
		return new Rectangle(x-50,y,ewidth, eheight);

	}
	public boolean collisionExplosion(Entity e){
		return this.getExplosionBounds().intersects(e.getBounds());
	}
	

}
