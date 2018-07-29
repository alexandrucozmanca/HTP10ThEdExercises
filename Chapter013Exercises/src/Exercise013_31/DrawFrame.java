package Exercise013_31;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DrawFrame extends JFrame
{
	private final JButton undoJButton;
	private final JButton clearJButton;
	private final JButton firstColor;
	private final JButton secondColor;
	private final String[] shapeNames = {"Line", "Oval", "Rectangle"};
	private final JComboBox<String> shapeJCombo;
	private final JCheckBox filledJCheck;
	private final JCheckBox gradient;
	private final JCheckBox isDashed;
	private final DrawPanel drawPanel;
	private JLabel statusBar, dash;
	private final JTextField widthInput;
	private final JTextField dashInput;
	private Color color1, color2;
	private Paint paint;
	private float strokeWidth;
	private float[] dashes;


	public DrawFrame()
	{
		super("Java Drawings");
		strokeWidth = 1;
		dashes = new float[1];

		ButtonHandler handler = new ButtonHandler();
		JPanel northPanel = new JPanel();
			northPanel.setLayout(new BorderLayout());
				JPanel upperNorthPanel = new JPanel();
					upperNorthPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
					undoJButton = new JButton("Undo");
					undoJButton.addActionListener(handler);
					upperNorthPanel.add(undoJButton);

					clearJButton = new JButton("Clear");
					clearJButton.addActionListener(handler);
					upperNorthPanel.add(clearJButton);

					shapeJCombo = new JComboBox<String>(shapeNames);
					shapeJCombo.addItemListener(new ItemListener()
							{
								@Override
								public void itemStateChanged(ItemEvent event)
								{
									drawPanel.setShape(shapeJCombo.getSelectedIndex());

								}
							});
					upperNorthPanel.add(shapeJCombo);

					filledJCheck = new JCheckBox ("Filled", false);
					filledJCheck.addActionListener(handler);
					upperNorthPanel.add(filledJCheck);

				JPanel lowerNorthPanel = new JPanel();
					lowerNorthPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

					gradient = new JCheckBox("Use Gradient");
					gradient.setEnabled(false);
					gradient.addActionListener(handler);
					lowerNorthPanel.add(gradient);

					firstColor = new JButton("1st Color");
					firstColor.addActionListener(handler);
					lowerNorthPanel.add(firstColor);


					secondColor = new JButton("2nd Color");
					secondColor.setEnabled(false);
					secondColor.addActionListener(handler);
					lowerNorthPanel.add(secondColor);

					JLabel width = new JLabel("Line width: ");
					lowerNorthPanel.add(width);

					widthInput = new JTextField(3);
					widthInput.getDocument().addDocumentListener(new DocumentListener() {
						  public void changedUpdate(DocumentEvent e)
						  {
							    changed();
							  }
							  public void removeUpdate(DocumentEvent e) {
							    changed();
							  }
							  public void insertUpdate(DocumentEvent e) {
							    changed();
							  }

							  public void changed()
							  {
								  try
								  {
									  strokeWidth = Float.parseFloat(widthInput.getText());
									  drawPanel.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
									  dashInput.setEnabled(true);
									  dash.setEnabled(true);
								  }

								  catch(IllegalArgumentException e)
								  {
									  statusBar.setText("Invalid entry in Line width field");
								  }

								  if (widthInput.getText().length() == 0)
								  {
									  dashInput.setEnabled(false);
									  drawPanel.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
								  }
							   }

							});

					lowerNorthPanel.add(widthInput);

					dash = new JLabel ("Dash ");
					dash.setEnabled(false);
					lowerNorthPanel.add(dash);

					dashInput = new JTextField(3);
					dashInput.getDocument().addDocumentListener(new DocumentListener() {
						  public void changedUpdate(DocumentEvent e)
						  {
							    changed();
							  }
							  public void removeUpdate(DocumentEvent e) {
							    changed();
							  }
							  public void insertUpdate(DocumentEvent e) {
							    changed();
							  }

							  public void changed()
							  {
								  try
								  {
									  dashes[0] = Float.parseFloat(dashInput.getText());
									   isDashed.setEnabled(true);
								  }

								  catch(IllegalArgumentException e)
								  {
									  statusBar.setText("Invalid entry in Dash length width field");
								  }

								  if (dashInput.getText().length() == 0)
								  {
									  isDashed.setEnabled(false);
									  isDashed.setSelected(false);
									  drawPanel.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
								  }
							   }

							});

					dashInput.setEnabled(false);
					lowerNorthPanel.add(dashInput);

					isDashed = new JCheckBox("Dashed");
					isDashed.setEnabled(false);
					isDashed.addActionListener(handler);
					lowerNorthPanel.add(isDashed);

			northPanel.add(upperNorthPanel, BorderLayout.NORTH);
			northPanel.add(lowerNorthPanel, BorderLayout.SOUTH);
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

				if(tempButton == firstColor)
				{
					color1 = JColorChooser.showDialog(DrawFrame.this, "Choose a color!", color1);

					if (color1 == null)
						color1 = Color.BLACK;

					if (gradient.isSelected())
						paint = new GradientPaint(0, 0, color1, 50, 50, color2, true);
					else
						paint = (Paint) color1;

					drawPanel.setCurrentColor(paint);
					secondColor.setEnabled(true);
					firstColor.setBackground(color1);

				}

				if(tempButton == secondColor)
				{
					color2 = JColorChooser.showDialog(DrawFrame.this, "Choose a color!", color1);
					if (color2 == null)
						color2 = Color.BLACK;
					if(gradient.isSelected())
					{
						paint = new GradientPaint(0, 0, color1, 50, 50, color2, true);
						drawPanel.setCurrentColor(paint);
					}

					gradient.setEnabled(true);
					secondColor.setBackground(color2);
				}
			}

			if (component instanceof JCheckBox)
			{
				JCheckBox tempCheckBox = (JCheckBox) component;

				if(tempCheckBox == filledJCheck)
				{
					if (tempCheckBox.isSelected())
						drawPanel.setFilledShape(true);
					if (!tempCheckBox.isSelected())
						drawPanel.setFilledShape(false);
				}

				if(tempCheckBox == gradient)
				{
					if (tempCheckBox.isSelected())
					{
						paint = new GradientPaint(0, 0, color1, 50, 50, color2, true);
						drawPanel.setCurrentColor(paint);
					}
					if (!tempCheckBox.isSelected())
					{
						paint = (Paint) color2;
						drawPanel.setCurrentColor(paint);
					}


				}

				if(tempCheckBox == isDashed)
				{
					if(tempCheckBox.isSelected())
						drawPanel.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
								  10, dashes, 0));
					if(!tempCheckBox.isSelected())
						drawPanel.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
				}
			}

		}
	}
}
