// Application for computing a triangle`s hypotenuse

import java.util.Random; // for random no. generation

public class Hypotenuse
{
	public static void main(String[] args)
	{
		Random side = new Random(); // for random side generation

		System.out.printf("Triangle\tSide I\tSide II\tHypo1\tHypo2%n");

		// run test 10 times
		for (int i = 1; i <= 10; i++)
		{
			double side1 = 10 * side.nextDouble();
			double side2 = 10 * side.nextDouble();

			System.out.printf("%8d\t%.2f\t%.2f\t%.2f\t%.2f%n",i ,side1, side2,
					computeHypotenuse(side1,side2),Math.hypot(side1, side2));
		}

	}

	private static double computeHypotenuse(double side1, double side2)
	{
		double hypotenuse;

		// compute the hypotenuse
		hypotenuse = Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));

		return hypotenuse;
	}

}
