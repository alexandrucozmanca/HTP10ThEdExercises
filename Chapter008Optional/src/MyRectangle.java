import java.awt.Color;
import java.awt.Graphics;

public class MyRectangle
{
	private int x1; // x coord for first endpoint
	private int y1; // y coord for first endpoint
	private int x2; // x coord for second endpoint
	private int y2; // y coord for second endpoint
	private Color color;
	private Boolean filled;

	//default constructor
	public MyRectangle()
	{
		this(0,0,0,0,Color.BLACK,false);
	}

	// constructor with values
	public MyRectangle(int x1, int y1, int x2, int y2, Color color, Boolean filled)
	{
		setX1(x1);
		setY1(y1);
		setX2(x2);
		setY2(y2);
		setColor(color);
		this.filled = filled;
	}

	// get methods
	// method to obtain upper left X coord
	public int getUpperLeftX()
	{
		int upperLeftX = x1;
		if (x2 < x1)
			upperLeftX = x2;
		return upperLeftX;
	}

	// method to obtain upper left Y coord
	public int getUpperLeftY()
	{
		int upperLeftY = y1;
		if (y2 < y1)
			upperLeftY = y2;
		return upperLeftY;
	}

	// method to obtain width
	public int getWidth()
	{
		return Math.abs(x1 - x2);
	}

	// method to obtain height
	public int getHeight()
	{
		return Math.abs(y1 - y2);
	}

	// set methods
	// method to set X coord of first end-point
	public void setX1(int x1)
	{
		if (x1 >= 0)
			this.x1 = x1;
		else
			this.x1 = 0;
	}

	// method to set Y coord of first end-point
	public void setY1(int y1)
	{
		if (y1 >= 0)
			this.y1 = y1;
		else
			this.y1 = 0;
	}

	// method to set X coord of second end-point
	public void setX2(int x2)
	{
		if (x2 >= 0)
			this.x2 = x2;
		else
			this.x2 = 0;
	}

	// method to set Y coord of second end-point
	public void setY2(int y2)
	{
		if (y2 >= 0)
			this.y2 = y2;
		else
			this.y2 = 0;
	}

	// method to set Color
	public void setColor (Color color)
	{
		if (color.getGreen() < 0 || color.getGreen() > 255)
			color = Color.BLACK;
		if (color.getBlue() < 0 || color.getBlue() > 255)
			color = Color.BLACK;
		if (color.getRed() < 0 || color.getRed() > 255)
			color = Color.BLACK;
		this.color = color;
	}



	public void draw(Graphics g)
	{
		g.setColor(color);
		if (filled)
			g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		else
			g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());

	}

} // end MyRectagle
