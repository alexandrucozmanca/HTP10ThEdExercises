// application to determine if an integer is a multiple of the other integer
import java.util.Random; // needed for 'random' object 


public class Multiples 
{

	public static void main(String[] args) 
	{
		//random no. generator for testing
		Random tester = new Random();
		
		// run test 10 times
		
		for (int i = 1; i <= 10; i++)
		{
			// 	local variable for test condition
			int firstNumber = 1+tester.nextInt(1000);
			int secondNumber = 1+tester.nextInt(10);
		
			if (isMultiple(firstNumber, secondNumber)) 
				System.out.printf("Number %d is a multiple of number %d.%n",firstNumber, secondNumber);
			else 
				System.out.printf("Number %d is not a multiple of number %d.%n",firstNumber, secondNumber);
			
		}
		

	}

	// method to determine if the first integer is a multiple of the second one
	private static boolean isMultiple(int firstNumber, int secondNumber)
	{
		boolean isMultiple = false; // boolean instance variable 
		if (firstNumber % secondNumber == 0 ) isMultiple = true; // test for multiple condition
		
		return isMultiple;
	}
	
	
}
