package Exercise19_05;

import java.security.SecureRandom;
import java.util.Arrays;

public class BubbleSortTest
{
	public static void bubbleSort(int[] data)
	{
		// decrease runs as greatest value "bubbles" to the end of the array
		for (int index = data.length; index > 1; index --)
		{
			for (int i = 1; i < index; i ++) // decrease range of checks 
				if(data[i - 1] > data[i]) // if value at lower index is greater that value at higher index switch them
				{
					int temp = data[i - 1];
					data[i - 1] = data[i];
					data[i] = temp;
				}
				
			printPass(data, index);
		}
	}
	
	private static void printPass(int[] data, int index)
	{
		System.out.printf("after pass %2d: ", data.length - index);
		
		// output elements till selected item
		for (int i = 0; i < data.length; i ++)
			System.out.printf("%d  ", data[i]);
			
		System.out.printf("%n               "); // for alignment
		
		// indicate amount of array that`s sorted
		for (int i = index - 1; i > 0 ; i --)
			System.out.printf("--  ");
		System.out.println();
	}

	
	public static void main(String[] args)
	{
		SecureRandom generator = new SecureRandom();
		
		int[] data = new int[10];
		
		for (int i = 0; i < data.length; i ++)
			data[i] = 10 + generator.nextInt(90);
		
		System.out.printf("Unsorted array: %n%s%n%n", Arrays.toString(data));
		bubbleSort(data);
		
		System.out.printf("Sorted array: %n%s%n%n", Arrays.toString(data));
		
	}
}
