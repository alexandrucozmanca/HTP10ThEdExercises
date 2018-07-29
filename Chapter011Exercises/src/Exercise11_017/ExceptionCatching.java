package Exercise11_017;

import java.io.IOException;

public class ExceptionCatching
{

	public static void main (String[] args)
	{
		try
		{
			throw new ExceptionA("Exception A");
		}

		catch (Exception e)
		{
			System.err.println(e.getLocalizedMessage());
		}

		try
		{
			throw new ExceptionB("Exception B");
		}

		catch (Exception e)
		{
			System.err.println(e.getLocalizedMessage());
		}

		try
		{
			throw new NullPointerException("Exception NullPointer");
		}

		catch (Exception e)
		{
			System.err.println(e.getLocalizedMessage());
		}

		try
		{
			throw new IOException("Exception IO");
		}

		catch (Exception e)
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
