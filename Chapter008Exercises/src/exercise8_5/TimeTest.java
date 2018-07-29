package exercise8_5;

public class TimeTest
{
	public static void main (String[] args)
	{

		Time t1 = new Time();
		Time t2 = new Time(2);
		Time t3 = new Time(13, 25);
		Time t4 = new Time(13, 25, 59);

		System.out.printf("Constructor with no arguments t1:%n%s%n%s%n",t1,t1.toUniversalString());
		System.out.printf("Constructor with hour argument t2:%n%s%n%s%n",t2,t2.toUniversalString());
		System.out.printf("Constructor with hour argument t3:%n%s%n%s%n",t3,t3.toUniversalString());
		System.out.printf("Constructor with hour argument t4:%n%s%n%s%n",t4,t4.toUniversalString());

		Time t5 = new Time(t4);
		System.out.printf("Constructor with hour argument t5:%n%s%n%s%n",t5,t5.toUniversalString());
		t5.setHour(12);
		System.out.printf("Constructor with hour argument t5:%n%s%n%s%n",t5,t5.toUniversalString());
		t5.setMinute(20);
		System.out.printf("Constructor with hour argument t5:%n%s%n%s%n",t5,t5.toUniversalString());
		t5.setSecond(30);
		System.out.printf("Constructor with hour argument t5:%n%s%n%s%n",t5,t5.toUniversalString());
	}
}


class Time
{
	private int secondsSinceMidnight;

	// constructor without values supplied
	public Time()
	{
		this(0, 0, 0);
	}

	// constructor with hour supplied
	public Time (int hour)
	{
		this(hour, 0, 0);
	}

	// constructor with hour and minute supplied
	public Time (int hour, int minute)
	{
		this(hour, minute, 0);
	}

	// constructor with hour, minute and second supplied
	public Time (int hour, int minute, int second)
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
	public Time (Time time)
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



