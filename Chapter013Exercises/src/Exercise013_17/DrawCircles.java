package Exercise013_17;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class DrawCircles
{

	public static void main(String[] args)
	{
		CircleApp app = new CircleApp();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(600, 600);
		app.setVisible(true);

	}
}

class CircleApp extends JFrame
{
	CircleCanvas canvas;
	JLabel infoLabel, radiusLabel, xCenterCoordLabel, yCenterCoordLabel, outputLabel;
	JTextField radiusInput, xCenterCoordInput, yCenterCoordInput;
	JButton applyButton;

	double radius, xCenterCoord, yCenterCoord;

	CircleApp()
	{
		super("Drawing Circles");
		setLayout(new BorderLayout());

		radius = 0;
		xCenterCoord = 0;
		yCenterCoord = 0;

		canvas = new CircleCanvas();

		JPanel infoArea = new JPanel();
			infoArea.setLayout(new BorderLayout());

			infoLabel = new JLabel("Please input de radius of the circle and, if desired, the location of the center point");
			infoArea.add(infoLabel, BorderLayout.NORTH);

			// here because default state is disabled, will be enabled later in the program flow if conditions met
			applyButton = new JButton("Apply");
			applyButton.setEnabled(false);
			applyButton.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent event)
						{
							
							canvas.repaint(radius, radius + xCenterCoord, radius + yCenterCoord);
						}});


			Box inputArea = Box.createHorizontalBox();
				radiusLabel = new JLabel("Radius: ");
				inputArea.add(radiusLabel);
				

				radiusInput = new JTextField(5);
				radiusInput.getDocument().addDocumentListener(new DocumentListener() {
					  public void changedUpdate(DocumentEvent e) {
						    changed();
						  }
						  public void removeUpdate(DocumentEvent e) {
						    changed();
						  }
						  public void insertUpdate(DocumentEvent e) {
						    changed();
						  }

						  public void changed() {
						     if (!radiusInput.getText().equals(""))
						     {
						    	 applyButton.setEnabled(false);
						    	 try
									{
										radius = Double.parseDouble(radiusInput.getText());
										applyButton.setEnabled(true);
										infoLabel.setText("Please input de radius of the circle and, if desired, the location of the center point");
									}

									catch(IllegalArgumentException argumentException)
									{
										infoLabel.setText("Invalid entry in Radius input box!");
									}
						     }

						  }
						});
				inputArea.add(radiusInput);

				xCenterCoordLabel = new JLabel("Center X Coord Offset: ");
				inputArea.add(xCenterCoordLabel);

				xCenterCoordInput = new JTextField(5);
				inputArea.add(xCenterCoordInput);
				xCenterCoordInput.getDocument().addDocumentListener(new DocumentListener() {
					  public void changedUpdate(DocumentEvent e) {
						    changed();
						  }
						  public void removeUpdate(DocumentEvent e) {
						    changed();
						  }
						  public void insertUpdate(DocumentEvent e) {
						    changed();
						  }

						  public void changed() {
						     if (xCenterCoordInput.getText().length() > 0)
						     {
								applyButton.setEnabled(false);
						    	 try
									{
						    		 xCenterCoord = Double.parseDouble(xCenterCoordInput.getText());
						    		 applyButton.setEnabled(true);
						    		 infoLabel.setText("Please input de radius of the circle and, if desired, the location of the center point");
										
									}

									catch(IllegalArgumentException argumentException)
									{
										infoLabel.setText("Invalid entry in Center X Coord input box!");
									}
						     }

						  }
						});

				yCenterCoordLabel = new JLabel("Center Y Coord Offset: ");
				inputArea.add(yCenterCoordLabel);

				yCenterCoordInput = new JTextField(5);
				inputArea.add(yCenterCoordInput);
				yCenterCoordInput.getDocument().addDocumentListener(new DocumentListener() {
					  public void changedUpdate(DocumentEvent e) {
						    changed();
						  }
						  public void removeUpdate(DocumentEvent e) {
						    changed();
						  }
						  public void insertUpdate(DocumentEvent e) {
						    changed();
						  }

						  public void changed() {
						     if (yCenterCoordInput.getText().length() > 0)
						     {
						    	 applyButton.setEnabled(false);
						    	 try
									{
						    		 yCenterCoord = Double.parseDouble(yCenterCoordInput.getText());
						    		 applyButton.setEnabled(true);
						    		 infoLabel.setText("Please input de radius of the circle and, if desired, the location of the center point");
										
									}

									catch(IllegalArgumentException argumentException)
									{
										infoLabel.setText("Invalid entry in Center Y Coord input box!");
									}
						     }

						  }
						});
				inputArea.add(applyButton);

			infoArea.add(inputArea, BorderLayout.CENTER);
			infoArea.setBorder(BorderFactory.createRaisedSoftBevelBorder());

		add(infoArea, BorderLayout.NORTH);

		canvas = new CircleCanvas();
		canvas.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		add(canvas, BorderLayout.CENTER);
		outputLabel = canvas.getLabel();
		add(outputLabel, BorderLayout.SOUTH);
	}
}


class CircleCanvas extends JPanel
{
	double radius, xCoord, yCoord;
	JLabel outputLabel;

	CircleCanvas()
	{
		this(0.0, 0.0, 0.0);
	}

	CircleCanvas(double radius)
	{
		this(radius, radius, radius);
	}

	// constructor with arguments
	CircleCanvas(double radius, double centerXCoord, double centerYCoord)
	{
		setBackground(Color.WHITE);
		if(radius < 0 || centerXCoord < 0 || centerYCoord <0)
			throw new IllegalArgumentException();

		if(centerXCoord - radius < 0 || centerYCoord - radius < 0)
			throw new IllegalArgumentException();

		this.radius = radius;
		xCoord = centerXCoord - radius;
		yCoord = centerYCoord - radius;
		outputLabel = new JLabel("");

	}


	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(2.0f));
		g2d.draw(new Ellipse2D.Double(xCoord, yCoord, 2 * radius, 2 * radius));
		if (radius != 0.0)
			outputLabel.setText(String.format("Circle created at %.2f,%.2f, diamenter: %.2f, circumferince: %.2f, area: %.2f",
				xCoord + radius, yCoord + radius, 2 * radius, 2 * radius * Math.PI, radius * radius * Math.PI));

	}

	public void repaint(double radius)
	{
		repaint(radius, radius, radius);
	}

	public void repaint(double radius, double centerXCoord, double centerYCoord)
	{
		this.radius = radius;
		xCoord = centerXCoord - radius;
		yCoord = centerYCoord - radius;
		repaint();
	}

	public JLabel getLabel()
	{
		return outputLabel;
	}

}


