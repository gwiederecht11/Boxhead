import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


public class Healthpack extends Entity{
	
	public Healthpack(int x, int y) {
		super(x, y);
		
		// TODO Auto-generated constructor stub
	}
	public void draw(Graphics g){
		g.drawImage(getPlayerImg(), x, y, null);
	}	
	public Image getPlayerImg() {
		// TODO Auto-generated method stub
		
		ImageIcon ic = new ImageIcon(getClass().getResource("/resources/healthpack.png"));
		height = ic.getIconHeight();
		width = ic.getIconWidth();
		return ic.getImage();
		
		
		
	}

}
