package Exercise013_25;
import java.util.Random;

public class TortoiseAndHare
{

	public static void main(String[] args)
	{
		int locationTortoise = 1, // location of tortoise
			locationHare = 1; // location of hare

		Random chance = new Random();

		System.out.printf("BANG !!!!%n"
				+ "AND THEY ARE OFF !!!!%n%n");
		int clock = 1;

		while (locationTortoise < 70 && locationHare < 70)
		{
			System.out.printf("Second %d:%n", clock);

			locationTortoise += moveTortoise(chance.nextInt(10));
			if (locationTortoise < 1)
				locationTortoise = 1;

			locationHare += moveHare(chance.nextInt(10));
			if (locationHare < 1)
				locationHare = 1;

			String course = "";
			for (int meter = 1; meter <= 70; meter ++)
			{
				if (meter == locationHare && locationHare == locationTortoise)
					course = course + "OUCH!!";
				else
					if (meter == locationHare)
						course = course + "H";
					else
						if (meter == locationTortoise)
							course = course + "T";
						else
							course = course + "_";

			}


			try
			{
			    Thread.sleep(750);
			}
			catch(InterruptedException e)
			{
			    Thread.currentThread().interrupt();
			}


			System.out.printf("%s%n%n",course);
			clock ++;

		}

		if (locationTortoise > locationHare)
			System.out.println("Tortoise won!");
		else
			System.out.println("Hare won!");

	}


	// method to simulate the movement of the Tortoise
	static int moveTortoise (int chance)
	{
		int move = 0;
		switch (chance)
		{
			case 9: case 8: case 7: case 6: case 5:
				move = 3;
				System.out.println("Tortoise sprints.");
				break;

			case 4: case 3: case 2:
				move = 1;
				System.out.println("Tortoise walks.");
				break;

			case 1: case 0:
				move = -6;
				System.out.println("Tortoise almost slips off the track.");
				break;
		}
		return move;
	}

	// method to simulate the movement of the Hare
	static int moveHare (int chance)
	{
		int move = 0;
		switch (chance)
		{
			case 9: case 8:
				move = 9;
				System.out.println("Hare takes a huge hop.");
				break;

			case 7: case 6: case 5:
				move = 1;
				System.out.println("Hare takes a hop.");
				break;

			case 4: case 3:
				move = 0;
				System.out.println("Hare takes a nap.");
				break;

			case 2: case 1:
				move = -2;
				System.out.println("Hare slips a bit.");
				break;

			case 0:
				move = -12;
				System.out.println("Hare almost slips off the track.");
				break;
		}
		return move;
	}


}
