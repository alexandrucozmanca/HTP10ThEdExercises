package exercise8_10;

public class TraficLightTest
{

	public static void main (String[] args)
	{
		for (TraficLight light : TraficLight.values())
			System.out.printf("%-6s: %-10s%n",light, light.getDuration());
	}

}

enum TraficLight
{
	RED("15 seconds"),
	YELLOW("20 seconds"),
	GREEN("25 seconds");

	private final String duration; // light duration

	//constructor
	TraficLight(String duration)
	{
		this.duration = duration;
	}

	// accesor for duration field
	public String getDuration()
	{
		return duration;
	}
}
