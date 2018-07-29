package Exercise11_016;

public class ExeceptionSuperclass
{

	public static void main (String[] args)
	{

		ThrowsTest test = new ThrowsTest();
		
		try
		{
			test.throwExA();
		}
		
		catch (ExceptionA e)
		{
			System.err.println(e.getLocalizedMessage());
		}
		
		try
		{
			test.throwExB();
		}
		
		catch (ExceptionA e)
		{
			System.err.println(e.getLocalizedMessage());
		}
		
		try
		{
			test.throwExC();
		}
		
		catch (ExceptionA e)
		{
			System.err.println(e.getLocalizedMessage());
		}
		
	}

}


class ExceptionA extends IllegalArgumentException
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

class ExceptionC extends ExceptionB
{
	ExceptionC()
	{
		super("Default constructor message for Exception C");
	}

	ExceptionC(String string)
	{
		super(string);
	}

	ExceptionC(String string, IllegalArgumentException e)
	{
		super(string, e);
	}

	ExceptionC(IllegalArgumentException e)
	{
		super(e);
	}
}

class ThrowsTest
{

	public void throwExA()
	{
		throw new ExceptionA("Thrown in throwExA");
	}
	
	public void throwExB()
	{
		throw new ExceptionA("Thrown in throwExB");
	}
	
	public void throwExC()
	{
		throw new ExceptionA("Thrown in throwExC");
	}
}
