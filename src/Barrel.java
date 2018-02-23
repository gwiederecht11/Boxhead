import java.util.*;
import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
public class Barrel extends Barrier{

	public Barrel(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public Image getPlayerImg() {
		ImageIcon ic= new ImageIcon(getClass().getResource("/resources/barrel.png"));
		return ic.getImage();
	}
	public void draw(Graphics g){
		super.draw(g);
	}

	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
