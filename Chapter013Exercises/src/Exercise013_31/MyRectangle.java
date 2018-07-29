package Exercise013_31;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

final public class MyRectangle extends MyBoundedShape
{
	//default constructor
	public MyRectangle()
	{
		this(0,0,0,0,Color.BLACK, new BasicStroke(), false);

	}

	// constructor with values
	public MyRectangle(int x1, int y1, int x2, int y2, Color color, Stroke stroke, Boolean filled)
	{
		super (x1, y1, x2, y2, color, stroke, filled);

	}

	// method to draw rectangle
	@Override
	final public void draw(Graphics2D g2d)
	{
		g2d.setPaint(getColor());
		g2d.setStroke(getStroke());
		if (getFilled())
			g2d.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		else
			g2d.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());

	}




} // end MyRectagle
