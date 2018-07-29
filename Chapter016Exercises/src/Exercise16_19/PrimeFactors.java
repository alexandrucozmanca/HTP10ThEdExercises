package Exercise16_19;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class PrimeFactors 
{
	public static void main (String[] args)
	{
		System.out.println("Please input integer to evaluate:");
		
		Scanner keyboard = new Scanner(System.in);
		
		Set<Integer> primeFactors = evaluateInteger(keyboard.nextInt());
		if (primeFactors != null)
		{
			System.out.println("Number has the following prime factors:");
			for (Integer integ : primeFactors)			
				System.out.printf("%d ", integ);
		}
		else 
			System.out.println("The integer is a prime number.");
		
		keyboard.close();
	}
	
	
	private static Set<Integer> evaluateInteger(int number)
	{
		
		List <Integer> factors = new LinkedList<>();
		if(number > 1)
		{
			int factor = 2;
			while(factor != number + 1)
			{
				if (number % factor == 0)
				{
					number = number / factor;
					factors.add(factor);
					factor = 2;
				}
				else
					factor ++;
			}
			
			if (factors.size() == 1)
				return null;
			else 
			{
				Set<Integer> primeFactors = new HashSet<>(factors);
				return primeFactors;
			}
		}
		
		return null;
	}
	
}
