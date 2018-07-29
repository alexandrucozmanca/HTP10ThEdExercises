package Exercise11_018;


public class ExceptionBlockOrderTest 
{
	
	public static void main (String[] args)
	{
		
		try
		{
			throw new ExceptionB("Exception B");
		}
		
		catch (ExceptionA e)
		{
			System.err.println(e.getLocalizedMessage());			
		}
		catch (ExceptionB e)
		{
			System.err.println(e.getLocalizedMessage());
		}
		
	}

}


class ExceptionA extends Exception
{
	ExceptionA()
	{
		super("Default constructor message for Exception A");
	}

	ExceptionA(String string)
	{
		super(string);
	}

	ExceptionA(String string, IllegalArgumentException e)
	{
		super(string, e);
	}

	ExceptionA(IllegalArgumentException e)
	{
		super(e);
	}
}

class ExceptionB extends ExceptionA
{
	ExceptionB()
	{
		super("Default constructor message for Exception B");
	}

	ExceptionB(String string)
	{
		super(string);
	}

	ExceptionB(String string, IllegalArgumentException e)
	{
		super(string, e);
	}

	ExceptionB(IllegalArgumentException e)
	{
		super(e);
	}
}
