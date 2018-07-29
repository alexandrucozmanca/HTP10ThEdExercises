package Exercise15_08;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SaveRawData 
{
	
	private String outputPath;
	static private Formatter fileSaver;
	
	public SaveRawData(String outputPath)
	{
		this.outputPath = outputPath;
		fileSaver = null;
	}
	
	// accesor methods
	// accesor for outputPath
	public String getOutputPath()
	{
		return outputPath;
	}
	
	// mutator methods
	// mutator for outputPath
	public void setOutputPath(String outputPath)
	{
		this.outputPath = outputPath;
	}

	public void openFile()
	{
		try 
		{
			fileSaver = new Formatter(outputPath);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// method to save survey results to file with input from keyboard
	public void saveRawData()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please input survey answer (1 - low quality, 5 - high quality) or EOF character to stop survey:");
		
				
		do 
		{
			if (keyboard.hasNext())			
				try
				{
					int temp = keyboard.nextInt();
					if (temp < 1 || temp > 5)
						throw new IllegalArgumentException("Answer is out of range. Try again.");
					else
						fileSaver.format("%d%n",temp);
					System.out.println("?");
				}
				catch (InputMismatchException inputMismatchException)
				{
					System.out.println("Please enter only valid digits");
				}
				catch (IllegalArgumentException illegalArgumentException)
				{
					System.out.println(illegalArgumentException.getLocalizedMessage());
				}
			else
			{
				keyboard.close();
				System.exit(0);
			}
		} while (keyboard.hasNext());
		
		
		keyboard.close();
						
	}
	

	public void closeFile()
	{
		if (fileSaver != null)
			fileSaver.close();
	}
}
