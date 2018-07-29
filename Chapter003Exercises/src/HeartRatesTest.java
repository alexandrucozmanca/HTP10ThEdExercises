import java.util.Scanner;

public class HeartRatesTest 
{

	public static void main(String[] args) 
	{
		// initiate a Scanner object for user input
		Scanner input = new Scanner(System.in);
		System.out.printf("Please input user`s details using the folowing format:%n"
				+ "DD MM YYYY LastName FirstName%n");
		
		HeartRates test1 = new HeartRates(input.nextInt(),input.nextInt(),input.nextInt(),input.next(),input.next());
		
		System.out.printf("User`s name is %s %s, was born on %s and is %d old.%n"
				+ "Maximum heart rate is %d, while the optimum heart range is %s.%n",
				test1.getLastName(),test1.getFirstName(),test1.displayDate(),test1.getAge()
				,test1.maxHeartRate(),test1.heartRateOptimum());
		
		input.close();
	}

}
