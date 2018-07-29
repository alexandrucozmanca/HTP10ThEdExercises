import java.util.Random; //for random object

public class IntegerPower 
{
	public static void main(String[] args) 
	{
		//create random object for test;
		Random test = new Random();
		
		// run 10 tests
		for (int i = 1; i <= 10; i ++)
		{
			int base = test.nextInt(10);
			int exponent = test.nextInt(10);
			System.out.printf("%d to power %d is %d, check with %.0f%n",base, exponent, 
					integerToPower(base, exponent), Math.pow(base, exponent));
			
		}
			
	}
	
		
	
	private static int integerToPower(int base, int exponent)
	{
		int result = 1; 
		
		// compute exponential of "base" by "exponent"
		for (int i = 1; i<= exponent; i++)
		result *= base;				
		
		return result;
	}
	
	
}
