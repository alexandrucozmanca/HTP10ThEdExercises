package Exercise12_012;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TemperatureConversion 
{
	public static void main(String[] args)
	{
		TemperatureFrame frame = new TemperatureFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
	}
		
	
}

class TemperatureFrame extends JFrame
{
	private final JTextField kelvinTemp; 
	private final JLabel celsiusTemp;
	private final JLabel kelvinInfo;
	
	TemperatureFrame()
	{
		super("Temperature convertor");
		setLayout(new FlowLayout());
		
		kelvinInfo = new JLabel("F:");
		add(kelvinInfo);
		
		kelvinTemp = new JTextField(15);
		kelvinTemp.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent event)
					{
						String input = "";
						if(event.getSource() == kelvinTemp)
							{
							input = String.format("%s", event.getActionCommand());
							celsiusTemp.setText("");
							}
						
						
						try
						{
							double fahrenheit = Double.parseDouble(input);
							celsiusTemp.setText(String.format("Celsius: %.2f", (fahrenheit - 32) * 5 / 9));
						}
						
						catch(Exception exception)
						{
							kelvinTemp.setText("Invalid input");
						}
					}
					
				});
		add(kelvinTemp);
				
		celsiusTemp = new JLabel("Celsius: ");
		Dimension d = celsiusTemp.getPreferredSize();
		celsiusTemp.setPreferredSize(new Dimension (d.width + 130, d.height));
		add(celsiusTemp);
		
	}
	
	
}