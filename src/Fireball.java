import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Fireball extends Bullet{
	private String condition;
	private int fireBallCounter=0;
	public Fireball(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public Fireball(int x, int y, String cond){
		super(x, y);
		condition= cond;
	}
	public void shootUp(){
		this.addY(-speed);
	}
	public void shootDown(){
		this.addY(speed);
	}
	public void shootLeft(){
		this.addX(speed);
	}
	public void shootRight(){
		this.addX(-speed);
	}
	public void shootUpRight(){
		this.addX(speed);
		this.addY(-speed);
	}
	public void shootUpLeft(){
		this.addX(-speed);
		this.addY(-speed);
	}
	public void shootDownRight(){
		this.addX(speed);
		this.addY(speed);
	}
	public void shootDownLeft(){
		this.addX(-speed);
		this.addY(speed);
	}
	
	public void move(){
		Stewie stewie= BoxPanel.getStewie();
		if(this.getFireBallCounter()==0){
			if(Math.abs(stewie.getX()-this.getX())<20 && (stewie.getY()<this.getY())) {
				//System.out.println("Shooting up");   //If stewie is higher than demon, shoot up
				this.addY(-speed);
				this.setCondition("one");
			}
			else if(Math.abs(stewie.getX()-this.getX())<20 && (stewie.getY()>this.getY())){  //If stewie is lower than demon, shoot down
				//System.out.println("Shooting down");
				this.addY(speed);
				this.setCondition("two");
			}
			else if(Math.abs(stewie.getY()-this.getY())<20 && (stewie.getX()>this.getX())){  //If stewie is right of demon, shoot right
				//System.out.println("Shooting down");
				this.addX(speed);
				this.setCondition("three");
			}
			else if(Math.abs(stewie.getY()-this.getY())<20 && (stewie.getX()<this.getX())){  //If stewie is left of demon, shoot left
				this.addX(-speed);
				this.setCondition("four");
			}
			
			else if(stewie.getX()>this.getX() && stewie.getY()<this.getY()){  //If stewie is higher than demon and to the right of demon, shoot diagonally right
				//System.out.println("Shooting diag right");
				this.addX(speed);
				this.addY(-speed);
				this.setCondition("five");
			}
			else if(stewie.getX()<this.getX() && stewie.getY()<this.getY()){  //If stewie is higher than demon and to the left of demon, shoot diagonally left
				//System.out.println("Shooting diag left");
				this.addX(-speed);
				this.addY(-speed);
				this.setCondition("six");
			}
		
			else if((stewie.getX() >this.getX()) && (stewie.getY()>this.getY())){
				//System.out.println("Shooting diag right");//If stewie is lower than demon and to the right of demon, shoot diagonally right
				this.addX(speed);
				this.addY(speed);
				this.setCondition("seven");
			}
			else if((stewie.getX() <this.getX()) && (stewie.getY()>this.getY())){ 
				//System.out.println("Shooting diag left");//If stewie is lower than demon and to the left of demon, shoot diagonally left
				this.addX(-speed);
				this.addY(speed);
				this.setCondition("eight");
			}
		}
		else{
			if(this.getCondition().equals("one")){
				this.addY(-speed);
			}
			if(this.getCondition().equals("two")){
				this.addY(speed);
			}
			if(this.getCondition().equals("three")){
				this.addX(speed);
			}
			if(this.getCondition().equals("four")){
				this.addX(-speed);
			}
			if(this.getCondition().equals("five")){
				this.addX(speed);
				this.addY(-speed);
			}
			if(this.getCondition().equals("six")){
				this.addX(-speed);
				this.addY(-speed);
			}
			if(this.getCondition().equals("seven")){
				this.addX(speed);
				this.addY(speed);
			}
			if(this.getCondition().equals("eight")){
				this.addX(-speed);
				this.addY(speed);
			}
		}
		this.addToCounter();
	}
	
	public void setCondition(String condition){
		this.condition= condition;
	}
	public int getFireBallCounter(){
		return fireBallCounter;
	}
	public void addToCounter(){
		fireBallCounter++;
	}
	
	public String getCondition(){
		return condition;
	}

	public void draw(Graphics g){
		
		g.drawImage(getPlayerImg(), x, y, null);
	}
	
	public Image getPlayerImg() {
		ImageIcon ic = new ImageIcon(getClass().getResource("/resources/fireball.png"));
		width = ic.getIconWidth();
		height = ic.getIconHeight();
		return ic.getImage();
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y, width, height);
	}
	

}