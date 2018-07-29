package Exercise17_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class LambdaExercise 
{
	
	public static void main (String[] args)
	{
		double[] values = {10.25, 11.25};
		
		Integer[] listInput = {1, 3, 4, 7, 9, 10}; 
		
		System.out.printf("Double product via full expresion lambda: %.2f.%n", Arrays.stream(values)
			.reduce(1, (double x, double y) -> {return x * y;}));
		System.out.printf("Double product via no parameter expresion lambda: %.2f.%n", Arrays.stream(values)
				.reduce(1, (x, y) -> {return x * y;}));
		System.out.printf("Double product via reduced expresion lambda: %.2f.%n", Arrays.stream(values)
				.reduce(1, (x, y) -> x * y));
			
		JButton button = new JButton();
		button.addActionListener(action ->
		{
			JOptionPane.showMessageDialog(null, "JButton event handler");
		});
					
	}

}
