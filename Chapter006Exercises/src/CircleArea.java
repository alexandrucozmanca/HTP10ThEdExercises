// application to compute the area of a circle
import java.util.Random; //needed for 'random' object

public class CircleArea 
{

	public static void main(String[] args) 
	{
		Random tester = new Random(); // random generator for testing purposes
		
		
		// run for 10 iterations
		for (int i = 1; i <= 10; i++)
		{
			double radius = 10 * tester.nextDouble();
			System.out.printf("A circle of radius %.3f has an area of %.5f.%n", 
					radius, computeArea(radius));
		}
		
		
	}

	private static double computeArea(double radius)
	{
		double area; // local variable
		area = Math.PI * radius * radius; // compute circle area
		
		return area;
	}
	
}
