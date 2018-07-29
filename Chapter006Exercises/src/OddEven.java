//Application to determine if a number is odd or even
import java.util.Random;

public class OddEven 
{
	public static void main(String[] args) 
	{
		Random tester = new Random(); // random object for testing purposes
		
		//run test for 20 iterations
		for (int i = 1; i <= 20; i ++)
		{
			int number = tester.nextInt(100);
			if (isOdd(number)) System.out.printf("Number %d is odd.%n", number);
			else System.out.printf("Number %d is even.%n", number);
		}
		

	}

	// method to determine if an integer is odd or even
	private static boolean isOdd(int number)
	{
		boolean isOdd = false; // local boolean variable 
		if (number % 2 == 1) isOdd = true; // test if odd
		
		return isOdd;
		
	}
	
}
