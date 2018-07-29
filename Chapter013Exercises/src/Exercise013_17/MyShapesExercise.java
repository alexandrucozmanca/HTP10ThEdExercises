package Exercise013_17;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyShapesExercise
{

	public static void main(String[] args)
	{
		JFrame app = new JFrame("My test drawings.");

		MyShapes panel = new MyShapes();
		app.setLayout(new BorderLayout());
		app.add(panel, BorderLayout.CENTER);

		JLabel info = new JLabel("");
		info = panel.getMouseCoord();


		app.add(info, BorderLayout.SOUTH);


		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(700, 600);
		app.setVisible(true);

	}
}

class MyShapes extends JPanel implements MouseMotionListener
{
	public JLabel mouseCoord = new JLabel("");
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		addMouseMotionListener(this);
		setBackground(Color.WHITE);

		// exercise 13.6
		for (int x = 0; x < 10; x ++)
			g.drawArc((5 + 10 * x), (5 + 10 * x), 220 - (20 * x), 220 - (20 * x) , 0, 360);

		// exercise 13.7
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.RED);

		for (int x = 0; x < 10; x++ )
			g2d.draw(new Ellipse2D.Double((230 + 10 * x),
										  (5 + 10 * x),
										  (220 - (20 * x)),
										  (220 - (20 * x))
										  )) ;

		// exercise 13.8
		g2d.setColor(Color.GREEN);

		for (int x = 0; x < 10; x++)
		{
			g2d.setStroke(new BasicStroke((float)x));
			g2d.draw(new Line2D.Double(460 + x * 10, 5, 560 + x * 10 + x, 220 + x * 2));
		}

		// modified exercise 13.9 - no randomness today
		GeneralPath triangle = new GeneralPath();
		g2d.setColor(Color.BLUE);

		for (int x = 0; x < 10; x ++)
		{
			int[] xCoord = new int[3];
			int[] yCoord = new int[3];

			xCoord[0] = 105;
			yCoord[0] = 245 + x * 10;

			xCoord[1] = 10 + x * 10;
			yCoord[1] = 435 - x * 10;

			xCoord[2] = 200 - x * 10;
			yCoord[2] = 435 - x * 10;

			triangle.moveTo(xCoord[0], yCoord[0]);
			triangle.lineTo(xCoord[1], yCoord[1]);
			triangle.lineTo(xCoord[2], yCoord[2]);
			triangle.closePath();

			g2d.setStroke(new BasicStroke(2.0f));
			g2d.draw(triangle);
		}

		// modified exercise 13.10 - no randomness today
		g.setColor(Color.CYAN);
		for (int x = 0; x < 10; x ++)
		{
			String output = String.format(" what ever ");
			g.drawString(output, 210, 250 + 20 * x);
		}


		// exercise 13.11
		g.setColor(new Color(255, 0, 255));
		for (int x = 1; x < 9; x ++)
		{

			g.drawLine(280 + 10 * x, 240 , 280 + 10 * x, 330);
			g.drawLine(280, 240  + 10 * x, 370, 240 + 10 * x);
		}

		// exercise 13.12
		g2d.setColor(new Color(138, 43, 226));
		g2d.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		for (int x = 1; x < 9; x ++)
		{

			g2d.draw(new Line2D.Double(280 + 10 * x, 340 , 280 + 10 * x, 430));
			g2d.draw(new Line2D.Double(280, 340  + 10 * x, 370, 340 + 10 * x));
		}

		// exercise 13.13
		g.setColor(Color.YELLOW);
		for (int x = 0; x < 9; x ++)
		{
			g.drawRect(385 + x * 10, 240, 10, 90);
			g.drawRect(385, 240 + x * 10, 90, 10);
		}

		// exercise 13.14
		g2d.setColor(Color.ORANGE);
		for (int x = 0; x < 9; x ++)
		{
			g2d.draw(new Rectangle2D.Double(385 + x * 10, 340, 10, 90));
			g2d.draw(new Rectangle2D.Double(385, 340 + x * 10, 90, 10));
		}

		// exercise 13.15
		g2d.setColor(new Color(214, 143, 88));
		int tetraX[] = {550, 550, 500, 600};
		int tetraY[] = {240, 290, 330, 330};

		GeneralPath tetrahedron = new GeneralPath();
		for (int point = 0; point < 4; point ++)
		{
			tetrahedron.moveTo(tetraX[point], tetraY[point]);
			tetrahedron.lineTo(tetraX[(1 + point) % 4], tetraY[(1 + point) % 4]);
			tetrahedron.moveTo(tetraX[point], tetraY[point]);
			tetrahedron.lineTo(tetraX[(2 + point) % 4], tetraY[(2 + point) % 4]);
			tetrahedron.moveTo(tetraX[point], tetraY[point]);
			tetrahedron.lineTo(tetraX[(3 + point) % 4], tetraY[(3 + point) % 4]);
		}

		tetrahedron.closePath();
		g2d.draw(tetrahedron);

		// exercise 13.16
		g2d.setColor(new Color(134, 93, 38));
		int cubeX[] = {500, 500, 580, 580, 600, 520, 600, 520};
		int cubeY[] = {360, 440, 440, 360, 340, 340, 420, 420};

		GeneralPath cube = new GeneralPath();
		cube.moveTo(cubeX[0], cubeY[0]);

		for (int point = 1; point < 6; point ++)
			cube.lineTo(cubeX[point], cubeY[point]);

		cube.lineTo(cubeX[0], cubeY[0]);
		cube.lineTo(cubeX[3], cubeY[3]);
		cube.moveTo(cubeX[2], cubeY[2]);
		cube.lineTo(cubeX[6], cubeY[6]);
		cube.lineTo(cubeX[4], cubeY[4]);

		g2d.draw(cube);

		float[] dash = {5};
		g2d.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 5, dash, 0));

		cube.moveTo(cubeX[7], cubeY[7]);
		cube.lineTo(cubeX[6], cubeY[6]);
		cube.moveTo(cubeX[7], cubeY[7]);
		cube.lineTo(cubeX[1], cubeY[1]);
		cube.moveTo(cubeX[7], cubeY[7]);
		cube.lineTo(cubeX[5], cubeY[5]);

		g2d.draw(cube);


	}

	public JLabel getMouseCoord()
	{
		return mouseCoord;
	}



	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		int x = arg0.getX();
		int y = arg0.getY();

		mouseCoord.setText(String.format("Mouse at %d,%d", x, y));

	}
}


