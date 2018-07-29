package Optional010_2;

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;
import javax.swing.JPanel;

final public class DrawPanel extends JPanel
{

	public final int arrayLength;
	private SecureRandom randomNumbers = new SecureRandom();
	private MyShape[] shapes;

	public DrawPanel()
	{
		arrayLength = 1 + randomNumbers.nextInt(10); // randomly decide how many shapes, at least one should exist

		shapes = new MyShape[arrayLength]; // initiate the variable
		setBackground(Color.WHITE); // set background color
		boolean filled; // instance variable to determine if shape is full or not

		//create lines


		for (int count = 0; count < shapes.length; count ++)
		{
			filled = false; // assume shape is not filled

			// generate random color
			Color color = new Color (randomNumbers.nextInt(256),randomNumbers.nextInt(256),
					randomNumbers.nextInt(256));

			// randomly decide if shape is full
			if (randomNumbers.nextInt(300) < 150)
				filled = true;


			// for lines
			if (count <= 3)
			{
				MyLine line = new MyLine(randomNumbers.nextInt(300),randomNumbers.nextInt(300),
						randomNumbers.nextInt(300),randomNumbers.nextInt(300), color);
				shapes[count] = line;
			}

			// for ovals
			if (count > 3 && count <= 5)
			{
				MyOval oval = new MyOval(randomNumbers.nextInt(300),randomNumbers.nextInt(300),
					randomNumbers.nextInt(300),randomNumbers.nextInt(300), color, filled);
				shapes[count] = oval;
			}

			// for rectangles
			if (count > 5)
			{
				MyRectangle rectangle = new MyRectangle(randomNumbers.nextInt(300),randomNumbers.nextInt(300),
					randomNumbers.nextInt(300),randomNumbers.nextInt(300), color, filled);

				shapes[count] = rectangle;

			}
		}
	}

	// method to paint all the array components
	final public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		// draw the shape objects
		for (int shape = 0; shape < shapes.length;shape ++)

		try
		{
			shapes[shape].draw(g); // invoke respective draw method
		}

		catch (ArrayIndexOutOfBoundsException e)
		{

		}
	}

	// accesor for shapes array components
	final public MyShape getShape(int arrayIndex)
	{
		return shapes[arrayIndex];
	}

	// accesor for shapes
	final public MyShape[] getShapes()
	{
		return shapes;
	}

	// accesor for shape component detalis - returns a string containing the no. of each individual objects
	final public String getComponentDetails()
	{

		int lines = 0;
		int ovals = 0;
		int rectangles = 0;

		for (int shape = 0; shape < getShapes().length; shape++)
		{
			if (shapes[shape] instanceof MyLine)
				lines ++;

			if (shapes[shape] instanceof MyOval)
				ovals ++;

			if (shapes[shape] instanceof MyRectangle)
				rectangles++;
		}

		return String.format("Array contains "+ shapes.length + " shapes: Lines " + lines + " Ovals: " + ovals +
		" Rectangles: " + rectangles);

	}

}// end class DrawPannel
