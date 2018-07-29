package exercise8_7;

public class EnhancedSecondsTimeTest
{
	public static void main (String[] args)
	{

		EnhancedSecondsTime t1 = new EnhancedSecondsTime();
		EnhancedSecondsTime t2 = new EnhancedSecondsTime(2);
		EnhancedSecondsTime t3 = new EnhancedSecondsTime(13, 25);
		EnhancedSecondsTime t4 = new EnhancedSecondsTime(22, 58, 59);

		System.out.printf("Constructor with no arguments t1:%n%s%n%s%n",t1,t1.toUniversalString());
		System.out.printf("Constructor with hour argument t2:%n%s%n%s%n",t2,t2.toUniversalString());
		System.out.printf("Constructor with hour argument t3:%n%s%n%s%n",t3,t3.toUniversalString());
		System.out.printf("Constructor with hour argument t4:%n%s%n%s%n",t4,t4.toUniversalString());

		EnhancedSecondsTime t5 = new EnhancedSecondsTime(t4);
		t4.tick();
		System.out.printf("t4 after tick() increment:%n%s%n%s%n",t4,t4.toUniversalString());
		t4.incrementMinute();
		System.out.printf("t4 after incrementMinute() increment:%n%s%n%s%n",t4,t4.toUniversalString());
		t4.incrementHour();
		System.out.printf("t4 after incrementHour() increment:%n%s%n%s%n",t4,t4.toUniversalString());
	}
}


class EnhancedSecondsTime
{
	private int secondsSinceMidnight;

	// constructor without values supplied
	public EnhancedSecondsTime()
	{
		this(0, 0, 0);
	}

	// constructor with hour supplied
	public EnhancedSecondsTime (int hour)
	{
		this(hour, 0, 0);
	}

	// constructor with hour and minute supplied
	public EnhancedSecondsTime (int hour, int minute)
	{
		this(hour, minute, 0);
	}

	// constructor with hour, minute and second supplied
	public EnhancedSecondsTime (int hour, int minute, int second)
	{
		if (hour < 0 || hour > 23)
			throw new IllegalArgumentException("Hour must be between 0 and 23.");

		if (minute < 0 || minute > 59)
			throw new IllegalArgumentException("Minute must be between 0 and 59.");

		if (second < 0 || second > 59)
			throw new IllegalArgumentException("Second must be between 0 and 59");

		secondsSinceMidnight = hour * 60 * 60 + minute * 60 + second;
	}

	// constructor with Time2 object supplied
	public EnhancedSecondsTime (EnhancedSecondsTime time)
	{
		this(time.getHour(), time.getMinute(), time.getSecond());
	}

	// methods

	// set methods with universal time
	// validate and set time
	public void setTime(int hour, int minute, int second)
	{
		if (hour < 0 || hour > 23)
			throw new IllegalArgumentException("Hour must be between 0 and 23.");

		if (minute < 0 || minute > 59)
			throw new IllegalArgumentException("Minute must be between 0 and 59.");

		if (second < 0 || second > 59)
			throw new IllegalArgumentException("Second must be between 0 and 59");

		secondsSinceMidnight = hour * 60 * 60 + minute * 60 + second;
	}


	// validate and set hour
	public void setHour (int hour)
	{
		if (hour < 0 || hour > 23)
			throw new IllegalArgumentException("Hour must be between 0 and 23.");
		secondsSinceMidnight = secondsSinceMidnight % (60 * 60) + hour * 60 * 60;
	}

	// validate and set minute
	public void setMinute (int minute)
	{
		if (minute < 0 || minute > 59)
			throw new IllegalArgumentException("Minute must be between 0 and 59.");
		secondsSinceMidnight = secondsSinceMidnight - (secondsSinceMidnight % (60 * 60)  /  60 ) * 60
				+ minute * 60 ;

	}


	// validate and set second
	public void setSecond (int second)
	{
		if (second < 0 || second > 59)
			throw new IllegalArgumentException("Second must be between 0 and 59.");
		secondsSinceMidnight = secondsSinceMidnight - ((secondsSinceMidnight % 60) % 60)
				+ second;
	}

	// get methods
	// get Hour
	public int getHour()
	{
		return secondsSinceMidnight / (60 * 60);
	}

	// get Minute
	public int getMinute()
	{
		return secondsSinceMidnight % (60 * 60) / 60;
	}

	// get Second
	public int getSecond()
	{
		return secondsSinceMidnight % (60 * 60) % 60;
	}

	// time increment methods
	// increment 1 second
	public void tick()
	{
		secondsSinceMidnight++;
		checkForMidnight();
	}

	// increment 1 minute
	public void incrementMinute()
	{
		secondsSinceMidnight += 60;
		checkForMidnight();
	}

	// increment 1 hour
	public void incrementHour()
	{
		secondsSinceMidnight += 3600;
		checkForMidnight();
	}

	// check if 24 have passed and reset time if
	public void checkForMidnight()
	{
		if (secondsSinceMidnight >= 86400 )
			secondsSinceMidnight -= 86400;
	}

	// to string Methods
	// to Universal Time
	public String toUniversalString()
	{
		return String.format("%02d:%02d:%02d",getHour(), getMinute(), getSecond());
	}

	// to Standard Time
	public String toString()
	{
		return String.format("%d:%02d:%02d %s",((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
				getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
	}


}// end class Time2



