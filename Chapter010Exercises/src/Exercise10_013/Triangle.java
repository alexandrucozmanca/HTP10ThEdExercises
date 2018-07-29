package Exercise10_013;

public class Triangle extends Shape2D
{
	private Point firstPoint;
	private Point secondPoint;
	private Point thirdPoint;


	// no argument constructor
	public Triangle()
	{
		this(Point.ZERO, Point.ZERO, Point.ZERO);
	}

	// Triangle with Point object as arguments
	public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint)
	{
		this.firstPoint = firstPoint;
		this.secondPoint = secondPoint;
		this.thirdPoint = thirdPoint;
	}


	// accesor methods
	// accesor for upper left point
	public final Point getFirstPoint()
	{
		return firstPoint;
	}

	// accesor for lower right point
	public final Point getSecondPoint()
	{
		return secondPoint;
	}


	// accesor for lower right point
	public final Point getThirdPoint()
	{
		return thirdPoint;
	}

	// mutator methods
	// mutator for first point
	public final void setFirstPoint(Point firstPoint)
	{
		this.firstPoint = firstPoint;
	}

	// mutator for second point
	public final void setSecondPoint(Point secondPoint)
	{
		this.secondPoint = secondPoint;
	}

	// mutator for second point
	public final void setThirdPoint(Point thirdPoint)
	{
		this.thirdPoint = thirdPoint;
	}

	// method to return area of the rectangle
	@Override
	public final double getArea()
	{
 		double p = (getFirstPoint().getDistance(getSecondPoint()) +
 					getFirstPoint().getDistance(getThirdPoint()) +
 					getSecondPoint().getDistance(getThirdPoint())) / 2;


		return Math.sqrt(p * (p - getFirstPoint().getDistance(getSecondPoint())) *
						     (p - getFirstPoint().getDistance(getThirdPoint())) *
						     (p - getSecondPoint().getDistance(getThirdPoint())));
	}

	// toString method
	@Override
	public final String toString()
	{
		return String.format("Triange bounded by %s, %s and %s.",
				getFirstPoint(), getSecondPoint(), getThirdPoint());
	}
}
