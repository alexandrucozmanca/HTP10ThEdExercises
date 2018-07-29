import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

public class HealthProfileTest 
{
	public static void main(String[] args) 
	{
		
	// create blank HealthProfile object for user input
	HealthProfile user1 = new HealthProfile(0,0,0,0,0,"","","");
	
	// create a Scanner object for user input
	Scanner input = new Scanner(in);
	
	//queries for user info and assignment based on user input
	out.print("Last Name? ");
	user1.setLastName(input.next());
	
	out.print("First Name? ");
	user1.setFirstName(input.next());
	
	out.print("Gender? ");
	user1.setGender(input.next());
	
	out.print("Date of birth?(DD MM YYYY) ");
	user1.setDay(input.nextInt());
	user1.setMonth(input.nextInt());
	user1.setYear(input.nextInt());
	
	out.print("Height in cm? ");
	user1.setHeight(input.nextInt());
	
	out.print("Weight in kg? ");
	user1.setWeight(input.nextInt());
	
	
	//Display user info
	out.printf("%nUser`s name is %s %s, is %s, was born on %s and is %d old.%n"
			+ "Maximum heart rate is %d, while the optimum heart range is %s.%n",
			user1.getLastName(),user1.getFirstName(),user1.getGender(),user1.displayDate(),user1.getAge()
			,user1.maxHeartRate(),user1.heartRateOptimum());
	
	//Compute and display BMI and info for BMI
	out.printf("%nBased on a height of %d cm and weight of %d kg your BMI is %.2f.%n",
			user1.getHeight(),user1.getWeight(),user1.computeBMI());
	user1.displayBMIInfo();
	
	input.close();
	}
}
