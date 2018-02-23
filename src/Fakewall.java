import java.util.*;
import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
public class Fakewall extends Barrier{

	public Fakewall(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public Image getPlayerImg() {
		// TODO Auto-generated method stub
		ImageIcon ic = new ImageIcon(getClass().getResource("/resources/fakewall.png"));
		height = ic.getIconHeight();
		width = ic.getIconWidth();
		return ic.getImage();
	}
	public  Rectangle getBounds(){
		return new Rectangle(x,y,width,height);
	}



}
