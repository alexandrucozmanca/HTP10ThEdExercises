package Exercise15_06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;


public class FileMatch 
{
	private ObjectInputStream oldMaster;
	private ObjectInputStream transactions;
	private ObjectOutputStream newSerialMaster;
	Formatter newMaster;
	Formatter logFile;
		
	public FileMatch()
	{
	}
		
	public void openFiles()
	{
	
		try
		{
			oldMaster = new ObjectInputStream(Files.newInputStream(Paths.get("src/Exercise15_06/oldMast.ser")));
			transactions = new ObjectInputStream(Files.newInputStream(Paths.get("src/Exercise15_06/trans.ser")));
			newSerialMaster = new ObjectOutputStream(Files.newOutputStream(Paths.get("src/Exercise15_06/EOM/newMast.ser")));
			newMaster = new Formatter("src/Exercise15_06/EOM/newMast.txt");
			logFile = new Formatter("src/Exercise15_06/EOM/log.txt");
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
		
		catch (IOException e) 
		{
			System.err.println("Error opening file. Terminating");
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
					try 
					{
						newSerialMaster.writeObject(account);
					}
					catch (IOException e) 
					{
						e.printStackTrace();
					}
					
					account = readAccount();
				} 
				
				else if(account.getAccount() == transaction.getAccount())
				{
					while (transaction != null && (account.getAccount() == transaction.getAccount()))
					{
						account.setBalance(account.getBalance() + transaction.getTransaction());	
						transaction = readTransaction();
					}
					
					try 
					{
						newSerialMaster.writeObject(account);
						newMaster.format("%d %s %s %.2f%n",
								account.getAccount(), account.getFirstName(), account.getLastName(), account.getBalance());
						account = readAccount();
					}
					catch (IOException e) 
					{
						e.printStackTrace();
					}
					
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
			try
			{
				oldMaster.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		
		if(transactions != null)
			try
			{
				transactions.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		
		if (newSerialMaster != null)
			try
			{
				newSerialMaster.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		
		if(newMaster != null)
			newMaster.close();
		
		if(logFile != null)
			logFile.close();
	}
		
	public Account readAccount()
	{
		Account account = null;
		try 
		{
			account = (Account) oldMaster.readObject();
		}
		catch (ClassNotFoundException | IOException e) 
		{
		}
		
		return account;
	}
	
	public TransactionRecord readTransaction()
	{
		TransactionRecord transaction = null;
		
		try
		{
			transaction = (TransactionRecord) transactions.readObject();
		}
		
		catch (ClassNotFoundException | IOException e) 
		{
		}
		
		return transaction;
		
	}

	public void readNewMast()
	{
		Account readAccount = null;
		
		try 
		{
			ObjectInputStream newMaster = new ObjectInputStream(Files.newInputStream(Paths.get("src/Exercise15_06/EOM/newMast.ser")));
			
			do
			{
				try 
				{
					readAccount = (Account) newMaster.readObject();
					if (readAccount != null)
					System.out.printf("%d %s %s %.2f%n",
						readAccount.getAccount(), readAccount.getFirstName(), readAccount.getLastName(), readAccount.getBalance());
				}
				catch (ClassNotFoundException | IOException e) 
				{
				readAccount = null;
				}
			} while (readAccount != null);
			
			if (newMaster != null)
				newMaster.close();
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
}
