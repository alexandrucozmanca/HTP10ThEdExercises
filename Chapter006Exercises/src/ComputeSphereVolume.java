// compute the volume of a sphere with a given radius

import java.util.Scanner;
public class ComputeSphereVolume {

	public static void main(String[] args)
	{
		double radius, // sphere radius
		volume; // sphere volume

		Scanner input = new Scanner(System.in); //scanner object for user input

		System.out.print("Please input the sphere`s volume: ");
		radius = input.nextDouble(); // read user input

		volume = sphereVolume(radius);

		System.out.printf("Sphere of radius %.4f has a volume of %.4f.",radius,volume);

		input.close();

	}


	// method to compute the volume of a given sphere
	public static double sphereVolume(double radius)
	{
		return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
	}

}
