// code to simulate a game of Craps

import java.util.Random;
import javax.swing.JOptionPane;

public class EnhancedCraps
{
	private static enum Status {CONTINUE, WON, LOST}; // enum type with constraints regarding the game
	private static String rollResult = ""; // used to display roll results

	public static void main(String[] args)
	{
		int bankBalance = 1000; // Initial bank balance
		int wager = 0; // Initial wager
		boolean willContinue = true; // player decision to keep playing


		// user info
		JOptionPane.showMessageDialog(null, "Barbut\n"
				+ "\n"
				+ "In jocul de Barbut se arunca doua zaruri.\n"
				+ "Castigi daca suma celor doua zaruri este 7 sau 11 din prima incarcare sau \n"
				+ "daca nimeresti de doua ori 'miza' (prima suma aruncata) inainte sa arunci 7.\n\n"
				+ "Daca din prima incarcare arunci suma de 2, 3 sau 12 pierzi direct."
				);

		// run the game until player stops or looses everything
		do
		{
			// query user for wager amount
			String input = JOptionPane.showInputDialog("Ai la dispozitie $" + bankBalance +
					"\nCat vrei sa pariezi?");

			wager = Integer.parseInt(input);

			// check if wager is lower than bank amount or re-query if need be
			while (wager > bankBalance)
			{
				JOptionPane.showMessageDialog(null, "Imi pare rau dar nu ai atati bani la dispozitie");
				input = JOptionPane.showInputDialog("Ai la dispozitie $" + bankBalance +"\nCat vrei sa pariezi?");
				wager = Integer.parseInt(input);
			}

			wager = crapsGame(wager); // modify wager based on game result
			bankBalance += wager; // add wager to bank (0 if game was LOST)


			if (bankBalance >0) // only ask player if bank > 0
			{
				// YES/NO Dialog to keep playing
				Object[] options = {"Da","Nu"};
				int temp = 0;
				temp = JOptionPane.showOptionDialog(null,
						"Mai ai $" + bankBalance + "\nVrei sa mai pariezi?", "",
						JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, options, options[1]);

				if (temp == 0) willContinue = true;
				else willContinue = false;
			}


		} while (bankBalance > 0 && willContinue);
		// keep playing while positive balance and player desire

		if (bankBalance == 0)
			JOptionPane.showMessageDialog(null, "Imi pare rau dar nu mai a fonduri.\nLa revedere!");
		else
			JOptionPane.showMessageDialog(null, "La revedere!");

	} // end of main method

	//simulate 2 die rolls and return sum + modify static string for visual display
   private  static int rollDice()
	 {
	   	rollResult = "";// reset rollResult value if previously used
		int sum = 0, die1 = 0, die2 = 0; // sum variable
		Random randomDie = new Random(); // Random object for random generation

		die1 = 1 + randomDie.nextInt(6); // simulate first die
		die2 = 1 + randomDie.nextInt(6); // simulate second die

		sum = die1 + die2; // compute sum



		// edit static string for visual output of results
		rollResult = rollResult + String.format("Ai aruncat " + die1 + " si " + die2 + ". Total " + sum);
		return sum;

	 } // end method Roll

   // simulate one game
   private static int crapsGame(int wager)
   {
	   Status gameStatus = Status.CONTINUE;
		int dieSum = 0; // variable for sum of dice
		int point = 0; // variable for "point" value
		String output = "";


		dieSum = rollDice(); // first roll
		if (dieSum == 7 || dieSum == 11)
			{
			output = output + rollResult; // edit static string
			gameStatus = Status.WON; // for 7 or 11 on the first roll - WIN
			}
		else
			if (dieSum == 2 || dieSum == 3 || dieSum == 12)
				{
				gameStatus = Status.LOST;  // for 2, 3 or 12 on first roll - LOSE
				output = output + rollResult; // edit static string
				wager = 0 - wager;
				}
			else // if first roll did not throw WIN or LOSE events assign "point" - which roll to look out for
			{
				point = dieSum;
				JOptionPane.showMessageDialog(null, rollResult + "\n"+ "Miza este " + point);

				while (gameStatus == Status.CONTINUE)
				{
				dieSum = rollDice(); // subsequent rolls
				output = output + rollResult+ "\n";// edit static string

				// check for LOSE condition for rolling 7 before "making point" (rolling twice same neutral roll)
				if (dieSum == 7)
					{
						gameStatus = Status.LOST;  // set game to LOSE
						wager = 0 - wager; // lose wager if game is lost
						break; //stop rolls
					}
				else

					// check for WIN condition for rolling twice a neutral roll
					if (dieSum == point)
					{
						gameStatus = Status.WON; // set game to Win
						break; // stop rolls
					}
				}// end while
		}

		// Print out roll progressions
		JOptionPane.showMessageDialog(null, output);

		// Print out game result
		if (gameStatus == Status.WON)
			JOptionPane.showMessageDialog(null, "Felicitari ai castigat " + wager + " $.");
		else
			JOptionPane.showMessageDialog(null, "Imi pare rau, ai pierdut pariul de " + Math.abs(wager) + " $.");

		return wager;
   }

}// end class Craps