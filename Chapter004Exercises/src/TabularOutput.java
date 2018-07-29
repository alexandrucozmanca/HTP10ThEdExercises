import java.util.Scanner;
import static java.lang.System.out;

public class TabularOutput {

	public static void main(String[] args)
	{
		// instance variables
		int N, counter = 1; 
		
		// generate Scanner object for user input
		Scanner input = new Scanner(System.in);
		
		//query user for input
		out.println("Input desired N: ");
		N = input.nextInt();
		
		// check for user abort
		if (N == 0) out.println("User aborted.");
		
		// print desired table
		
		else 
		{
			out.printf("N\t10*N\t100*N\t1000*N%n");
			while (counter <= N)
			{	
				out.printf("%d\t%d\t%d\t%d%n",counter,counter*10,counter*100,counter*1000);
				counter++;
			}
		}
			
		input.close();	
	}

}
