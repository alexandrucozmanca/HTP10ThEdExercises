package Optional010_1;

import java.awt.Color;
import java.awt.Graphics;

final public class MyRectangle extends MyShape
{
	private Boolean filled;

	//default constructor
	public MyRectangle()
	{
		this(0, 0, 0, 0, Color.BLACK, false);
	}

	// constructor with values
	public MyRectangle(int x1, int y1, int x2, int y2, Color color, Boolean filled)
	{
		super (x1, y1, x2, y2, color);
		this.filled = filled;
	}

	// accesor methods
	// method to obtain upper left X coord
	final public int getUpperLeftX()
	{
		int upperLeftX = getX1();
		if (getX2() < getX1())
			upperLeftX = getX2();
		return upperLeftX;
	}

	// method to obtain upper left Y coord
	final public int getUpperLeftY()
	{
		int upperLeftY = getY1();
		if (getY2() < getY1())
			upperLeftY = getY2();
		return upperLeftY;
	}

	// method to obtain width
	final public int getWidth()
	{
		return Math.abs(getX1() - getX2());
	}

	// method to obtain height
	final public int getHeight()
	{
		return Math.abs(getY1() - getY2());
	}

	// accesor for filled
	final public boolean getFilled()
	{
		return filled;
	}


	// mutator method
	// mutator for filled
	final public void setFilled(boolean filled)
	{
		this.filled = filled;
	}


	// method to draw rectangle
	@Override
	final public void draw(Graphics g)
	{
		g.setColor(getColor());
		if (getFilled())
			g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		else
			g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());

	}

} // end MyRectagle
