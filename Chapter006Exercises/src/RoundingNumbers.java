import java.util.Scanner; // for scanner objects

public class RoundingNumbers 
{

	public static void main(String[] args) 
	{
		double convertedNumber; // number to be processed
		
		Scanner input = new Scanner(System.in); //scanner object for user input
		
		// querry user for input
		System.out.print("Please input the number to be processed: ");
		convertedNumber = input.nextDouble();
		
		System.out.printf("Nearest integer is: %.5f%n"
				+ "Nearest tenth is: %.5f%n"
				+ "Nearest hundreth is: %.5f%n"
				+ "Nearest thousandth is: %.5f%n",
				roundToInteger(convertedNumber),
				roundToTenths(convertedNumber),
				roundToHundreds(convertedNumber),
				roundToThousands(convertedNumber));
			
		input.close();

	}
	
	// method to approximate a number to the nearest integer
	private static double roundToInteger(double number)
	{
		number = Math.floor(0.5 + number);
		return number;
	}
	
	// method to approximate a number to the nearest tenth position
	private static double roundToTenths(double number)
	{
		number = Math.floor(0.5 + number * 10) / 10;
		return number;
	}
	
	// method to approximate a number to the nearest hundredth position
	private static double roundToHundreds(double number)
	{
		number = Math.floor(0.5 + number * 100) / 100;
		return number;
	}
	
	// method to approximate a number to the nearest thousandth position
	private static double roundToThousands(double number)
	{
		number = Math.floor(0.5 + number * 1000) / 1000;
		return number;
	}
	
	
}
