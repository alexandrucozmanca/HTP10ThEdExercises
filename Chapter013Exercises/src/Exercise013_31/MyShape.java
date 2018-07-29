package Exercise013_31;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public abstract class MyShape
{
	private int x1; // x coordinate of first endpoint
	private int y1; // y coordinate of first endpoint
	private int x2; //x coordinate of second endpoint
	private int y2; // y coordinate of second endpoint
	private Paint paint; // color of this shape
	private Stroke stroke;


	// constructor with validation and coordinats and color provided as arguments
	public MyShape(int x1, int y1, int x2, int y2, Paint paint, Stroke stroke)
	{
		if (x1 < 0)
			throw new IllegalArgumentException("Value of X1 must be non-negative.");
		if (y1 < 0)
			throw new IllegalArgumentException("Value of Y1 must be non-negative.");
		if (x2 < 0)
			throw new IllegalArgumentException("Value of X2 must be non-negative.");
		if (y2 < 0)
			throw new IllegalArgumentException("Value of Y2 must be non-negative.");

		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.paint = paint;
		this.stroke = stroke;
	}

	// no argument constructor
	public MyShape()
	{
		this(0,0,0,0,Color.BLACK, new BasicStroke());
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
	final public void setColor (Paint paint)
	{
		this.paint = paint;
	}

	// mutator for color
	final public void setStroke (Stroke stroke)
	{
		this.stroke = stroke;
	}


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
	final public Paint getColor()
	{
		return paint;
	}

	// accesor for stroke
	final public Stroke getStroke()
	{
		return stroke;
	}


	// draw shape method
	public abstract void draw(Graphics2D g2d);
}
