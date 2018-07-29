package Exercise10_013;

public class Circle extends Shape2D
{
	private Point center;
	private double radius;


	// no argument constructor
	public Circle()
	{
		this(Point.ZERO, 0.0);
	}

	// circle with center Point and double radius as arguments
	public Circle(Point center, double radius)
	{
		// 	validate radius
		if (radius < 0.0)
			throw new IllegalArgumentException ("Radius must be positive.");

		this.center = center;
		this.radius = radius;
	}


	// accesor methods
	// accesor for center
	public final Point getCenter()
	{
		return center;
	}

	// accesor for radius
	public final double getRadius()
	{
		return radius;
	}

	// mutator methods
	// mutator for center
	public final void setCenter(Point center)
	{
		this.center = center;
	}

	// mutator for radius
	public final void setRadius(double radius)
	{
		if (radius < 0.0)
			throw new IllegalArgumentException ("Radius must be positive.");
		this.radius = radius;
	}


	// method to return area of the circle
	@Override
	public final double getArea()
	{
		return 2 * radius * Math.PI;
	}

	// toString method
	@Override
	public final String toString()
	{
		return String.format("Circle with center at %s and radius %,.2f", center, radius);
	}
}
