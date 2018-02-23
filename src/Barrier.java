import java.util.*;
import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
public class Barrier extends Weapon{

	public Barrier(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void move() {
		// TODO Auto-generated method stub
		
	}
	public void draw(Graphics g){
		g.drawImage(getPlayerImg(), x, y, null);
	}

	@Override
	public Image getPlayerImg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
