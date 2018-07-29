package Exercise10_013;

public class Rectangle extends Shape2D
{
	private Point upperLeftPoint;
	private Point lowerRightPoint;


	// no argument constructor
	public Rectangle()
	{
		this(Point.ZERO, Point.ZERO);
	}

	// circle with upper left Point and lower right as arguments
	public Rectangle(Point upperLeftPoint, Point lowerRightPoint)
	{
		this.upperLeftPoint = upperLeftPoint;
		this.lowerRightPoint = lowerRightPoint;
	}


	// accesor methods
	// accesor for upper left point
	public final Point getUpperLeftPoint()
	{
		return upperLeftPoint;
	}

	// accesor for lower right point
	public final Point getLowerRightPoint()
	{
		return lowerRightPoint;
	}


	// mutator methods
	// mutator for upper left point
	public final void setUpperLeftPoint(Point upperLeftPoint)
	{
		this.upperLeftPoint = upperLeftPoint;
	}

	// mutator for lower right point
	public final void setLowerRightPoint(Point lowerRightPoint)
	{
		this.lowerRightPoint = lowerRightPoint;
	}


	// method to determine length of the rectangle (arbitrarily set as difference of X coord)
	public final double getLength()
	{
		return Math.abs(upperLeftPoint.getX() - lowerRightPoint.getX());
	}

	// method to determine width of the rectangle (arbitrarily set as difference of Y coord)
	public final double getWidth()
	{
			return Math.abs(upperLeftPoint.getY() - lowerRightPoint.getY());
	}

	// method to return area of the rectangle
	@Override
	public final double getArea()
	{
		return getLength() * getWidth();
	}

	// toString method
	@Override
	public final String toString()
	{
		return String.format("Rectangle bounded by upper left point %s and lower right point %s.",
				upperLeftPoint, lowerRightPoint);
	}
}
