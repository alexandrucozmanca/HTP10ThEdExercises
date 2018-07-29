package exercise8_14;

public class MultipleInputDateTest
{

	public static void main(String[] args)
	{
		EnhancedDate date = new EnhancedDate(31, 2016);
		System.out.println(date.toString());
		System.out.println(date.toMonthString());
		System.out.println(date.toDaysInYearString());


		date.incrementDay();
		System.out.println(date.toString());
		System.out.println(date.toMonthString());
		System.out.println(date.toDaysInYearString());

	}

}

class EnhancedDate
{
	private int month; // 1-12
	private int day; // 1-31 depending on month
	private int year; // any year
	private int daysInYear;

	private static final int [] daysPerMonth =
		{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	// constructors
	// constructor with validation for month and day given the year
	public EnhancedDate(int month, int day, int year)
	{
		// validate month
		if (month < 1 || month > 12)
			throw new IllegalArgumentException ("Month " + month + " must be within 1 - 12.");


		// check if day in range for month
		if (day < 1 ||
		   (day > daysPerMonth[month] && !(month == 2 && day == 29)))
				throw new IllegalArgumentException ("Day " + day + " out of range for the specified month and year.");


		// check if leap year and if month is 2 and day 29
		if ((month == 2 && day == 29) && !(year % 400 == 0 || (year % 4 == 0 && year % 100 !=0)))
				throw new IllegalArgumentException ("Day " + day + " out of range for the specified month and year.");


		// check year range - between 1900 and 2100
		if (year < 1900 || year > 2100)
			throw new IllegalArgumentException ("Year " + year + " must be within 1900 - 2100.");


		this.month = month;
		this.day = day;
		this.year = year;

	}

	//constructor with string arg for month and int arg for day and year
	public EnhancedDate(String monthString, int day, int year)
	{
		int month;
		monthString = monthString.toLowerCase();

		switch(monthString)
		{
		case "january":
			month = 1;
			break;

		case "february":
			month = 2;
			break;

		case "march":
			month = 3;
			break;

		case "april":
			month = 4;
			break;

		case "may":
			month = 5;
			break;

		case "june":
			month = 6;
			break;

		case "july":
			month = 7;
			break;

		case "august":
			month = 8;
			break;

		case "september":
			month = 9;
			break;

		case "octomber":
			month = 10;
			break;

		case "november":
			month = 11;
			break;

		case "december":
			month = 12;
			break;

		default:
			throw new IllegalArgumentException
			("Argument " + monthString + " is not a valid month descriptor.");
		}


		// validate month
		if (month < 1 || month > 12)
			throw new IllegalArgumentException ("Month " + month + " must be within 1 - 12.");


		// check if day in range for month
		if (day < 1 ||
		   (day > daysPerMonth[month] && !(month == 2 && day == 29)))
				throw new IllegalArgumentException ("Day " + day + " out of range for the specified month and year.");


		// check if leap year and if month is 2 and day 29
		if ((month == 2 && day == 29) && !(year % 400 == 0 || (year % 4 == 0 && year % 100 !=0)))
				throw new IllegalArgumentException ("Day " + day + " out of range for the specified month and year.");


		// check year range - between 1900 and 2100
		if (year < 1900 || year > 2100)
			throw new IllegalArgumentException ("Year " + year + " must be within 1900 - 2100.");


		this.month = month;
		this.day = day;
		this.year = year;

	}


	public EnhancedDate(int daysInYear, int year)
	{
		this.daysInYear = daysInYear;
		if (daysInYear < 0 ||
				(
					(
						!(year % 400 == 0 || (year % 4 == 0 && year % 100 !=0)) && daysInYear > 365
					)

					||

					(
						(year % 400 == 0 || (year % 4 == 0 && year % 100 !=0)) && daysInYear > 366
					)
				)
			)
			throw new IllegalArgumentException
			("Days " + daysInYear + " must be within 1 - 365/6 depending on year.");

		// check year range - between 1900 and 2100
				if (year < 1900 || year > 2100)
					throw new IllegalArgumentException ("Year " + year + " must be within 1900 - 2100.");

		boolean keepSubstracting = true;
		int month = 1;

		do
		{
			int substract = daysPerMonth[month];
			if (month == 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 !=0)))
				substract ++;

			if(daysInYear - substract <= 0)
				keepSubstracting = false;

			else
				{
				daysInYear -= substract;
				month++;
				}
		}

		while (keepSubstracting);

		this.day = daysInYear;
		this.month = month;
		this.year = year;

	}
	// methods
	// method to test if the year is a leapYear
	public boolean isLeapYear()
	{
		 if(year % 400 == 0 || (year % 4 == 0 && year % 100 !=0))
			return true;
		 else
			return false;
	}

	//increment methods
	//increment day
	public void incrementDay()
	{
		if (month == 2 && isLeapYear())
			{
			if((day + 1) > (daysPerMonth[month]+1))
				{
				incrementMonth();
				day = 1;
				setDaysInYear();
				}
			else
				{
				day ++;
				setDaysInYear();
				}
			}

		else
			{
			if((day + 1) > daysPerMonth[month])
				{
				incrementMonth();
				day = 1;
				setDaysInYear();
				}
			else
				{
				day++;
				setDaysInYear();
				}

			}
	}

	//increment month
	public void incrementMonth()
	{
		if ((month + 1) > 12)
			{
			incrementYear();
			month = 1;
			setDaysInYear();
			}
		else
			{
			month ++;
			setDaysInYear();
			}

	}

	// increment year
	public void incrementYear()
	{
		year ++;
	}

	private void setDaysInYear()
	{
		daysInYear = 0;
		for (int index = 1; index < month; index ++)
		{
			daysInYear += (daysPerMonth[index]);
			if(index == 2 && isLeapYear())
				daysInYear ++;
		}

		daysInYear += day;
	}

	// accesor methods
	// accesor for month
	public int getMonth()
	{
		return month;
	}

	// accesor for day
	public int getDay()
	{
		return day;
	}

	// accesor for year
	public int getYear()
	{
		return year;
	}

	// to string method
	public String toString()
	{
		return String.format("%d/%d/%d", month, day, year);
	}

	public String toMonthString()
	{
		String output = "";

		switch (month)
		{

		case 1:
			output += "january";
			break;

		case 2:
			output += "february";
			break;

		case 3:
			output += "march";
			break;

		case 4:
			output += "april";
			break;

		case 5:
			output += "may";
			break;

		case 6:
			output += "june";
			break;

		case 7:
			output += "july";
			break;

		case 8:
			output += "august";
			break;

		case 9:
			output += "september";
			break;

		case 10:
			output += "octomber";
			break;

		case 11:
			output += "november";
			break;

		case 12:
			output += "december";
			break;
		}

		output = output +" " + day +", " + year;
		return output;
	}

	public String toDaysInYearString()
	{
		return String.format("%d %d", daysInYear,year);
	}

} // end class EnhancedDate