package Exercise15_06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

public class InfoDump 
{
	private static ObjectOutputStream output;
	
	public static void main (String[] args)
	{
		Account[] accounts = new Account[4];
		accounts[0] = new Account(100, "Alan", "Jones", 348.17);
		accounts[1] = new Account(300, "Mary", "Smith", 27.19);
		accounts[2] = new Account(500, "Sam", "Sharp", 0.00);
		accounts[3] = new Account(600, "Suzy", "Green", -14.22);
		
		TransactionRecord [] transactionRecords = new TransactionRecord[7];
		transactionRecords[0] = new TransactionRecord(100, 27.14);
		transactionRecords[1] = new TransactionRecord(100, 127.14);
		transactionRecords[2] = new TransactionRecord(100, 327.14);
		transactionRecords[3] = new TransactionRecord(300, 27.14);
		transactionRecords[4] = new TransactionRecord(300, 62.11);
		transactionRecords[5] = new TransactionRecord(400, 100.56);
		transactionRecords[6] = new TransactionRecord(900, 82.17);
	
		openFile("src/Exercise15_06/trans.ser");
		addRecords(transactionRecords);
		closeFile();
		
		openFile("src/Exercise15_06/oldmast.ser");
		addRecords(accounts);
		closeFile();
		
		
	}
	
	public static void openFile(String path) 
	{
		try
		{
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get(path)));
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
		catch(IOException ioException)
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
					output.writeObject(record[i]);
			}	
			catch (NoSuchElementException elementException)
			{
			}
			catch (IOException ioException)
			{
				System.err.println("Error writing to file. Terminating.");
				System.exit(1);
			}
		}
		
		if(object instanceof TransactionRecord[])
		{
			TransactionRecord[] record = (TransactionRecord[]) object;
			try
			{
				for (int i = 0; i < record.length; i ++)
					output.writeObject(record[i]);
			}
			catch (NoSuchElementException elementException)
			{
			}
			catch (IOException ioException)
			{
				System.err.println("Error writing to file. Terminating.");
				System.exit(1);
			}
		}
	}
	
	public static void closeFile()
	{
		try
		{ 
			if (output != null)
				output.close();
		}
		catch (IOException ioException)
		{
			System.err.println("Error closing file. Terminating");
		}
	}

}
