package Exercise10_013;


// class that represents the Cartesian coordinates of a point in a positive-only coordinate reference system
public class Point
{
	private double x; // x coord
	private double y; // y coord


	static Point ZERO = new Point(0.0, 0.0); // static Point object with X = 0 and Y = 0


	// constructor with double variables as arguments
	public Point (double x, double y)

	{
		// variable validation
		if (x < 0.0)
			throw new IllegalArgumentException ("X coordinate must be positive.");
		if (y < 0.0)
			throw new IllegalArgumentException ("Y coordinate must be positive.");

		this.x = x;
		this.y = y;
	}

	// accesor methods
	// accesor for X coord
	public final double getX()
	{
		return x;
	}

	// accesor for Y coord
	public final double getY()
	{
		return y;
	}

	// mutator methods
	// mutator for X
	public final void setX(double x)
	{
		if (x < 0.0)
			throw new IllegalArgumentException ("X coordinate must be positive.");
		this.x = x;
	}

	// mutator for Y
	public final void setY(double y)
	{
		if (y < 0.0)
			throw new IllegalArgumentException ("Y coordinate must be positive.");
		this.y = y;
	}

	// method to obtain the distance between this point and another point privided as argument
	public final double getDistance(Point point)
	{
		return Math.sqrt(Math.pow((this.getX() - point.getX()), 2.0) + Math.pow((this.getY() - point.getY()), 2.0));
	}

	// toString method
	public final String toString()
	{
		return String.format("(%.2f, %.2f)", getX(), getY());
	}

}
