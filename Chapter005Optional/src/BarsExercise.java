import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BarsExercise
{

	public static void main(String[] args)
	{
		int noOfBars = 0;
		// obtain user choice

		int maxLenght = 0;
		
		String input = JOptionPane.showInputDialog("Enter total bars to display:");
		noOfBars = Integer.parseInt(input);

		if (noOfBars == 0)
			{
				JOptionPane.showMessageDialog(null,"Invalid number.");
				input = JOptionPane.showInputDialog("Enter total bars to display:");
				noOfBars = Integer.parseInt(input);
			}

		int[] lenght = new int[noOfBars];
		for (int i = 0; i< noOfBars; i++)
			{ 
			int temp;
			input = JOptionPane.showInputDialog("Enter number:");
			temp = Integer.parseInt(input);
			lenght[i] = temp;
			if (temp > maxLenght) maxLenght = temp;
			}

		
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(20 + maxLenght * 15, 45 + noOfBars * 20);

		Bar panel = new Bar(noOfBars, lenght);
		application.add(panel);
		application.setVisible(true);

	}

	
	
}
