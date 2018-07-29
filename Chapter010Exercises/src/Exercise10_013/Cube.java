package Exercise10_013;

public class Cube extends Shape3D
{
	double sideLength;

	// no argument constructor
	Cube()
	{
		this(0);
	}

	// constructor with validation and side length as argument
	Cube(double sideLength)
	{
		if(sideLength < 0.0)
			throw new IllegalArgumentException("Side must be positive.");
		this.sideLength = sideLength;
	}

	// accesor methods
	// accesor for sideLength
	public final double getSideLength()
	{
		return sideLength;
	}

	// mutator methods
	// mutator for side Length
	public final void setSideLength(double sideLength)
	{
		if(sideLength < 0.0)
			throw new IllegalArgumentException("Side must be positive.");
		this.sideLength = sideLength;
	}

	// method to return area of cube
	public final double getArea()
	{
		return 6 * Math.pow(getSideLength(), 2.0);
	}

	// method to return volumne of cube
	public final double getVolume()
	{
		return Math.pow(getSideLength(), 3.0);
	}


	//to string method
	public final String toString()
	{
		return String.format("Cube of side length: %.2f.",getSideLength());
	}
}
