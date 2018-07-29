package Exercise15_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TelephoneNumberTranslator 
{
	private static char[][] numberCorespondends = new char[][]{
		{'A', 'B', 'C'},
		{'D', 'E', 'F'},
		{'G', 'H', 'I'},
		{'J', 'K', 'L'},
		{'M', 'N', 'O'},
		{'P', 'R', 'S'},
		{'T', 'U', 'V'},
		{'W', 'X', 'Y'}};
									
	
		
	public static void buildWord(int number)
	{
		PrintStream writeToFile = null;
		try 
		{
			writeToFile = new PrintStream(new File("src/Exercise15_07/TelephoneToCharacters.txt"));
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String word = "";
		for (int no1 = 0; no1 < 3; no1++)
		{
			for (int no2 = 0; no2 < 3; no2++)
			{	
				for (int no3 = 0; no3 < 3; no3++)
				{
					for (int no4 = 0; no4 < 3; no4++)
					{
						for (int no5 = 0; no5 < 3; no5++)
						{
							for (int no6 = 0; no6 < 3; no6++)
							{
								for (int no7 = 0; no7 < 3; no7++)
								{
									word = String.format("%c%c%c%c%c%c%c" ,
											numberCorespondends[number/1000000  - 2][no1],
											numberCorespondends[(number%1000000)/100000 - 2][no2],
											numberCorespondends[(number%100000)/10000 - 2][no3],
											numberCorespondends[(number%10000)/1000 - 2][no4],
											numberCorespondends[(number%1000)/100 - 2][no5],
											numberCorespondends[(number%100)/10  - 2][no6],
											numberCorespondends[number%10 - 2][no7]);
									
									writeToFile.append(word + " ");
								}
								writeToFile.append("\n");
							}
						}
					}
				}
			}
			
			
			
		}	
	}
	
	
}
