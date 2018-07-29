// application for computing individual 

import java.util.Scanner;

public class ParkingCharges
{

	public static void main(String[] args) 
	{
		double totalCharges = 0.0; // total amount of charges for a particular day
		double parkingTime = 0.0;
		
		Scanner input = new Scanner(System.in); // scanner object for user input
		
		
		// prime while loop with first request
		System.out.printf("Please input your total parking time or EOL character to stop: "); 
									
		while (input.hasNext())
		{	
			parkingTime = input.nextDouble();
			
			// 	check for improper input
			if (parkingTime > 0 )
			{
				// 	display current charge
				displayCharge("",calculateCharges(Math.ceil(parkingTime)));
		
				// 	add current charge to total charges
				totalCharges += calculateCharges(Math.ceil(parkingTime));
			}
			
			// inform user of improper time input
			else 
				System.out.println("Invalid parking time entered, please try again.");
						
			//query user for input
			System.out.printf("Please input your total parking time or EOL character to stop: "); 
			
		}
				
		// display total charge for the day
		if (totalCharges > 0)
		{
			System.out.println();
			System.out.println();
			displayCharge(" total",totalCharges);
			System.out.printf("This is the total for the whole day.");
		}
		else System.out.printf("%nNo charges for today, sorry.");
	
		input.close();

	}
	
	// method to compute current charge
	private static double calculateCharges(double parkingTime)
	{ 
		double charge = 0.0;
		
		if (parkingTime <= 3.0) charge = 2.0;
		else charge = Math.min(10.0, 2.0 + (parkingTime - 3) * 0.5);
		
		return charge;
	}
	
	// method to display current or total charge - for total charge first parameter to " total" 
	private static void displayCharge(String ifTotal, double charge)
	{
		System.out.printf("%s%s %s %.2f.%n","Your", ifTotal, "parking charge amounts to",charge);
	}
		
}
