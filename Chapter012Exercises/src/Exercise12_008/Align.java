package Exercise12_008;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Align extends JFrame
{

	private final JButton okJButton = new JButton("OK");
	private final JButton cancelJButton = new JButton("Cancel");
	private final JButton helpJButton = new JButton("Help");

	private final JTextField xField = new JTextField("8", 5);
	private final JTextField yField = new JTextField("8", 5);

	// JCheckBox GUI components
	private final JCheckBox snapJCheckBox = new JCheckBox("Snap to Grid");
	private final JCheckBox showJCheckBox = new JCheckBox("Show Grid");

	// JLabel GUI components
	private final JLabel xLabel = new JLabel("X:");
	private final JLabel yLabel = new JLabel("Y:");

	Align()
	{
		super("Align"); // set frame info

		// create 4 JPanels that will hold the required components
		// JPanel for checkboxes
		JPanel checkBox = new JPanel();
		checkBox.setLayout(new GridLayout(2, 1)); // set gridLayout
		// add checkboxes
		checkBox.add(snapJCheckBox);
		checkBox.add(showJCheckBox);


		// JPanel for labels
		JPanel upBox = new JPanel();
		upBox.setLayout(new FlowLayout());
		// add labels
		upBox.add(xLabel);
		upBox.add(xField);

		JPanel downBox = new JPanel();
		downBox.setLayout(new FlowLayout());
		// add labels
		downBox.add(yLabel);
		downBox.add(yField);

		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(new BorderLayout());
		fieldPanel.add(upBox, BorderLayout.NORTH);
		fieldPanel.add(downBox, BorderLayout.SOUTH);

		// JPanel for JButtons
		JPanel buttonBox  = new JPanel();
		buttonBox.setLayout(new GridLayout (3, 1, 10, 5));
		// add JButtons
		buttonBox.add(okJButton);
		buttonBox.add(cancelJButton);
		buttonBox.add(helpJButton);


		Container container = getContentPane();
		container.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		container.add(checkBox);
		container.add(fieldPanel);
		container.add(buttonBox);
		
		setSize(300, 125);
		setVisible(true);

	}

	public static void main(String[] args)
	{
		Align frame = new Align();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
