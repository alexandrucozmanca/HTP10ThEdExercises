package Exercise16_15;

import java.awt.Color;
import java.awt.Graphics;

final public class MyRectangle extends MyBoundedShape
{
	//default constructor
	public MyRectangle()
	{
		this(0,0,0,0,Color.BLACK, false);

	}

	// constructor with values
	public MyRectangle(int x1, int y1, int x2, int y2, Color color, Boolean filled)
	{
		super (x1, y1, x2, y2, color, filled);

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
