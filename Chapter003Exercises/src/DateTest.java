import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

public class DateTest 
{

	public static void main(String[] args) 
	{
		// create Date objects and assign respective instances
		Date testDate1 = new Date(12,1,1980);
		Date testDate2 = new Date(1,12,1981);
		Date testDate3 = new Date(18,40,1982);
		Date testDate4 = new Date(0,0,10);
		
		// display Date parameters
		out.printf("First date is the day no. %d, of month no. %d of year %d.%n",
			testDate1.getDay(),testDate1.getMonth(),testDate1.getYear());
		
		// display formated dates
		out.printf("First date is %s.%n",testDate1.displayDate());
		out.printf("Second date is %s.%n",testDate2.displayDate());
		out.printf("Thirst date is %s. This is a corrected date%n",testDate3.displayDate());
		out.printf("Fourth date is %s. This is a corrected date%n",testDate4.displayDate());
	
		// create Scanner object for user input
		Scanner input = new Scanner(in);
		
		// modify parameters of first date
		out.println("Please update the first date, input month, day and then year");
		testDate1.setMonth(input.nextInt());
		testDate1.setDay(input.nextInt());
		testDate1.setYear(input.nextInt());
		
		// display formated date after update
		out.printf("First date is %s.%n",testDate1.displayDate());
		
		input.close();
	}
	

}
 