import java.util.Scanner;
import static java.lang.System.out;
import static java.lang.System.in;


public class LargestNumber 
{

	public static void main(String[] args) 
	{
		// instance variables
		int counter = 0, number, largest;
		
		// create Scanner object for user input
		Scanner input = new Scanner(in);
		
		
		// query user for input and prime loop
		out.println("Input next sale. (0 if your want to stop).");
		number = input.nextInt();
		if (number == 0)
		{
			out.println("User aborted. No valid sales were inputed");
			input.close();
			return;
		}
		else 
		{ 
			counter ++;
			largest = number;
		}
		
		
		// loop until condition is met 
		while (number != 0)
		{
			// query user for input
			out.println("Input next sale. (0 if your want to stop).");
			number = input.nextInt();

			// check for sentinel
			if (number == 0)
			{	
				//output results
				out.println("User aborted.");
				out.printf("A total of %d sales were registred and the largest was %d.%n",counter,largest);
				input.close();
				break;
			}
			else 
			{	
				// increase counter
				counter ++;
				
				//check if current input is greater than previous max sale
				if (number > largest) largest = number;
			}
				
		}
		
		input.close();
	}

}
