package Exercise12_017;

import java.awt.Color;
import java.awt.Graphics;

public abstract class MyShape
{
	private int x1; // x coordinate of first endpoint
	private int y1; // y coordinate of first endpoint
	private int x2; //x coordinate of second endpoint
	private int y2; // y coordinate of second endpoint
	private Color color; // color of this shape

	// constructor with validation and coordinats and color provided as arguments
	public MyShape(int x1, int y1, int x2, int y2, Color color)
	{
		if (x1 < 0)
			throw new IllegalArgumentException("Value of X1 must be non-negative.");
		if (y1 < 0)
			throw new IllegalArgumentException("Value of Y1 must be non-negative.");
		if (x2 < 0)
			throw new IllegalArgumentException("Value of X2 must be non-negative.");
		if (y2 < 0)
			throw new IllegalArgumentException("Value of Y2 must be non-negative.");

		if (color.getGreen() < 0 || color.getGreen() > 255)
			color = Color.BLACK;

		if (color.getBlue() < 0 || color.getBlue() > 255)
			color = Color.BLACK;

		if (color.getRed() < 0 || color.getRed() > 255)
			color = Color.BLACK;


		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
	}

	// no argument constructor
	public MyShape()
	{
		this(0,0,0,0,Color.BLACK);
	}


	// mutator methods
	// mutator for X1
	final public void setX1(int x1)
	{
		if (x1 >= 0)
			this.x1 = x1;
		else
			this.x1 = 0;
	}

	// mutator for Y1
	final public void setY1(int y1)
	{
		if (y1 >= 0)
			this.y1 = y1;
		else
			this.y1 = 0;
	}

	// mutator for X2
	final public void setX2(int x2)
	{
		if (x2 >= 0)
			this.x2 = x2;
		else
			this.x2 = 0;
	}

	// mutator for Y2
	final 	public void setY2(int y2)
	{
		if (y2 >= 0)
			this.y2 = y2;
		else
			this.y2 = 0;
	}

	// mutator for color
	final public void setColor (Color color)
	{
		if (color.getGreen() < 0 || color.getGreen() > 255)
			color = Color.BLACK;
		if (color.getBlue() < 0 || color.getBlue() > 255)
			color = Color.BLACK;
		if (color.getRed() < 0 || color.getRed() > 255)
			color = Color.BLACK;
		this.color = color;
	}

	// mutator for filled


	// accesor methods
	// accesor for x1
	final public int getX1()
	{
		return x1;
	}

	// accesor for y1
	final public int getY1()
	{
		return y1;
	}

	// accesor for x2
	final public int getX2()
	{
		return x2;
	}

	// accesor for y2
	final public int getY2()
	{
		return y2;
	}

	// accesor for color
	final public Color getColor()
	{
		return color;
	}

	// draw shape method
	public abstract void draw(Graphics g);
}
