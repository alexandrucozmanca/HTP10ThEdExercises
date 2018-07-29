import java.util.Scanner;
import static java.lang.System.out;
import static java.lang.System.in;

public class Salary 
{
	public static void main(String[] args) 
	{
		// generate Scanner object for user input
		Scanner input = new Scanner(in);
		
		//instance variables
		double salary=0, payRate;
		int hours;
		String name;
		
		// query for user input and prime while loop
		out.println("Please input data: (0 if you want to stop).");
		
		out.println("Employee name: ");
		if(input.hasNextInt())
			{ 
			if(input.nextInt() == 0)
			out.println("User aborted");
			input.close();
			return; 	
			}
		else 
			name = input.nextLine();
					
		out.println("Employee pay rate ($/hour): ");
		payRate = input.nextDouble();
		if(payRate == 0)
		{
			out.println("User aborted");	
			input.close();
			return; 
		}
		
		out.println("Employee no. of worked hours: ");
		hours = input.nextInt();
		if(hours == 0)
		{
			out.println("User aborted");	
			input.close();
			return; 
		}
		input.nextLine();
				
		//compute and display Salary
		
		if(hours > 40)
			{
			 salary = ((40 * payRate) + (hours - 40)*payRate*1.5); 
			 out.printf("Employee %s has acrued $%.2f this week.%n%n",name,salary);
			}
		else 
			{
			salary = hours * payRate; 
			out.printf("Employee %s has acrued $%.2f this week.%n%n",name,salary);
			}
		
				
		while (payRate != 0.0 && hours != 0)
		{	
			// query for new input considering halt demands
			out.println("Please input data: (0 if you want to stop).");
			
			out.println("Employee name: ");
			if(input.hasNextInt())
				{ 
				if(input.nextInt() == 0)
				out.println("User aborted");
				input.close();
				break; 	
				}
			else 
				name = input.nextLine();
						
			out.println("Employee pay rate ($/hour): ");
			payRate = input.nextDouble();
			if(payRate == 0)
			{
				out.println("User aborted");	
				input.close();
				break; 
			}
			
			out.println("Employee no. of worked hours: ");
			hours = input.nextInt();
			if(hours == 0)
			{
				out.println("User aborted");	
				input.close();
				break; 
			}
			input.nextLine();
			//compute and display Salary
			
			if(hours > 40)
				{
				 salary = ((40 * payRate) + (hours - 40)*payRate*1.5); 
				 out.printf("Employee %s has acrued $%.2f this week.%n%n",name,salary);
				}
			else 
				{
				salary = hours * payRate; 
				out.printf("Employee %s has acrued $%.2f this week.%n%n",name,salary);
				}
			
		}
		
				
		input.close();
	}
		
	
}
