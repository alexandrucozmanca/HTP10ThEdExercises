package Exercise16_15;

import java.awt.Color;
import java.awt.Graphics;

final public class MyLine extends MyShape
{

	// no argument constructor
	public MyLine()
	{
		super();
	}

	// constructor with input values
	public MyLine(int x1, int y1, int x2, int y2, Color color)
	{
		super(x1, y1, x2, y2, color);
	}

	// draw the line in the specified color
	@Override
	final public void draw(Graphics g)
	{
	g.setColor(getColor());
	g.drawLine(getX1(), getY1(), getX2(), getY2());
	}
} //end class MyLine



