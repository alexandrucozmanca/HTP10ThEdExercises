import javax.swing.JOptionPane; // for graphics
import java.util.Random; // for 'random' object

// simulate a Computer Aided Instruction for multiplication exercises
public class CAIMultiplicationEnhanced
{

	public static void main(String[] args) throws NullPointerException
	{
		boolean keepGoing = true;
		int correctAnswers;
		int difficulty = 1;

		while (keepGoing)
		{

			char operand = ' ';

			// Multi-option dialogue
			String output = "Hello, which type of exercises would you like to try?";
			Object[] options = {"Addition","Subtraction","Multiplication","Division"};
			int temp = 0;
			temp = JOptionPane.showOptionDialog(null,
					output, "",
					JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, options, options[0]);

			switch (temp)
			{
			case 0:
				operand = '+';
				break;

			case 1:
				operand = '-';
				break;

			case 2:
				operand = '*';
				break;

			case 3:
				operand = '/';
				break;
			}

			correctAnswers = 10; //prime first step
			while (correctAnswers < 8); // test for minimum passing grade
			{
				correctAnswers = 0; //reset counter


				for (int i = 1; i <= 10; i ++)
					if(testOperations(operand, difficulty))
						correctAnswers ++;

				if (correctAnswers < 8)
				{
					output = "You have answered only " + correctAnswers + " correct answers.";
					Object[] options2 = {"Try Again","Stop"};
					temp = 0;
					temp = JOptionPane.showOptionDialog(null,
							output, "",
							JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, options2, options2[0]);

					if (temp == 1)
					{
						keepGoing = false;
						break;
					}
					else
						correctAnswers = 0;
				}

				else
				{
					output = "Congratulations you have answered " + correctAnswers + " correct answers!\n"
							+ "Would you like to try again, increase difficulty or stop?";
					Object[] options2 = {"Try Again","Increase Difficulty","Stop"};
					temp = 0;
					temp = JOptionPane.showOptionDialog(null,
							output, "",
							JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, options2, options2[0]);

					if (temp == 1)
					{

						difficulty ++;

						correctAnswers = 0;
						JOptionPane.showMessageDialog(null, "Difficulty increased.");

					}

					if (temp == 2)
					{
						keepGoing = false;
						break;
					}
				}

			}



		}

	}



	// method to display and test a students abilities
	static boolean testOperations (char operand, int difficulty )
	{
		Random tester = new Random();
		boolean trueAnswer = false;

		int answer = 0;
		String input = "";
		int number1 = tester.nextInt((int)Math.pow(10, difficulty));
		int number2 = 1 + tester.nextInt((int)Math.pow(10, difficulty));

		if (operand !='/')
		{
			input = JOptionPane.showInputDialog("How much is " + number1 + " " + operand + " " +
			number2 + " ?");
			if (input == null) input = "";
			answer = Integer.parseInt(input);
		}
		else
			{
			input = JOptionPane.showInputDialog("How much is " + number1 + " " + operand + " " +
								number2 + " ?\nInput as a float point number with 2 decimals.");
			if (input == null) input = "";

			}


		switch(operand)
		{
		case '+':
			if(number1 + number2 == answer)
				trueAnswer = true;
			break;

		case '-':
			if(number1 - number2 == answer)
				trueAnswer = true;
			break;

		case '*':
			if(number1 * number2 == answer)
				trueAnswer = true;
			break;

		case '/':
			String temp = String.format("%.2f",(double)number1 / number2);
			System.out.println(temp);
			if(input.equals(temp))
				trueAnswer = true;
			break;
		}

		return trueAnswer;
	}



}
