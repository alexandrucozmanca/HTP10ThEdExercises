// determine if a given number is a perfect number 
public class PerfectNumbers 
{
	static String output = "";

	public static void main(String[] args) 
	{
		for (int i = 1; i <= 10000; i++)
			if (isPerfect(i)) System.out.printf("Number %d is a perfect number. %s%n",i,output); 
		
	}

	
	// method to determine if a number is a perfect number
	public static boolean isPerfect (int number)
	{
		boolean isPerfect = false;
		int sum = 1; 
		String output = "1";
		
		if (number > 0)
		{
			for (int i = 2 ; i <= number/2 ; i++)
			{
				if (number % i == 0) sum += i;
				output += (" + " + i);  
			}
		
			if (sum == number) 
			{
				isPerfect = true;
				PerfectNumbers.output = output;
			}
		}
		
		return isPerfect;
	}
	
}
