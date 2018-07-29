package exercise8_7;

public class EnhancedTimeTest
{
	public static void main (String[] args)
	{
		EnhancedTime t4 = new EnhancedTime(22, 58, 59);

		System.out.printf("Constructor with hour argument t4:%n%s%n%s%n",t4,t4.toUniversalString());

		t4.tick();
		System.out.printf("t4 after tick() increment:%n%s%n%s%n",t4,t4.toUniversalString());
		t4.incrementMinute();
		System.out.printf("t4 after incrementMinute() increment:%n%s%n%s%n",t4,t4.toUniversalString());
		t4.incrementHour();
		System.out.printf("t4 after incrementHour() increment:%n%s%n%s%n",t4,t4.toUniversalString());
	}

}

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

	// check if 24 have passed and reset time if
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

}
