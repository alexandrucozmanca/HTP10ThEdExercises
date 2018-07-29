import java.util.Scanner;

public class Palindrome 
{

	public static void main(String[] args) 
	{
	// instance variables
		int number;
		
	// generate Scanner object for user input
		Scanner input = new Scanner(System.in);
		
	// read number with check for 5 digits
		do 
		{
			System.out.print("Input number: ");
			number = input.nextInt();
			if ( number >= 10000 && number <= 99999)
				{
				if (number / 10000 == number % 10 && (number / 1000) % 10 == (number % 100) / 10) 
					System.out.println("Number is palindrome.");
				else 
					System.out.println("Number is not palindrome.");
				}
			else System.out.println("Try again.");
		}
			
		while 	(number < 10000 || number > 100000);
		
		input.close();
		
	}

}
