package Exercise12_018;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyBoardTest
{

	public static void main(String[] args)
	{
		JFrame app = new JFrame("Typing Application");
		app.setLayout(new BorderLayout());

		JLabel infoLabel = new JLabel("Text to be inserted here");
		infoLabel.setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 0));
		app.add(infoLabel, BorderLayout.NORTH);

		VirtualKeyBoard2 keys = new VirtualKeyBoard2();
		keys.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		app.add(keys, BorderLayout.CENTER);

		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		app.setResizable(false);
		app.setSize(700, 410);
	}

}
