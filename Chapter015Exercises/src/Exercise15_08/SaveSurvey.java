package Exercise15_08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class SaveSurvey 
{
	private String rawDataPath;
	private String outputPath;
	
	private static Formatter surveyWriter;
	private static Scanner dataReader;
	
	public SaveSurvey(String rawDataPath, String outputPath)
	{
		this.rawDataPath = rawDataPath;
		this.outputPath = outputPath;
	}

	
	// accesor methods
	// accesor for rawDataPath
	public String getRawDataPath()
	{
		return rawDataPath;
	}
	
	// accesor for outputPath
	public String getOutputPath()
	{
		return outputPath;
	}
	
	// mutator methods
	// mutator for rawDataPath
	public void setRawDataPath(String rawDataPath)
	{
		this.rawDataPath = rawDataPath;
	}
	
	// mutator for outputPath
	public void setOutputPath(String outputPath)
	{
		this.outputPath = outputPath;
	}

	
	public void openFiles()
	{
		dataReader = null;
		surveyWriter = null;
		
		try
		{
			dataReader = new Scanner(new FileInputStream(rawDataPath));
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening file. Terminating");
			System.err.println(fileNotFoundException.getLocalizedMessage());
			System.exit(1);
		}
		
		try
		{
			surveyWriter = new Formatter(outputPath);
		}
		catch (FileNotFoundException fileNotFoundException) 
		{
			System.err.println("Error opening file. Terminating");
			System.err.println(fileNotFoundException.getLocalizedMessage());
			System.exit(1);
		}
	}
	
	public void saveSurvey()
	{
		int[] surveyResult = new int[5];
		
		if(dataReader.hasNext())
			do
			{
				surveyResult[dataReader.nextInt() - 1]++;
			} while(dataReader.hasNext());
		else
		{
			throw new IllegalArgumentException("Raw data file contains no valid information");
		}
		
		surveyWriter.format("Survey results:%n");
		int totalValues = 0;
		
		for(int i = 0; i< surveyResult.length; i++)
			totalValues += surveyResult[i];
		
		for(int i = 0; i< surveyResult.length; i++)
		{
			String visualResult = "";
			for (int j = 0; j < surveyResult[i]; j++)
				visualResult += "[]";
			surveyWriter.format("Quality %d: %s%n", i + 1, visualResult);
		}
	}
	
	public void closeFiles()
	{
		if (dataReader != null)
			dataReader.close();
		
		if(surveyWriter != null)
			surveyWriter.close();
	}
	
}
