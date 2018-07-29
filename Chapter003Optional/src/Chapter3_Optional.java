import javax.swing.JOptionPane;

public class Chapter3_Optional 
{

	public static void main(String[] args) 
	{
		// prompt for user input
		String name = JOptionPane.showInputDialog("What is your name?");
		
		// create output
		String output = String.format("Welcome to Java %s",name);
		
		// display output
		JOptionPane.showMessageDialog(null, output);

	}

}
