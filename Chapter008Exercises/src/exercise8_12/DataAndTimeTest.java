package exercise8_12;



public class DataAndTimeTest
{

	public static void main(String[] args)
	{
		DateAndTime dt1 = new DateAndTime();

		EnhancedDate d1 = new EnhancedDate(2, 29, 2016);
		DateAndTime dt2 = new DateAndTime(d1);

		EnhancedTime t1 = new EnhancedTime(12, 1, 1);
		DateAndTime dt3 = new DateAndTime(t1);
		DateAndTime dt4 = new DateAndTime(d1,t1);

		DateAndTime dt5 = new DateAndTime(12, 31, 2017, 23, 59 ,59);



		System.out.println(dt1);
		System.out.println(dt2);
		System.out.println(dt3);
		System.out.println(dt4);
		System.out.println(dt5);
		dt5.tick();
		System.out.println(dt5);
	}

} // end class DateAndTimeTest

class DateAndTime
{
	private int hour; // 0 -  23
	private int minute; // 0 - 59
	private int second; // 0 - 59
	private int month; // 1-12
	private int day; // 1-31 depending on month
	private int year; // any year from 1900 - 2100

	private static final int [] daysPerMonth =
		{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


	// constructors
	// constructor with no arguments
	DateAndTime()
	{
		this(1, 1, 1900, 0, 0, 0);
	}

	// constructor with EnhancedDate object as argument
	DateAndTime(EnhancedDate date)
	{
		this(date.getMonth(), date.getDay(), date.getYear(), 0, 0, 0);
	}

	// constructor with EnhancedTime object as argument
	DateAndTime(EnhancedTime time)
	{
		this(1, 1, 1900, time.getHour(), time.getMinute(), time.getSecond());
	}

	// constructor with EnhancedDate and EnhancedTime objects as arguments
	DateAndTime(EnhancedDate date, EnhancedTime time)
	{
		this(date.getMonth(), date.getDay(), date.getYear(),time.getHour(), time.getMinute(), time.getSecond());
	}

	// constructor with validation for all values
	DateAndTime(int month, int day, int year, int hour, int minute, int second)
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

				if (hour < 0 || hour > 23)
					throw new IllegalArgumentException("Hour must be between 0 and 23.");

				if (minute < 0 || minute > 59)
					throw new IllegalArgumentException("Minute must be between 0 and 59.");

				if (second < 0 || second > 59)
					throw new IllegalArgumentException("Second must be between 0 and 59");

				this.month = month;
				this.day = day;
				this.year = year;
				this.hour = hour;
				this.minute = minute;
				this.second = second;
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

	// accesor for Hour
	public int getHour()
	{
		return hour;
	}

	// accesor for Minute
	public int getMinute()
	{
		return minute;
	}

	// accesor for Second
	public int getSecond()
	{
		return second;
	}

	// accesor for derived EnhancedDate object
	public EnhancedDate getDate()
	{
		return new EnhancedDate(this.getMonth(), this.getDay(), this.getDay());
	}

	// accesor for derived EnhancedTime object
	public EnhancedTime getTime()
	{
		return new EnhancedTime(this.getHour(), this.getMinute(), this.getSecond());
	}

	// mutator methods
	// mutator for month
	public void setMonth(int month)
	{
		if (month < 0 || month > 12)
			throw new IllegalArgumentException ("Month " + month + " must be within 1 - 12.");
		this.month = month;
	}

	// mutator for day
	public void setDay(int day)
	{
		if (day < 1 ||
				   (day > daysPerMonth[month] && !(month == 2 && day == 29)))
			throw new IllegalArgumentException ("Day " + day + " out of range for the specified month and year.");

		if ((month == 2 && day == 29) &&
				!(year % 400 == 0 || (year % 4 == 0 && year % 100 !=0)))
			throw new IllegalArgumentException ("Day " + day + " out of range for the specified month and year.");

		this.day = day;
	}

	// mutator for year
	public void setYear(int year)
	{
		if (year < 1900 || year > 2100)
			throw new IllegalArgumentException ("Year " + year + " must be within 1900 - 2100.");
		this.year = year;
	}

	// mutator for hour
	public void setHour(int hour)
	{
		if (hour < 0 || hour > 23)
			throw new IllegalArgumentException("Hour must be between 0 and 23.");
		this.hour = hour;
	}

	// mutator for minute
	public void setMinute(int minute)
	{
		if (minute < 0 || minute > 59)
			throw new IllegalArgumentException("Minute must be between 0 and 59.");
		this.minute = minute;
	}

	// mutator for second
	public void setSecond(int second)
	{
		if (second < 0 || second > 59)
			throw new IllegalArgumentException("Second must be between 0 and 59");
		this.second = second;
	}

	// mutator for whole date
	public void setDate(int month, int day, int year)
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

	// mutator for whole date with EnhancedDate object as argument
	public void setDate(EnhancedDate date)
	{
		setDate(date.getMonth(),date.getDay(),date.getYear());
	}

	// mutator for whole time
	public void setTime(int hour, int minute, int second)
	{
		if (hour < 0 || hour > 23)
			throw new IllegalArgumentException("Hour must be between 0 and 23.");

		if (minute < 0 || minute > 59)
			throw new IllegalArgumentException("Minute must be between 0 and 59.");

		if (second < 0 || second > 59)
			throw new IllegalArgumentException("Second must be between 0 and 59");

		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	// mutator for whole time with EnhancedTime object as argument
	public void setTime(EnhancedTime time)
	{
		setTime(time.getHour(), time.getMinute(), time.getSecond());
	}

	// mutator for whole date with DateAndTime object as argument
	public void setDate(DateAndTime date)
	{
		setDate(date.getDate());
	}

	// mutator for whole time with DateAndTime object as argument
	public void setTime(DateAndTime date)
	{
		setTime(date.getTime());
	}

	// mutator with DateAndTime object as argument
	public void set(DateAndTime date)
	{
		setDate(date.getDate());
		setTime(date.getTime());
	}

	// mutator with all values as arguments
	public void set(int month, int day, int year, int hour, int minute, int second)
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

				if (hour < 0 || hour > 23)
					throw new IllegalArgumentException("Hour must be between 0 and 23.");

				if (minute < 0 || minute > 59)
					throw new IllegalArgumentException("Minute must be between 0 and 59.");

				if (second < 0 || second > 59)
					throw new IllegalArgumentException("Second must be between 0 and 59");

				this.month = month;
				this.day = day;
				this.year = year;
				this.hour = hour;
				this.minute = minute;
				this.second = second;
	}

	// increment methods
	// time increment methods
	// increment 1 second
	public void tick()
	{
		if ((second + 1) >= 60)
			incrementMinute();
		second = (second + 1) %60 ;

	}

	// increment 1 minute
	public void incrementMinute()
	{
		if ((minute + 1) >= 60)
			incrementHour();
		minute = (minute + 1) % 60;
	}

	// increment 1 hour
	public void incrementHour()
	{
		if ((hour + 1) >= 24)
			{
			checkForMidnight();
			incrementDay();
			}
		hour = (hour + 1) % 24;
	}

	// check if 24 h have passed and reset time if
	public void checkForMidnight()
	{
		if (hour >= 24 )
			hour -= 23;
	}

	//increment day
	public void incrementDay()
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
	public void incrementMonth()
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
	public void incrementYear()
	{
		year ++;
	}

	// method to test if the year is a leapYear
	public boolean isLeapYear()
	{
		 if(year % 400 == 0 || (year % 4 == 0 && year % 100 !=0))
			return true;
		 else
			return false;
	}

	// to string methods
	// toDate string method
	public String toDateString()
	{
		return String.format("%d/%d/%d", month, day, year);
	}

	public String toUniversalTimeString()
	{
		return String.format("%02d:%02d:%02d",hour, minute, second);
	}

	public String toStandardTimeString()
	{
		return String.format("%d:%02d:%02d %s",((hour == 0 || hour == 12) ? 12 : hour % 12),
				minute, second, (hour < 12 ? "AM" : "PM"));
	}

	public String toString()
	{
		return String.format("%d/%d/%d: %d:%02d:%02d", month, day, year, hour, minute, second);
	}
}// end Class DateAndTime

class EnhancedTime
{

	private int hour; // 0 -  23
	private int minute; // 0 - 59
	private int second; // 0 - 59

	// constructor without values supplied
	public EnhancedTime()
	{
		this(0, 0, 0);
	}

	// constructor with hour supplied
	public EnhancedTime (int hour)
	{
		this(hour, 0, 0);
	}

	// constructor with hour and minute supplied
	public EnhancedTime (int hour, int minute)
	{
		this(hour, minute, 0);
	}

	public EnhancedTime (int hour, int minute, int second)
	{
		if (hour < 0 || hour > 23)
			throw new IllegalArgumentException("Hour must be between 0 and 23.");

		if (minute < 0 || minute > 59)
			throw new IllegalArgumentException("Minute must be between 0 and 59.");

		if (second < 0 || second > 59)
			throw new IllegalArgumentException("Second must be between 0 and 59");

		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public EnhancedTime (EnhancedTime time)
	{
		this(time.getHour(), time.getMinute(), time.getSecond());
	}

	public void setTime (int hour, int minute, int second)
	{
		if (hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59)
			throw new IllegalArgumentException ("hour, minute and/or seccond was out of range");

		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	// get Hour
	public int getHour()
	{
		return hour;
	}

	// get Minute
	public int getMinute()
	{
		return minute;
	}

	// get Second
	public int getSecond()
	{
		return second;
	}


	// time increment methods
	// increment 1 second
	public void tick()
	{
		if ((second + 1) >= 60)
			incrementMinute();
		second = (second + 1) %60 ;

	}

	// increment 1 minute
	public void incrementMinute()
	{
		if ((minute + 1) >= 60)
			incrementHour();
		minute = (minute + 1) % 60;
	}

	// increment 1 hour
	public void incrementHour()
	{
		if ((hour + 1) >= 24)
				checkForMidnight();
		hour = (hour + 1) % 24;
	}

	// check if 24 h have passed and reset time if
	public void checkForMidnight()
	{
		if (hour >= 24 )
			hour -= 23;
	}



	public String toUniversalString()
	{
		return String.format("%02d:%02d:%02d",hour, minute, second);
	}

	public String toString()
	{
		return String.format("%d:%02d:%02d %s",((hour == 0 || hour == 12) ? 12 : hour % 12),
				minute, second, (hour < 12 ? "AM" : "PM"));
	}

} // end class EnhancedTime

class EnhancedDate
{
	private int month; // 1-12
	private int day; // 1-31 depending on month
	private int year; // any year

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
	public void incrementMonth()
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
	public void incrementYear()
	{
		year ++;
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

} // end class EnhancedDate