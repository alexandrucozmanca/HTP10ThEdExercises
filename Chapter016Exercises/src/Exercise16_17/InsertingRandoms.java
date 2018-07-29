package Exercise16_17;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class InsertingRandoms 
{
	static final int INTEGER_COUNT = 25;
	
	public static void main(String[] args)
	{
		List <Integer> orderedIntegers = new LinkedList<>();
		Random random = new Random();
		
		for(int i = 0; i < INTEGER_COUNT ; i ++)
		{
			int temp = random.nextInt(100);
			orderedIntegers.add(temp);
			System.out.println("Added: " + temp);
		}
		
		Collections.sort(orderedIntegers);
		
		System.out.println("/nOrdered list:");
		int total = 0;
		for (Integer integ : orderedIntegers)
		{
			System.out.printf("%d ", integ);
			total += integ;
		}
		System.out.println();
	
		System.out.printf("Average: %.2f", (double) total / INTEGER_COUNT);
	
	}

}
