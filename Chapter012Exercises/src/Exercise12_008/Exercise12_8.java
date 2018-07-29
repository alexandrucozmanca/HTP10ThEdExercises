package Exercise12_008;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Exercise12_8
{

	public static void main(String[] args)
	{
		AlignFrame frame = new AlignFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();

	}

}

class AlignFrame extends JFrame
{

	// JCheckBox GUI components
	private final JCheckBox snapJCheckBox = new JCheckBox("Snap to Grid");
	private final JCheckBox showJCheckBox = new JCheckBox("Show Grid");

	// JTextField GUI components
	private final JTextField xField = new JTextField("8", 5);
	private final JTextField yField = new JTextField("8", 5);

	// JLabel GUI components
	private final JLabel xLabel = new JLabel("X:");
	private final JLabel yLabel = new JLabel("Y:");

	// JButton GUI components
	private final JButton okJButton = new JButton("OK");
	private final JButton cancelJButton = new JButton("Cancel");
	private final JButton helpJButton = new JButton("Help");

	AlignFrame()
	{
		super("Align"); // set frame info
		setLayout(new FlowLayout()); // select layout

		// create 4 JPanels that will hold the required components
		// JPanel for checkboxes
		JPanel checkBox = new JPanel();
		checkBox.setLayout(new GridLayout(2, 1, 15, 5)); // set gridLayout
		// add checkboxes
		checkBox.add(snapJCheckBox);
		checkBox.add(showJCheckBox);

		

		// JPanel for labels
		JPanel infoBox = new JPanel();
		infoBox.setLayout(new GridLayout(2, 1, 15, 5));
		// add labels
		infoBox.add(xLabel);
		infoBox.add(yLabel);

		

		// JPanel for TextField
		JPanel textBox = new JPanel();
		textBox.setLayout(new GridLayout(2, 1, 15, 5));
		// add TextFields
		textBox.add(xField);
		textBox.add(yField);

		// add JPanel to frame
	

		// JPanel for JButtons
		JPanel buttonBox  = new JPanel();
		buttonBox.setLayout(new GridLayout (3, 1, 10, 5));
		// add JButtons
		buttonBox.add(okJButton);
		buttonBox.add(cancelJButton);
		buttonBox.add(helpJButton);

		
		Container container = getContentPane();
		container.setLayout(new FlowLayout(FlowLayout.CENTER, 10 ,5));
		
		// add JPanel to frame
		container.add(checkBox);
		// add JPanel to frame
		container.add(infoBox);
		container.add(textBox);
		// add JPanel to frame
		container.add(buttonBox);

	}


}