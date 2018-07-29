package Exercise12_013;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EnhancedTemperatureConversion
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
	private final JTextField fahrenheitTemp;
	private final JTextField celsiusTemp;
	private final JTextField kelvinTemp;
	private final JLabel fahrenheit;
	private final JLabel celsius;
	private final JLabel kelvin;

	TemperatureFrame()
	{
		super("Temperature convertor");
		setLayout(new FlowLayout());

		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(3, 1 , 2, 7));

		fahrenheit = new JLabel("F:");
		infoPanel.add(fahrenheit);

		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(3, 1 , 2, 2));

		fahrenheitTemp = new JTextField(15);
		fahrenheitTemp.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent event)
					{
						String input = "";
						if(event.getSource() == fahrenheitTemp)
							input = String.format("%s", event.getActionCommand());

						try
						{
							double fahrenheit = Double.parseDouble(input);
							celsiusTemp.setText(String.format("%.2f", (fahrenheit - 32) * 5 / 9));
							kelvinTemp.setText(String.format("%.2f", ((fahrenheit - 32) * 5 / 9) + 273.15));
						}

						catch(Exception exception)
						{
							fahrenheitTemp.setText("Invalid input");
						}
					}

				});
		inputPanel.add(fahrenheitTemp);

		celsius = new JLabel("C:");
		infoPanel.add(celsius);

		celsiusTemp = new JTextField(15);
		celsiusTemp.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent event)
					{
						String input = "";
						if(event.getSource() == celsiusTemp)
							input = String.format("%s", event.getActionCommand());

						try
						{
							double celsius = Double.parseDouble(input);
							fahrenheitTemp.setText(String.format("%.2f", (celsius + 32) / 5 * 9));
							kelvinTemp.setText(String.format("%.2f", (celsius + 273.15)));
						}

						catch(Exception exception)
						{
							celsiusTemp.setText("Invalid input");
						}
					}

				});
		inputPanel.add(celsiusTemp);

		kelvin = new JLabel("K:");
		infoPanel.add(kelvin);

		kelvinTemp = new JTextField(15);
		kelvinTemp.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent event)
					{
						String input = "";
						if(event.getSource() == kelvinTemp)
							input = String.format("%s", event.getActionCommand());

						try
						{
							double kelvin = Double.parseDouble(input);
							fahrenheitTemp.setText(String.format("%.2f", (kelvin - 273.15 + 32) / 5 * 9));
							celsiusTemp.setText(String.format("%.2f", (kelvin - 273.15)));

						}

						catch(Exception exception)
						{
							kelvinTemp.setText("Invalid input");
						}
					}

				});
		inputPanel.add(kelvinTemp);

		add(infoPanel);
		add(inputPanel);

	}


}