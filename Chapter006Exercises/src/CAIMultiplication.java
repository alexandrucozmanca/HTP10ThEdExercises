import javax.swing.JOptionPane; // for graphics
import java.util.Random; // for 'random' object

// simulate a Computer Aided Instruction for multiplication exercises
public class CAIMultiplication
{

	public static void main(String[] args)
	{
		boolean suficientAnswers = false;
		int correctAnswers = 0, incorrectAnswers = 0;

		// run application as long as student desires
		while (!suficientAnswers)
		{
			// reset variables
			correctAnswers = 0;
			incorrectAnswers = 0;

			Random tester = new Random(); // random no. generator for

			for (int i = 1; i <= 10; i++)
			{
				// run the actual multiplication test 10 times and test for correct answers
			 if(testMultiplication(tester.nextInt(100)) == 1)
			 	correctAnswers ++;
			 else
				incorrectAnswers++;
			}

			// construct the feedback for the while loop
			String output = ""; // local variable for feedback

			if (correctAnswers*10 >= 80) // if answered more that 80%
			{
				// good answer
				output = "Congratulations you`ve answered " + correctAnswers + "0% of the question.\n"
						+ "Would you like to continue to the next chapter or try another set?";

				// Yes/No option dialogue
				Object[] options = {"Yes","Try another"};
				int temp = 0;
				temp = JOptionPane.showOptionDialog(null,
						output, "",
						JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, options, options[0]);
				if (temp == 0) suficientAnswers = true;
				else suficientAnswers = false;
			}

			else
			{	// could do better
				output = "Hmm you`ve missed " + incorrectAnswers + "0% of the question.\n"
						+ "Would you like to try again or ask your teacher for some help?";

				// Yes/No option dialogue
				Object[] options = {"Yes","Ask teacher"};
				int temp = 0;
				temp = JOptionPane.showOptionDialog(null,
						output, "",
						JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, options, options[0]);
				if (temp == 0) suficientAnswers = false;
				else suficientAnswers = true;

			}
		}

	}

	// method to display and test a students multiplication abilities
	static int testMultiplication (int number)
	{
		String input = JOptionPane.showInputDialog("How much is " + number / 10 + " times " +
				number % 10 + " ?");
		int answer = Integer.parseInt(input);
		int tries = 1;

		if (input == null)
			answer = 0;
		else
			answer = Integer.parseInt(input);

		if (answer != (number / 10) * (number % 10)) tries++;

		return tries;
	}

	// correct answer random chatter
	static String correctAnswer()
	{
		String response;

		Random generator = new Random();
		switch ((1 + generator.nextInt(38))/10)
		{
		case 1:
			response = "Excelent!";
			break;
		case 2:
			response = "Nice work!";
			break;
		case 3:
			response = "Keep up the good work!";
			break;
		default:
			response = "Very good!";
		}

		return response;
	}

	// incorrect answer random chatter
	static String incorrectAnswer()
	{
		String response;

		Random generator = new Random();
		switch ((1 + generator.nextInt(38))/10)
		{
		case 1:
			response = "Wrong. Try once more";
			break;
		case 2:
			response = "Don`t give up!";
			break;
		case 3:
			response = "No. Keep trying";
			break;
		default:
			response = "No. Please try again";
		}

		return response;
	}


}
