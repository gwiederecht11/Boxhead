import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyAdapt extends KeyAdapter{
	
	Stewie p;
	
	public KeyAdapt(Stewie player){
		p = player;
		
	}
	
	public void keyPressed(KeyEvent e){
		p.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e){
		p.keyReleased(e);
	}

}
