package Exercise12_010;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ColorSelect extends JFrame 
{
	// GUI button components
	private final JButton okJButton = new JButton("OK");
	private final JButton cancelJButton = new JButton("Cancel");
	
	// GUI checkbox components	
	private final JCheckBox backGroundJCheckBox = new JCheckBox("Background");
	private final JCheckBox foreGroundJCheckBox = new JCheckBox("Foreground");
	
	// array with color names
	private static final String[] colorNames = {"Black", "Blue", "Cyan", "Dark Gray", "Gray",
			"Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};
	private final JComboBox<String> colorJCombo; // list to display colors
	
	
	ColorSelect()
	{
		super("ColorSelect"); // invoke constructor and set info
		getContentPane().setLayout(new BorderLayout());
		colorJCombo = new JComboBox<String>(colorNames);
		getContentPane().add(colorJCombo, BorderLayout.NORTH);
		
		
		// JPanel for checkboxes
		JPanel checkBox = new JPanel();
		// add JCheckBoxes to JPanel
		checkBox.add(backGroundJCheckBox);
		checkBox.add(foreGroundJCheckBox);
		getContentPane().add(checkBox, BorderLayout.CENTER);
		
		
		JPanel buttonBox  = new JPanel();
		// add JButtons to JPanel
		buttonBox.add(okJButton);
		buttonBox.add(cancelJButton);
		getContentPane().add(buttonBox, BorderLayout.SOUTH);		
			
		setSize(300, 150);
		setVisible(true);
		
	}
	
	public static void main (String[] args)
	{
		ColorSelect frame = new ColorSelect();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
