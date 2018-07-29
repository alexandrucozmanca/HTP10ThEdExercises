import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class ShapesStudyExerciseTest
{
	public static void main(String[] args)
	{
		// obtain user input
		String input = JOptionPane.showInputDialog(
				"Enter 1 to draw rectangles\n"
				+ "Enter 2 to draw ovals");
		int choice = Integer.parseInt(input);

		input = JOptionPane.showInputDialog("Enter the desired no. of shapes.");
		int noShapes = Integer.parseInt(input);

		JFrame application = new JFrame(); // create a new JFrame

		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(400, 400);
		

		ShapesStudyExercise panel = new ShapesStudyExercise(choice, (application.getWidth())/2,
						(application.getHeight())/2, 20, 20, noShapes); // create a panel object

		
		System.out.printf("Application X: %d, Y: %d%nShape at X: %d, Y: %d%n",
				application.getHeight(),application.getWidth(),panel.getHeight(),panel.getWidth());
		
		
		application.add(panel);
		application.setVisible(true);

	}


}
