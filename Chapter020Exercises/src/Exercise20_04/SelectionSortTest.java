package Exercise20_04;

import java.security.SecureRandom;
import java.util.Arrays;

public class SelectionSortTest 
{
	
	// sort array using selection sort
	public static <T extends Comparable<T>> void selectionSort(T[] data)
	{
		// loop over data.length - 1 elements 
		for(int i = 0; i < data.length - 1;  i++)
		{
			int smallest = i;
			
			// loop to find index of smallest element
			for (int index = i + 1; index < data.length ; index ++)
				if (data[index].compareTo(data[smallest]) < 0)
					smallest = index;
			
			swap(data, i , smallest);
			printPass(data, i + 1, smallest);
		}
	}// end method selectionSort

	
	// helper method to swap values of two elements
	private static <T> void swap(T[]data, int first, int second)
	{
		T temp = data[first];
		data[first] = data[second];
		data[second] = temp;
	}
	
	// print a pass of the algorithm
	private static <T> void printPass(T[] data, int pass, int index)
	{
		System.out.printf("after pass %2d: ", pass);
		
		// output elements till selected item
		for (int i = 0; i < index; i ++)
			System.out.printf("%s  ", data[i]);
		
		System.out.printf("%s* ", data[index]);
		
		// finish outputting array
		for (int i = index + 1; i < data.length; i ++)
			System.out.printf("%s  ", data[i]);
		
		System.out.printf("%n               "); // for alignment
		
		// indicate amount of array that`s sorted
		for (int i = 0; i < pass; i ++)
			System.out.printf("--  ");
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		SecureRandom generator = new SecureRandom();
		
		Integer[] dataInteger = new Integer[20];
		
		for (int i = 0; i < dataInteger.length; i ++)
			dataInteger[i] = 10 + generator.nextInt(90);
		
		System.out.printf("Unsorted integer array, using generic methods: %n%s%n%n", Arrays.toString(dataInteger));
		selectionSort(dataInteger);
		
		System.out.printf("Sorted integer array, using generic methods: %n%s%n%n", Arrays.toString(dataInteger));
		
		Double[] dataDouble = new Double[20];
		
		for (int i = 0; i < dataDouble.length; i ++)
			dataDouble[i] =  ((double) (100 + generator.nextInt(900))/10); 
		
		System.out.printf("Unsorted double array, using generic methods: %n%s%n%n", Arrays.toString(dataDouble));
		selectionSort(dataDouble);
		
		System.out.printf("Sorted double array, using generic methods: %n%s%n%n", Arrays.toString(dataDouble));
		
	}
}
