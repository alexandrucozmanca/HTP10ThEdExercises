package Exercise12_017;

import java.awt.Color;
import java.awt.Graphics;

final public class MyOval extends MyBoundedShape
{
	//default constructor
	public MyOval()
	{
		this(0,0,0,0,Color.BLACK,false);
	}

	// constructor with values
	public MyOval(int x1, int y1, int x2, int y2, Color color, Boolean filled)
	{
		super(x1, y1, x2, y2, color, filled);

	}

	// method to draw oval
	@Override
	final public void draw(Graphics g)
	{
		g.setColor(getColor());
		if (getFilled())
			g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		else
			g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());

	}

} // end MyOval
