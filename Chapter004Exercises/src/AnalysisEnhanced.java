import java.util.Scanner;

public class AnalysisEnhanced 
{
		public static void main(String[] args)
		{
			// create Scanner object for user input
			Scanner input = new Scanner(System.in);
			
			int passes=0, failures=0, noGrades = 0, mark;  // instance variables
			
			// control loop for grade input, runs 10 times
			while (noGrades < 10)
			{
				System.out.println("Please input 1 for passes and 2 for failures.");
				mark = input.nextInt();
				
				if (mark == 1) 
					{
					passes ++;
					noGrades++;
					}
				
				if (mark == 2)
					{
					failures ++;
					noGrades++;	
					}
				
			}
		
			// control loop to display results determine if bonus should be awarded 
			if(passes > 8) System.out.printf("There were %d passes and %d failures, the instructor deserves a bonus.",
					passes, failures);
			else System.out.printf("There were %d passes and %d failures, no bonus for the  instructor.",
					passes, failures);
			
			input.close();
			
		}

}
