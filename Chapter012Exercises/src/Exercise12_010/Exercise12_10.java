package Exercise12_010;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Exercise12_10
{

	public static void main(String[] args)
	{
		ColorFrame frame = new ColorFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();

	}

}

class ColorFrame extends JFrame
{
	// array with color names
	private static final String[] colorNames = {"Black", "Blue", "Cyan", "Dark Gray", "Gray",
			"Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};
		
	private final JComboBox<String> colorJCombo; // list to display colors
	
	// GUI checkbox components	
	private final JCheckBox backGroundJCheckBox = new JCheckBox("Background");
	private final JCheckBox foreGroundJCheckBox = new JCheckBox("Foreground");
	
	// GUI button components
	private final JButton okJButton = new JButton("OK");
	private final JButton cancelJButton = new JButton("Cancel");
	
	private final JLabel offsetWest = new JLabel("             ");
	private final JLabel offsetEast = new JLabel("             ");

	ColorFrame()
	{
		super("ColorSelect"); // invoke constructor and set info
		
		JPanel contentPanel = new JPanel();
		Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		contentPanel.setBorder(padding);
		contentPanel.setLayout(new BorderLayout());
		
		// initialise JCombobox with info form colorNames array
		colorJCombo = new JComboBox<String>(colorNames);
		Dimension d = colorJCombo.getPreferredSize();
		colorJCombo.setPreferredSize(new Dimension(d.width + 210, d.height));
		contentPanel.add(colorJCombo, BorderLayout.NORTH); // add Jlist to box and initialise and add a ScrollBar
		
		JPanel secondPanel = new JPanel();
		secondPanel.setLayout(new BorderLayout());
		
		// create JPanels for layout purposes
		// JPanel for checkboxes
		JPanel checkBox = new JPanel();
		checkBox.setLayout(new GridLayout(0, 2, 3, 3)); // set layout to grid 0 per 2 with offset 3
		
		// add JCheckBoxes to JPanel
		checkBox.add(backGroundJCheckBox);
		checkBox.add(foreGroundJCheckBox);

		// add JPanel to box
		secondPanel.add(checkBox,BorderLayout.NORTH);

		// JPanel for JButtons
		JPanel buttonBox  = new JPanel();
		buttonBox.setLayout(new GridLayout (0, 2, 3, 3)); // set layout to grid 0 per 2 with offset 3
		// add JButtons to JPanel
		buttonBox.add(okJButton);
		buttonBox.add(cancelJButton);
		secondPanel.add(buttonBox, BorderLayout.CENTER);
		
		contentPanel.add(secondPanel, BorderLayout.CENTER);
	
		this.setContentPane(contentPanel);
		
	}


}