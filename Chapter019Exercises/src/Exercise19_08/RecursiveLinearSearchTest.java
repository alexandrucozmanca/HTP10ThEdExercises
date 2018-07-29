package Exercise19_08;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class RecursiveLinearSearchTest 
{
	// perform linear seach on data array
	public static int recursiveLinearSearch(int[] data, int index, int searchKey)
	{
		int output = -1;
		if(index == data.length)
			return output;
		
		if(data[index] == searchKey)
			output = index;
		else 
			output = recursiveLinearSearch(data, index + 1, searchKey);
			
		return output;
			
	}// end method linearSearch

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		SecureRandom generator = new SecureRandom();
		
		int[] data = new int[10];
		
		for (int index = 0; index < data.length; index ++)
			data[index] = 10 + generator.nextInt(90);
		
		System.out.printf("%s%n%n", Arrays.toString(data));
		
		// get input from user
		System.out.println("Please enter an integer value (-1 to quit)");
		int searchKey = input.nextInt();
		
		// repeat input and search; -1 terminates the program
		
		while(searchKey != -1)
		{
			int position = recursiveLinearSearch(data, 0, searchKey); // run search
			
			if(position == -1 ) // key not found
				System.out.printf("%d was not found%n%n", searchKey);
			else
				System.out.printf("%d was found at position %d%n%n", searchKey, position);
			
			// get input from user
			System.out.print("Please enter an integer value (-1 to quit)");
			searchKey = input.nextInt();
		}
		
	}
}
