package Exercise15_04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class FileMatch 
{
	private Scanner oldMaster;
	private Scanner transactions;
	private Formatter newMaster;
	private Formatter logFile;
		
	public FileMatch()
	{
	}
		
	public void openFiles()
	{
	
		try
		{
			oldMaster = new Scanner(new FileInputStream("src/Exercise15_04/oldMast.txt"));
			transactions = new Scanner(new FileInputStream("src/Exercise15_04/trans.txt"));
			newMaster = new Formatter("src/Exercise15_04/EOM/newMast.txt");
			logFile = new Formatter("src/Exercise15_04/EOM/log.txt");
		}
		
		catch(SecurityException sercurityException)
		{
			System.err.println("Write permision denied.");
			System.exit(1);
		}
		
		catch(FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening file. Terminating");
			System.err.println(fileNotFoundException.getLocalizedMessage());
			System.exit(1);
		}
	}
	
	public void processFiles()
	{
		Account account;
		TransactionRecord transaction;
		
		account = readAccount();
		transaction = readTransaction();
				
		while (account != null || transaction != null)
		{
			if(account != null && transaction != null)
			{
				if(account.getAccount() < transaction.getAccount())
				{
					newMaster.format("%d %s %s %.2f%n",
							account.getAccount(), account.getFirstName(), account.getLastName(), account.getBalance());
					account = readAccount();
				} 
				
				else if(account.getAccount() == transaction.getAccount())
				{
							
						while (transaction != null && (account.getAccount() == transaction.getAccount()))
						{
							account.setBalance(account.getBalance() + transaction.getTransaction());	
							transaction = readTransaction();
						}
					
										
					newMaster.format("%d %s %s %.2f%n",
							account.getAccount(), account.getFirstName(), account.getLastName(), account.getBalance());
					account = readAccount();
				}
				
				else if(account.getAccount() > transaction.getAccount())
				{
					logFile.format("Unmatched transaction record for account number: %d.%n", transaction.getAccount());
					transaction = readTransaction();
				}
			} 
			
			if(account != null && transaction == null)
			{
				newMaster.format("%d %s %s %.2f%n",
						account.getAccount(), account.getFirstName(), account.getLastName(), account.getBalance());
				account = readAccount();
			}
			
			if(account == null && transaction != null)
			{
				logFile.format("Unmatched transaction record for account number: %d.%n", transaction.getAccount());
				transaction = readTransaction();
			}
							
		}
	}
	
	
	public void closeFiles()
	{
		if(oldMaster != null)
			oldMaster.close();
		
		if(transactions != null)
			transactions.close();
		
		if(newMaster != null)
			newMaster.close();
		
		if(logFile != null)
			logFile.close();
	}
		
	public Account readAccount()
	{
		Account account;
		
		if(oldMaster.hasNext())
		{
			account = new Account(oldMaster.nextInt(), oldMaster.next(), oldMaster.next(), oldMaster.nextDouble());
		}
		else account = null;
		
		return account;
	}
	
	public TransactionRecord readTransaction()
	{
		TransactionRecord transaction;
		
		if(transactions.hasNext())
			transaction = new TransactionRecord(transactions.nextInt(), transactions.nextDouble());
		else
			transaction = null;
		
		return transaction;
		
	}

}
