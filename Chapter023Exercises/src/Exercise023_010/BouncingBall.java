package Exercise023_010;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BouncingBall extends JFrame
{
	private final DrawPanel drawPanel;
	private final JLabel statusLabel;
		
	public BouncingBall()
	{
		super("Bouncing balls with SwingWorker");
		
		statusLabel = new JLabel(" ");
		drawPanel = new DrawPanel(statusLabel);
		
		setLayout(new BorderLayout());
		add(drawPanel, BorderLayout.CENTER);
		add(statusLabel, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args)
	{
		BouncingBall application = new BouncingBall();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(300, 300);
		application.setVisible(true);
	}
	
}

// inner class DrawPanel - where the ball will be drawn
class DrawPanel extends JPanel
{
	private final int MAX_BALLS = 1; // maximum allowed balls
	private Circle[] balls; // array containing balls
	private int ballCount; // current balls created
	private JLabel statusLabel; // GUI component to provide user-info
	
	private BallMover ballMover;
	
	
	DrawPanel(JLabel statusLabel)
	{
		super();
		balls = new Circle[MAX_BALLS];
		ballCount = 0;
		
		this.statusLabel = statusLabel;
		
		ballMover = new BallMover(balls, this);
		ballMover.execute();
		
		// initialize and add mouse handler
		MouseHandler mouseHandler = new MouseHandler();
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseHandler);
		
		// setbackground to White
		setBackground(Color.WHITE);
		setBorder(new TitledBorder(new LineBorder(Color.BLACK)));
	}
	
	//method paintComponent to update JPanel
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for (int ball = 0; ball < balls.length; ball ++)
			if(balls[ball] != null)
				balls[ball].draw(g);
		repaint();
	}
	
	// mouse handler method
	private class MouseHandler extends MouseAdapter implements MouseMotionListener
	{
		
		// on mouse press a new shape will be created with center at X and Y coord
		@Override
		public void mousePressed(MouseEvent mouseEvent)
		{
			// store mouse position
			int x = mouseEvent.getX();
			int y = mouseEvent.getY();
						
			balls[ballCount % MAX_BALLS] = new Circle(x, y, Color.BLUE);
			ballCount ++;
			statusLabel.setText("Created at: " + x + "," + y +".");
		}
		
		// on mouse movement
		@Override
		public void mouseMoved(MouseEvent mouseEvent)
		{
			statusLabel.setText("Mouse at: " + mouseEvent.getX() + "," + mouseEvent.getY() +".");
		}
	}
}


// inner class for ball objects with a diameter of BALL_DIAM
class Circle
{
	private final int BALL_DIAM = 10; // ball diameter
	
	private Color color; // color
	private int x; // xCoord of ball
	private int y; // yCoord of ball
	
	// constructor with arguments
	Circle(int x, int y, Color color)
	{
		this.x = x;
		this.y = y ;
		this.color = color;
	}
	
	// no arguments constructor
	Circle()
	{
		this(0, 0, Color.BLACK);
	}
	
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getX()
	{
		return x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getY()
	{
		return y;
	}

	public void setColor(Color color)
	{
		this.color = color;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	final public void draw(Graphics g)
	{
		g.setColor(getColor());
		g.fillOval(getX(), getY(), BALL_DIAM, BALL_DIAM);
	}
	
}

//inner class simulating a ball moving by continually incrementing Y coord and sleeping for THREAD_SLEEP 
// the greater the value of THREAD_SLEEP the slower the movement
class BallMover extends SwingWorker<Circle[], Circle[]>
{
	private final Circle[] balls;
	private final int THREAD_SLEEP = 25;
	private DrawPanel panel;
		
	// constructor 
	BallMover(Circle[] balls, DrawPanel panel)
	{
		this.balls = balls;
		this.panel = panel;
	}
	
	// update  YCoord for all drawn balls 
	public Circle[] doInBackground()
	{
		
		boolean action = true;
				
		int[] direction = new int[balls.length]; // falling direction (positive down, negative up)
		Arrays.fill(direction, 1);
		
		while (action)
		{
			for (int i = 0; i < balls.length; i ++)
				if(balls[i] != null)
				{	
					if ((balls[i].getY() + direction[i]) > panel.getSize().getHeight() - 10 ||
							(balls[i].getY() + direction[i]) < 0)
						direction[i] *= -1;
										
					balls[i].setY(balls[i].getY() + direction[i]);
				}
			
			try
			{
				Thread.sleep(THREAD_SLEEP);
			}
			catch (InterruptedException ex)
			{
			
			}
		}
		
		return balls;
	}

	
}