package exercise8_4;

public class RectangleTest
{

	public static void main(String[] args)
	{
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(10.0, 10.0);
		Rectangle r3 = new Rectangle(-2.0, 30.0);

		System.out.print(r1);
		System.out.print(r2);
		System.out.print(r3);
		
		r3.setLength(2.0);
		r3.setWidth(3.0);
		
		System.out.print(r3);

		
	}

}


class Rectangle
{
	// instance variable
	private double length; // length 0 - 20
	private double width; // width 0 - 20

	// default constructor
	Rectangle()
	{
		this(1,1);
	}

	// constructor with input values
	Rectangle (double length, double width)
	{
		setLength(length);
		setWidth(width);
	}

	// set methods
	// set length method
	public void setLength(double length)
	{
		if (length > 0 && length <= 20)
			this.length = length;
		else
			{
			this.length = 1;
			System.out.println("Length must be between 0 and 20, length set to default 1.");
			}

	}

	// set width method
	public void setWidth(double width)
	{
		if (width > 0 && width <= 20)
			this.width = width;
		else
			{
			this.width = 1;
			System.out.println("Width must be between 0 and 20, width set to default 1.");
			}
	}


	// get methods
	// get length
	public double getLength()
	{
		return length;
	}

	// get width
	public double getWidth()
	{
		return width;
	}

	// get perimeter
	public double getPerimeter()

	{
		return 2 * (width + length);
	}

	// get area
	public double getArea()
	{
		return width * length;
	}

	public String toString()
	{
		return String.format("Rectangle of width %.2f and length %.2f has perimeter %.2f and area %.2f.%n",
				getWidth(), getLength(),getPerimeter(),getArea());
	}
}