package Exercise013_18;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ScreenSaver 
{
	
	public static void main(String[] args)
	{
		Saver app = new Saver();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		app.setSize(screen);
		app.setVisible(true);
	}
}

class Saver extends JFrame implements ActionListener
{
	JPanel canvas;
	Timer timer;
	Saver()
	{
		super("Screensaver");
		canvas = new JPanel() 
		{
			Random random = new Random();
			@Override
			public void paintComponent(Graphics g)
			{
				super.paintComponents(g);
				setBackground(Color.WHITE);
				
				Dimension bounds = Toolkit.getDefaultToolkit().getScreenSize();
				
				g.clearRect(0, 0, getWidth(), getHeight());
				
				for (int count = 0; count < 10; count ++ )
				{
					g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
					g.drawLine(random.nextInt((int)bounds.getWidth()), random.nextInt((int)bounds.getHeight()),
								random.nextInt((int)bounds.getWidth()), random.nextInt((int)bounds.getHeight()));
				}
				
				Graphics2D g2d = (Graphics2D) g;
				
				for (int count = 0; count < 10; count ++ )
				{
					int x1 = random.nextInt((int)bounds.getWidth());
					int y1 = random.nextInt((int)bounds.getHeight());
					
					int x2 = random.nextInt(100);
					
					
					Color color1 = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
					Color color2 = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
					g2d.setPaint(new GradientPaint(x1, y1, color1, x1 + x2, y1 + x2, color2, false));
					g2d.fill(new Ellipse2D.Double(x1 ,y1, x2, x2));
				}
				
				for (int count = 0; count < 10; count ++ )
				{
					int x1 = random.nextInt((int)bounds.getWidth());
					int y1 = random.nextInt((int)bounds.getHeight());
					
					int x2 = random.nextInt(100);
					
					
					Color color1 = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
					Color color2 = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
					g2d.setPaint(new GradientPaint(x1, y1, color1, x1 + x2, y1 + x2, color2, false));
					g2d.fill(new Rectangle2D.Double(x1 ,y1, x2, x2));
				}
				
				GeneralPath star = new GeneralPath();

				int[] xPoints = {55, 67, 109, 73, 83, 55, 27, 37, 1, 43};
				int[] yPoints = {0, 36, 36, 54, 96, 72, 96, 54, 36, 36};
				
				for(int count = 0; count < 10; count ++)
				{
					
					int offset1 = 50 + random.nextInt(150);
					int offset2 = 50 + random.nextInt(150);
					
					for (int point2 = 0; point2 < xPoints.length; point2 ++)
					{
						xPoints[point2] += offset1;
						yPoints[point2] += offset2;
					}
					
					// set the initial coordinate of the General Path
					star.moveTo(xPoints[0], yPoints[0]);

					// create the star--this does not draw the star
					for (int point = 1; point < xPoints.length; point ++)
						star.lineTo(xPoints[point], yPoints[point]);
										
					star.closePath();
					g2d.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
					
					g2d.fill(star);
				}
				
			}
					
		};
		add(canvas);
		
		timer = new Timer(500, this);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		canvas.repaint();
	}
}


