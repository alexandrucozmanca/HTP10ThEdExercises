/* Use a one-dimensional array to solve the following problem:
Write an application that inputs five numbers, each between 10 and 100, inclusive. As each number
is read, display it only if it’s not a duplicate of a number already read. Provide for the “worst case,”
in which all five numbers are different. Use the smallest possible array to solve this problem. Display
the complete set of unique values input after the user enters each new value.
*/

import javax.swing.JOptionPane;

public class DuplicateElimination 
{

	public static void main(String[] args) 
	{
		// local variables
		int counter = 1, currentNumber = 0;
		int [] numbers = new int[5]; // array for storage 
		int location = 0; // location variable
		
		
		//user info
		JOptionPane.showMessageDialog(null, "Please input 5 numbers between 10 and 100.\n"
				+ "The program will read and output de number\n"
				+ "only if it has not been previously read.");
		
		
		// run loop 5 times
		while (counter <= 5)
		{
			// initialize output string for user info 
			String output = "Current numbers are after " + counter + " input(s) are :\n"; 
			boolean isNew = true; // assume number is new
			
			do  // request user input and test for validity
			{
				String input = JOptionPane.showInputDialog("Input number:");
			
				try
				{
					// transform input in usable int value
					currentNumber = Integer.parseInt(input);
				}
				
				catch (NumberFormatException e)
				{
					// in case of non-int. value reset input to a non-valid sentinel condition 
					System.out.println(e);
					currentNumber = 0;
				}
				
				// user info in case of non-valid user input
				if (currentNumber < 10  || currentNumber > 100)
					JOptionPane.showMessageDialog(null,"Invalid range.");
				
			} while (currentNumber < 10  || currentNumber > 100); // validity range
			
			// compare array in with last input value  
			for (int i = 0 ; i <= location; i ++)		
				if (currentNumber == numbers[i])
					isNew = false; // if number already exists 
			
			// user info if number already exists
			if(!isNew) JOptionPane.showMessageDialog(null, currentNumber + " is duplicate!");
			
			// if no. is new
			if(isNew) 
				{
				numbers[location] = currentNumber; //add to array
				location++; // increase step in array
				}
			
			
			// output array after each valid entry
			for (int i = 0; i < location; i ++)
					output += String.format("%d ",numbers[i]);
			JOptionPane.showMessageDialog(null,output);
			
			// increase sentinel
			counter ++;
			
		}

	}

}
