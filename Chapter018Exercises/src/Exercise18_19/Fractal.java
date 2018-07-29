package Exercise18_19;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fractal extends JFrame 
{
	private static final int WIDTH = 400;
	private static final int HEIGHT = 480;
	private static final int MIN_LEVEL = 0;
	private static final int MAX_LEVEL = 15;
	
	// set up GUI
	public Fractal()
	{
		super("Fractal");
		
		// set up levelJLabel to add to controlJPanel
		final JLabel levelJLabel = new JLabel("Level: 0");
		
		final FractalJPanel drawSpace = new FractalJPanel(0);
		 
		// set up control panel
		final JPanel controlJPanel = new JPanel();
		controlJPanel.setLayout(new FlowLayout());
		
		final JButton changeColorJButton = new JButton("Color");
		controlJPanel.add(changeColorJButton);
		changeColorJButton.addActionListener(
				new ActionListener() // anonymous inner class
				{
					// process changeColorJButton event
					@Override
					public void actionPerformed(ActionEvent event)
					{
						Color color = JColorChooser.showDialog(Fractal.this, "Choose a color", Color.blue);
						
						// set default color, if no color is returned
						if (color == null)
							color = Color.BLUE;
						
						drawSpace.setColor(color);
						
					}
				} // end anonymous inner class
			); // end addActionListener
		
		
		// set up decrease level button to add control panel and register listener
		final JButton decreaseLevelJButton = new JButton("Decrease Level");
		controlJPanel.add(decreaseLevelJButton);
		decreaseLevelJButton.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent event)
					{
						int level = drawSpace.getLevel();
						level --;
						
						// modifi level if possible
						if (level >= MIN_LEVEL && level <= MAX_LEVEL)
						{
							levelJLabel.setText("Level: " + level);
							drawSpace.setLevel(level);
							repaint();
						}
					}
				} // end anonymous inner class 
			); // end addActionListener
		
		// setup increase level button
		final JButton increaseLevelJButton = new JButton("Increase Level");
		controlJPanel.add(increaseLevelJButton);
		increaseLevelJButton.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent event)
					{
						int level = drawSpace.getLevel();
						level ++;
						
						// modifi level if possible
						if (level >= MIN_LEVEL && level <= MAX_LEVEL)
						{
							levelJLabel.setText("Level: " + level);
							drawSpace.setLevel(level);
							repaint();
						}
					}
				} // end anonymous inner class 
			); // end addActionListener
		
		controlJPanel.add(levelJLabel);
		
		// create main JPanel to contain controlJPanel and drawspace
		final JPanel mainJPanel = new JPanel();
		mainJPanel.add(controlJPanel);
		mainJPanel.add(drawSpace);
		
		add(mainJPanel);
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	} // end constructor
	
	public static void main(String[] args)
	{
		Fractal demo = new Fractal();
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
