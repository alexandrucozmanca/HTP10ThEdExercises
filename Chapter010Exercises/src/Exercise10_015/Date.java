package Exercise10_015;

final public class Date
{
	private int month; // 1-12
	private int day; // 1-31 depending on month
	private int year; // any year

	private static final int [] daysPerMonth =
		{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	// constructors
	// constructor with validation for month and day given the year
	public Date(int month, int day, int year)
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

	// methods
	// method to test if the year is a leapYear
	final public boolean isLeapYear()
	{
		 if(year % 400 == 0 || (year % 4 == 0 && year % 100 !=0))
			return true;
		 else
			return false;
	}

	//increment methods
	//increment day
	final public void incrementDay()
	{
		if (month == 2 && isLeapYear())
			{
			if((day + 1) > (daysPerMonth[month]+1))
				{
				incrementMonth();
				day = 1;
				}
			else
				day ++;
			}
			else
			{
			if((day + 1) > daysPerMonth[month])
				{
				incrementMonth();
				day = 1;
				}
			else
				day++;
			}
	}

	//increment month
	final public void incrementMonth()
	{
		if ((month + 1) > 12)
		{
			incrementYear();
			month = 1;
		}
		else
			month ++;
	}

	// increment year
	final public void incrementYear()
	{
		year ++;
	}

	// to string method
	@Override
	final public String toString()
	{
		return String.format("%d/%d/%d", month, day, year);
	}

	// accesor methods
	// accesor for day
	final public int getDay()
	{
		return day;
	}

	// accesor for month
	final public int getMonth()
	{
		return month;
	}

	// accesor for year
	final public int getYear()
	{
		return year;
	}

} // end class Date

