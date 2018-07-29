package Exercise18_10;
import java.math.BigInteger;

public class BigIntegerRecursiveFactorial 
{
	public static BigInteger factorial(BigInteger number)
	{
		
		if(number.compareTo(BigInteger.ONE) <= 0)
		{
			return BigInteger.ONE;
		}
		else 
		{
			return 
				number.multiply(factorial(number.subtract(BigInteger.ONE)));
		}
		
	}
	
	
	public static String printFactorial(BigInteger number)
	{
		String output = "";
		if (number.compareTo(BigInteger.ONE) <= 0)
			output = output.concat("1!");
		else 
			output = String.format("%s * (%s)", number, printFactorial(number.subtract(BigInteger.ONE)));
						
		return output;
	}
	
	

	public static void main (String[] args)
	{
		for(int counter = 1; counter <= 4; counter++)
			{
			System.out.printf("%d! = %d%n", counter, factorial(BigInteger.valueOf(counter)));
			System.out.printf("%s%n%n", printFactorial(BigInteger.valueOf(counter)));
			}
	}
}
