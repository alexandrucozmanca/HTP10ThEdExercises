// application to draw BullsEye with 2 random colors

import java.awt.Color;
import javax.swing.JFrame;
import java.util.Random;

public class DrawBullsEye
{

	public static void main(String[] args)
	{
		// create Random object to generate colors
		Random colorComponent = new Random();

		// create the two random colors
		Color color1 = new Color (colorComponent.nextInt(256),colorComponent.nextInt(256),colorComponent.nextInt(256));
		Color color2 = new Color (colorComponent.nextInt(256),colorComponent.nextInt(256),colorComponent.nextInt(256));

		//create a BullsEye object to paint the pattern
		BullsEye bullsEye = new BullsEye(color1, color2, 20, 10);

		// create  JFram to display pattern
		JFrame application = new JFrame();

		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(40 + 2 * bullsEye.numberOfCircles * bullsEye.step,
				30 + 2 * bullsEye.numberOfCircles*bullsEye.step);
		application.add(bullsEye);
		application.setVisible(true);

	}

}
