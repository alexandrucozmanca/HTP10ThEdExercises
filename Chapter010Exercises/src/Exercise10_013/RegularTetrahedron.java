package Exercise10_013;

public class RegularTetrahedron extends Shape3D
{
	double sideLength;

	// no argument constructor
	RegularTetrahedron()
	{
		this(0);
	}

	// constructor with validation and side length as argument
	RegularTetrahedron(double sideLength)
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
		return Math.sqrt(3.0) * Math.pow(getSideLength(), 2.0);
	}

	// method to return volumne of cube
	public final double getVolume()
	{
		return Math.pow(getSideLength(), 3.0) / 6 / Math.sqrt(2.0);
	}


	//to string method
	public final String toString()
	{
		return String.format("Regular tetrahedron of side length: %.2f.",getSideLength());
	}
}
