import java.util.Random; // needed for random object

public class TemperatureConversion 
{

	public static void main(String[] args) 
	{
		Random tester = new Random(); // random no generator  
		
		int number = tester.nextInt(100); // generate a random temperature
		
		if(tester.nextInt(100) > 50)
			System.out.printf("Fahrenheit %d to Celsius is %.2f.%n",number, toCelsius((double)number));
		System.out.printf("Celsius %d to Fahrenheit is %.2f.%n",number, toFahrenheit((double)number));


	}

	// method to convert fahrenheit to celsius
	private static double toCelsius(double fahrenheit)
	{
		double celsius = 5.0 / 9.0 * (fahrenheit - 32); // convert to celsius
		
		return celsius;
	}
	
	// method to convert celsius to fahrenheit 
	private static double toFahrenheit(double celsius)
	{
		double fahrenheit = 9.0 / 5.0 * (celsius + 32);
		
		return fahrenheit;
	}

	
}
