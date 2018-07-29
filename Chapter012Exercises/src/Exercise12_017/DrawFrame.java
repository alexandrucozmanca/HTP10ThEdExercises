package Exercise12_017;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class DrawFrame extends JFrame
{
	private final JButton undoJButton;
	private final JButton clearJButton;
	private final String[] colorNames = {"Black", "Blue", "Cyan", "Dark Gray",
			"Gray", "Green", "Light Gray", "Magenta", "Orange",
			"Pink", "Red", "White", "Yellow"};

	private final Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY,
			Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
			Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};

	private final JComboBox<String> colorJCombo;

	private final String[] shapeNames = {"Line", "Oval", "Rectangle"};
	private final JComboBox<String> shapeJCombo;
	private final JCheckBox filledJCheck;
	private final DrawPanel drawPanel;
	private JLabel statusBar;

	public DrawFrame()
	{
		super("Java Drawings");

		ButtonHandler handler = new ButtonHandler();
		JPanel northPanel = new JPanel();
			northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			undoJButton = new JButton("Undo");
			undoJButton.addActionListener(handler);
			northPanel.add(undoJButton);

			clearJButton = new JButton("Clear");
			clearJButton.addActionListener(handler);
			northPanel.add(clearJButton);

			colorJCombo = new JComboBox<String>(colorNames);
			colorJCombo.addItemListener(new ItemListener()
					{
						@Override
						public void itemStateChanged(ItemEvent event)
						{
							drawPanel.setCurrentColor(colors[colorJCombo.getSelectedIndex()]);
						}
					});
			northPanel.add(colorJCombo);

			shapeJCombo = new JComboBox<String>(shapeNames);
			shapeJCombo.addItemListener(new ItemListener()
					{
						@Override
						public void itemStateChanged(ItemEvent event)
						{
							drawPanel.setShape(shapeJCombo.getSelectedIndex());
						}
					});
			northPanel.add(shapeJCombo);

			filledJCheck = new JCheckBox ("Filled", false);
			filledJCheck.addActionListener(handler);
			northPanel.add(filledJCheck);

		statusBar = new JLabel("Start drawing a shape.");

		drawPanel = new DrawPanel(statusBar);
		Border padding = BorderFactory.createLineBorder(this.getBackground(), 4);
		drawPanel.setBorder(padding);
		statusBar = drawPanel.getStatusLabel();

		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		pane.add(northPanel, BorderLayout.NORTH);
		pane.add(drawPanel, BorderLayout.CENTER);
		pane.add(statusBar, BorderLayout.SOUTH);
	}

	private class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent actionEvent)
		{

			JComponent component = (JComponent) actionEvent.getSource();

			if (component instanceof JButton)
			{
				JButton tempButton = (JButton) component;

				if (tempButton == undoJButton)
					drawPanel.clearLastShape();

				if (tempButton == clearJButton)
					drawPanel.clearDrawing();
			}

			if (component instanceof JCheckBox)
			{
				JCheckBox tempCheckBox = (JCheckBox) component;

				if (tempCheckBox.isSelected())
					drawPanel.setFilledShape(true);
				if (!tempCheckBox.isSelected())
					drawPanel.setFilledShape(false);
			}

		}
	}
}
