package Exercise013_31;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DrawPanel extends JPanel
{
	private MyShape[] shapes; // array containing the shapes that will be drawn
	private int shapeCount; // counter for shapes number
	private int shapeType; // instance variable to determine the type of shape

	// instance variables denoting the type of the shape
	static final int line = 0;
	static final int oval = 1;
	static final int rectangle = 2;

	private MyShape currentShape; // instance variable denoting the current shape to be drawn
	private Paint currentColor; // instance variable denoting the current color being used
	private boolean filledShape; // instance variable denoting if the shape is filled or not
	private JLabel statusLabel; // GUI component to provide user-info
	private Stroke currentStroke;


	// constructor with JLabel as argument
	DrawPanel(JLabel statusLabel)
	{
		super();
		//initialize instance variables
		this.statusLabel = statusLabel; // initialize variable with provided argument
		shapes = new MyShape[100]; // initialize variable
		shapeCount = 0; // initialize variable
		shapeType = line; // default shape is line
		currentColor = (Paint) Color.BLACK; // default color is BLACK
		currentStroke = new BasicStroke(); // default Stroke is BasicStroke

		// create and assign mouseHandler for DrawPane;
		MouseHandler mouseHandler = new MouseHandler();
		this.addMouseListener(mouseHandler);
		this.addMouseMotionListener(mouseHandler);
		this.setBackground(Color.WHITE);



	}

	// method paintComponent to update JPanel
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		for (int shape = 0; shape < shapeCount; shape++)
			if (shapes[shape] != null)
				shapes[shape].draw(g2d);
	}

	// method to set the shape type for the shape
	public void setShape(int shapeType)
	{
		if(shapeType == line || shapeType == oval || shapeType == rectangle)
			this.shapeType = shapeType;
	}

	// method to set the current color
	public void setCurrentColor(Paint paint)
	{
		currentColor = paint;
	}

	// method to set if the shape is filled or not
	public void setFilledShape(boolean filled)
	{
		filledShape = filled;
	}

	// method to set Stroke
	public void setStroke (Stroke stroke)
	{
		currentStroke = stroke;
	}

	// method to return info from statusLabel
	public JLabel getStatusLabel()
	{
		return statusLabel;
	}

	// method to clear the last shape
	public void clearLastShape()
	{
		// decrease the shapeCount by 1 only if the shapeCount is not already 0
		if (shapeCount > 0)
		{
			currentShape = null;
			repaint();
			shapes[shapeCount] = null;
			shapeCount--;

			// repaint JPanel to update the display
			repaint();
		}

	}

	// method to clear the whole JPanel by reseting the shapeCount
	public void clearDrawing()
	{
		for (int i = shapeCount; i >= 0 ; i --)
		shapes[shapeCount] = null;
		shapeCount = 0;
		currentShape = null;
		// repaint JPanel to update the display
		repaint();
	}


	// inner method to enable interaction via mouse
	private class MouseHandler extends MouseAdapter implements MouseMotionListener
	{
		// on mouse press a new shape will be created with X and Y coord at mouse position
		@Override
		public void mousePressed(MouseEvent mouseEvent)
		{
			// store mouse position
			int x = mouseEvent.getX();
			int y = mouseEvent.getY();

			shapeCount ++;

			//create a new Shape - of type determined by shapeType and with first point at X Y coord of the mouse
			switch (shapeType)
			{
				case line:
					currentShape = new MyLine();
					break;

				case oval:
					currentShape = new MyOval();
					break;

				case rectangle:
					currentShape = new MyRectangle();
					break;
			}

			// set first point of the shape
			currentShape.setX1(x);
			currentShape.setY1(y);
			currentShape.setColor(currentColor);
			currentShape.setStroke(currentStroke);

			if (currentShape instanceof MyBoundedShape)
			{
				MyBoundedShape temp = (MyBoundedShape) currentShape;
				temp.setFilled(filledShape);
			}

		}

		// on mouse release the shape will be finalized, added to the shape array and currentshape will be reset
		@Override
		public void mouseReleased(MouseEvent mouseEvent)
		{
			//store mouse position
			int x = mouseEvent.getX();
			int y = mouseEvent.getY();

			// set shape`s second point coordinates
			currentShape.setX2(x);
			currentShape.setY2(y);

			// assign current shape to shape array
			shapes[shapeCount-1] = currentShape;

			currentShape = null; // reset current shape
			repaint(); // repaint drawpanel to update display
		}

		// on mouse move the mouse position is reported to the user in the status label
		@Override
		public void mouseMoved(MouseEvent mouseEvent)
		{
			statusLabel.setText(String.format("(%d.%d)",mouseEvent.getX(), mouseEvent.getY()));
		}

		// on mouse drag the shape should be refreshed to provide visual feedback
		@Override
		public void mouseDragged(MouseEvent mouseEvent)
		{
			// store mouse position
			int x = mouseEvent.getX();
			int y = mouseEvent.getY();

			// update shape`s second point
			currentShape.setX2(x);
			currentShape.setY2(y);

			shapes[shapeCount-1] = currentShape;

			repaint(); // repaint drawPanel for visual feedback
			// additional feed-back with coords shown in statusLabel
			statusLabel.setText(String.format("(%d.%d)",mouseEvent.getX(), mouseEvent.getY()));
		}

		@Override
		public void mouseExited(MouseEvent mouseEvent)
		{
			statusLabel.setText("Hey, don`t go, continue Drawing");
		}
	}
}



