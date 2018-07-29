// algorithm to print a checkerboard patter of N length
import java.util.Scanner;

public class Checkerboard 
{
	public static void main(String[] args) 
	{
		// instance variables
		int lenght;
				
		// generate Scanner object for length value
		System.out.print("Input pattern lenght: ");
		Scanner input = new Scanner(System.in);
		lenght = input.nextInt();
		
		System.out.println();	
		System.out.println();
		
		
		// run loop to display patern
		int i = 1;
		while (i <= lenght)
		{
			int j = 1;
			if (i % 2 == 0 ) System.out.print(" "); // add " " to even lines 
			while (j <= lenght)
			{
				System.out.print("* ");
				j++;
			}
			
			System.out.println();
			i++;			
		}
		
		input.close();
	}

}
