package Optional010_2;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestDraw
{

	public static void main(String[] args)
	{
		DrawPanel myPanel = new DrawPanel(); // create Draw Panel instance
		JFrame app = new JFrame(); // create JFrame instance


		JLabel details = new JLabel(myPanel.getComponentDetails());

		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set close behavior
		app.add(myPanel); // add myPannel to app
		app.add(details, BorderLayout.SOUTH);
		app.setSize(400, 400);
		app.setVisible(true);
	}

}// end class TestDraw
