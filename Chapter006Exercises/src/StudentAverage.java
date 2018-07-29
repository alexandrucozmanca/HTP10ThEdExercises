// application for assigning student average based on test result
import java.util.Random; // needed for 'random' objects

public class StudentAverage 
{

	public static void main(String[] args) 
	{
		Random tester = new Random(); // random no. generator for testing
		
		// run for 10 iterations
		for (int i = 1; i <= 10; i++)
		{
			int grade = tester.nextInt(101);
			System.out.printf ("Test result was %d, student`s average is %d.%n",
					grade, getAverage(grade));
							
		}

	}

	private static int getAverage(int grade)
	{
		int average; // student average
		
		// determine average value based on grade value
		switch(grade / 10)
		{	
			case 10:
			case 9:
				average = 4;
				break;
			case 8:
				average = 3;
				break;
			case 7:
				average = 2;
				break;
			case 6:
				average = 1;
				break;
			default:
				average = 0;
		}
			
		return average;
	}
	
}
