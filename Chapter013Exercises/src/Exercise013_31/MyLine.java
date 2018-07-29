package Exercise013_31;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

final public class MyLine extends MyShape
{

	// no argument constructor
	public MyLine()
	{
		super();
	}

	// constructor with input values
	public MyLine(int x1, int y1, int x2, int y2, Color color, Stroke stroke)
	{
		super(x1, y1, x2, y2, color, stroke);
	}

	// draw the line in the specified color
	@Override
	final public void draw(Graphics2D g)
	{
	g.setPaint(getColor());
	g.setStroke(getStroke());
	g.drawLine(getX1(), getY1(), getX2(), getY2());
	}
} //end class MyLine



