package Exercise10_013;

import java.util.Random;

public class ShapesTest
{

	public static void main(String[] args)
	{
		Random randomNumbers = new Random();
		final int arrayLength = 12; // randomly decide how many shapes, at least one should exist

		Shape[] shapes = new Shape[arrayLength]; // initiate the variable


		for (int count = 0; count < shapes.length; count ++)
		{

			// for circles
			if (count <= 1)
			{
				Circle circle = new Circle(Point.ZERO ,randomNumbers.nextInt(5));
				shapes[count] = circle;
			}

			// for rectangles
			if (count > 1 && count <= 3)
			{
				Rectangle rectangle = new Rectangle(Point.ZERO, new Point (randomNumbers.nextInt(5), randomNumbers.nextInt(5)));
				shapes[count] = rectangle;
			}

			// for triangles
			if (count > 3 && count <= 5)
			{
				Triangle triangle = new Triangle(Point.ZERO, new Point (randomNumbers.nextInt(5), randomNumbers.nextInt(5)),
						 new Point (randomNumbers.nextInt(5), randomNumbers.nextInt(5)));

				shapes[count] = triangle;
			}

			// for spheres
			if (count > 5 && count <=7)
			{
				Sphere sphere = new Sphere(Point3D.ZERO, randomNumbers.nextInt(5));
				shapes[count] = sphere;
			}

			// for cubes
			if (count > 7 && count <=9)
			{
				Cube cube = new Cube(randomNumbers.nextInt(5));
				shapes[count] = cube;
			}

			// for tetrahedrons
			if (count > 9 && count <= shapes.length)
			{
				RegularTetrahedron tetrahedron = new RegularTetrahedron(randomNumbers.nextInt(5));
				shapes[count] = tetrahedron;
			}
		}


		for (Shape shape: shapes)
		{
			if (shape instanceof Shape2D)
			{
				System.out.printf("%s It has an area of: %.2f.%n", shape, ((Shape2D) shape).getArea());
			}

			if (shape instanceof Shape3D)
			{
				System.out.printf("%s It has an area of: %.2f and a volume of: %.2f.%n", shape, ((Shape3D) shape).getArea(),
						((Shape3D) shape).getVolume());
			}

			System.out.println(shape.getClass().getName());
			System.out.println();

		}

	}

}
