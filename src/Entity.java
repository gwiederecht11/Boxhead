import java.applet.Applet;

import java.applet.AudioClip;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class Entity {

	int x, y;
	int velX = 0;
	int velY = 0;
	int speed = 5;
	boolean status = true;
	AudioClip clip;
	int key;
	int dir;
	int health;
	int height, width;

	
	public Entity(int x , int y, int dir){
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public Entity(int x , int y){
		this.x = x;
		this.y = y;
		
		
	}
	
	public void update(){
		while(x<=0)
			x+=2;
		while(x>=1230)
			x-=2;
		while(y<=0)
			y+=2;
		while(y<=0)
			y-=2;
			
		
//		checkOffScreen();
		x+=velX;
		y+=velY;

	}
	public void moveOtherWay(Entity z) {
		// TODO Auto-generated method stub
		if(getY() > z.getY()-1)
			y++;
		if(getY()<z.getY()+1)
			y--;
		if(getX()>z.getX()-1)
			x++;
		if(getX()<z.getX()+1)
			x--;
	}
	public void moveOtherWayWall(){
		if(getX() < 480)
			x++;
		if(getX() > 780)
			x--;
		
		
	}

	public int keyNum(){
		return key;
	}

	public void keyPressed(KeyEvent e){
		key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT){
			dir=1;
			velX = -speed;	
		} else if (key == KeyEvent.VK_RIGHT){
			dir=2;
			velX = speed;				
		}
		else if(key == KeyEvent.VK_UP){
			dir=3;
			velY = -speed;	
		} else if (key == KeyEvent.VK_DOWN){
			dir=4;
			velY = speed;				
		}
		
		
	}

	public void keyReleased(KeyEvent e){
		key = e.getKeyCode();
	
		if(key == KeyEvent.VK_LEFT){			
			velX = 0;
		
		} else if (key == KeyEvent.VK_RIGHT){
			velX = 0;
		}
		else if(key == KeyEvent.VK_UP){
			velY = 0;							
		} else if (key == KeyEvent.VK_DOWN){
			velY = 0;				
	}
}
	
	public void checkOffScreen() {
		// TODO Auto-generated method stub
		if(status==true){
			velX = -1;
		}
		else
			velX = 1;
		
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getDir(){
		return dir;
	}
	public void addX(int newX){
		x += newX;
	}
	public void addY(int newY){
		y += newY;
	}
	


//	public void playSound() {
//		// TODO Auto-generated method stub
//		try {
//			clip = Applet.newAudioClip(getClass().getResource("/resources/invaderkilled.wav"));
//			clip.play();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public void setStatus(boolean b) {
		// TODO Auto-generated method stub
		status = b;
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y, width, height);
	}
	public boolean collision(Entity e) {
		return this.getBounds().intersects(e.getBounds());
	}
	
}
