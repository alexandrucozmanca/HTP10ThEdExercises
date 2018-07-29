import java.util.Scanner;

public class GasMileage
{

	public static void main(String[] args)
	{
		// generate Scanner object for user input
		Scanner input = new Scanner(System.in);

		int totalDistance = 0, totalFuel = 0, distance = 0, fuel = 0;
		double totalAverage = 0;


		// prime while loop with first user input
		System.out.print("Please input trip distance(km). (0 or negative to stop program) ");
		distance = input.nextInt();
		if(distance != 0)
		{
		System.out.print("Please input used fuel(l). (0 or negative to stop program) ");
		fuel = input.nextInt();
		}


		//operate loop while both fuel and distance greater than 0
		while (distance >0 && fuel >0)
		{
			//compute and display trip average
			double average = (double) fuel *100 / distance;
			System.out.printf("Trip mileage is: %.2f l/100Km.%n%n",average);

			//add distance and fuel to total usage
			totalDistance += distance;
			totalFuel += fuel;


			//input next data
			System.out.print("Please input trip distance. (0 or negative to stop program) ");
			distance = input.nextInt(); if(distance <= 0) break;
			System.out.print("Please input used fuel. (0 or negative to stop program) ");
			fuel = input.nextInt();
		}

		//compute and display general average if data exists
		if(totalDistance > 0 && totalFuel >0)
		{
			totalAverage = (double) totalFuel * 100 / totalDistance;
			System.out.printf("%nYou drove for a total of %d km and consumed %d l.",totalDistance,totalFuel);
			System.out.printf("Total mileage is %.2f l/100Km.%n" ,totalAverage);
		}
		else System.out.println("No valid input provided, program aborted");

		input.close();
	}

}
