package Exercise10_013;

public class Sphere extends Shape3D
{
	private Point3D center;
	private double radius;


	// no argument constructor
	public Sphere()
	{
		this(Point3D.ZERO, 0.0);
	}

	// sphere with center Point and double radius as arguments
	public Sphere(Point3D center, double radius)
	{
		// 	validate radius
		if (radius < 0.0)
			throw new IllegalArgumentException ("Radius must be positive.");

		this.center = center;
		this.radius = radius;
	}


	// accesor methods
	// accesor for center
	public final Point3D getCenter()
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
	public final void setCenter(Point3D center)
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


	// method to return area of the sphere
	@Override
	public final double getArea()
	{
		return 4 * Math.PI * Math.pow(getRadius(), 2.0);
	}

	// method to return volume of the sphere
	@Override
	public final double getVolume()
	{
		return 4 / 3 * Math.PI * Math.pow(getRadius(), 3);
	}

	// toString method
	@Override
	public final String toString()
	{
		return String.format("Sphere with center at %s and radius %,.2f", center, radius);
	}
}
