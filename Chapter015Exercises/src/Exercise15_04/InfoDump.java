package Exercise15_04;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;

public class InfoDump 
{
	private static Formatter output;
	
	public static void main (String[] args)
	{
		Account[] accounts = new Account[4];
		accounts[0] = new Account(100, "Alan", "Jones", 348.17);
		accounts[1] = new Account(300, "Mary", "Smith", 27.19);
		accounts[2] = new Account(500, "Sam", "Sharp", 0.00);
		accounts[3] = new Account(600, "Suzy", "Green", -14.22);
		
		TransactionRecord [] transactionRecords = new TransactionRecord[4];
		transactionRecords[0] = new TransactionRecord(100, 27.14);
		transactionRecords[1] = new TransactionRecord(300, 62.11);
		transactionRecords[2] = new TransactionRecord(400, 100.56);
		transactionRecords[3] = new TransactionRecord(900, 82.17);
	
		openFile("src/Exercise15_04/trans.txt");
		addRecords(transactionRecords);
		closeFile();
		
		openFile("src/Exercise15_04/oldmast.txt");
		addRecords(accounts);
		closeFile();
		
		
	}
	
	public static void openFile(String path)
	{
		try
		{
			output = new Formatter(path);
		}
		catch(SecurityException sercurityException)
		{
			System.err.println("Write permision denied.");
			System.exit(1);
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening file. Terminating");
			System.exit(1);
		}
	}
	
	public static void addRecords(Object object)
	{
		if(object instanceof Account[])
		{
			
			Account[] record = (Account[]) object;
			try
			{
						
				for (int i = 0; i < record.length; i ++)
				{
					output.format("%d %s %s %.2f%n",
						record[i].getAccount(), record[i].getFirstName(), record[i].getLastName(), record[i].getBalance());
				}
			}
			catch(FormatterClosedException formatterClosedException)
			{
				System.err.println("Error writing to file. Terminating");
				System.exit(1);
			}
		}
		
		if(object instanceof TransactionRecord[])
		{
			TransactionRecord[] record = (TransactionRecord[]) object;
			try
			{
				for (int i = 0; i < record.length; i ++)
				{
					output.format("%d %.2f%n",
						record[i].getAccount(), record[i].getTransaction());
				}
			}
			catch(FormatterClosedException formatterClosedException)
			{
				System.err.println("Error writing to file. Terminating");
				System.exit(1);
			}
		}
	}
	
	public static void closeFile()
	{
		if (output != null)
			output.close();
	}
	

}
