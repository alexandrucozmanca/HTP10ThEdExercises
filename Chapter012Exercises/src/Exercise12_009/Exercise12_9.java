package Exercise12_009;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Exercise12_9
{

	public static void main(String[] args)
	{
		CalcFrame frame = new CalcFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(200, 200);
		

	}

}

class CalcFrame extends JFrame
{

	private final String[] buttonNames = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-",
			"0", ".", "=", "+"};
	private final JButton[] buttons = new JButton[16];
	private final JTextField inputField = new JTextField();

	CalcFrame()
	{
		super("Calculator");
		setLayout(new BorderLayout());




		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 4, 2, 2));
		for(int button = 0; button < buttons.length; button ++)
		{
			buttons[button] = new JButton(buttonNames[button]);
			buttonPanel.add(buttons[button]);
		}

		Container container = getContentPane();

		container.add(buttonPanel, BorderLayout.CENTER);
		container.add(inputField, BorderLayout.NORTH);

	}


}
