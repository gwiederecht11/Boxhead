import javax.swing.JOptionPane;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Controls: \n1-Previous weapon\n"
				+ "2-Next weapon\nSpace-Shoot\nObjective-Survive\n*NOTE: To switch weapons, \nlet go of the arrow keys first.", "Good luck!", 1);
		try{
			new BoxFrame().start();
		}
		catch(Exception e){
			System.out.println("problem ");
			e.printStackTrace();
		}
		
	}

}
