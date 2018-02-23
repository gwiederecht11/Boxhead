import javax.swing.JFrame;


public class BoxFrame extends JFrame{
	
	public BoxFrame() {

		
	}

	public void start() {
		// TODO Auto-generated method stub

		this.add(new BoxPanel());
		
		this.pack();
		this.validate();
		this.setResizable(false);
		this.setVisible(true);
	}
	


}
