//a game of Guess the number - a player tries to guess a number based on replies of Too High or Too Low

import java.util.Random; // for 'random' objects
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GuessTheNumber
{
	enum Guess {HIGH , CORRECT , LOW};

	public static void main(String[] args)
	{


		// user info
		JOptionPane.showMessageDialog(null,"The object is to guess a number between 1 and 1000.");

		//Scanner input = new Scanner(System.in); // 'scanner' object for user input

		int tryAgain = 1; // initiate local variable with positive control value

		do
		{
			Random numberGenerator = new Random(); // random 'object'
			int secretNumber = 1 + numberGenerator.nextInt(1000); //set the secret number

			int tries; // counter - how many tries were needed for the player
			tries = 0; // reset tries counter

			String input = "";

			Guess playerGuess = Guess.HIGH; // initiate playerGuess variable with positive control value

			do
			{

				//user input
				input = JOptionPane.showInputDialog("Please input your guess, \n"
						+ "the application will reply Too Low or Too High ");

				int guessNumber =  Integer.parseInt(input); // capture user input

				// 	test user input
				switch (testTheGuess(guessNumber, secretNumber))
				{
					case "CORRECT":
						playerGuess = Guess.CORRECT;
						JOptionPane.showMessageDialog(null,"Congratulations you have guessed the correct "
								+ "number " + guessNumber + ".");
						break;
					case "HIGH":
						playerGuess = Guess.HIGH;
						JOptionPane.showMessageDialog(null,"Your number " + guessNumber + " is too high.");
						break;

					case "LOW":
						playerGuess = Guess.LOW;
						JOptionPane.showMessageDialog(null,"Your number " + guessNumber + " is too low.");
						break;
				}

				tries++; // increase counter
			} while (playerGuess != Guess.CORRECT);


			if (tries == 10)
				input = JOptionPane.showInputDialog("It`s taken you " + tries +" tries to guess the number.\n"
						+ "I wonder if you actually know how to do this or you were just lucky./n"
						+ "Would you like to play again?\n"
						+ "1. Yes\n"
						+ "2. No ");
			else
			input = JOptionPane.showInputDialog("It`s taken you " + tries +" tries to guess the number.\n"
				+ "Would you like to improve your score?\n"
				+ "1. Yes\n"
				+ "2. No ");

			tries = 0; // reset counter

			tryAgain = Integer.parseInt(input);




		}	while (tryAgain == 1);

		System.out.println("Good bye.");

	}

	private static String testTheGuess(int guessedNumber, int secretNumber)
	{
		String result;
		if (guessedNumber == secretNumber) result = "CORRECT";
		else
			if (guessedNumber > secretNumber) result = "HIGH";
			else result = "LOW";

		return result;
	}

	static class MyFrame extends JFrame {

		  MyFrame() {
		    ImageIcon icon = new ImageIcon("//192.168.1.10/departamente/SALES/UNIT 13/1.png");
		    JLabel label = new JLabel(icon);
		    add(label);
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    pack();
		    setVisible(true);
		  }
		}

}
