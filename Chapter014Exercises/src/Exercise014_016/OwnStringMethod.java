package Exercise014_016;

public class OwnStringMethod
{
	public static void main(String[] args)
	{
		MyString letters = new MyString("abcdefghijklmabcdefghijklm");

		// test indexOf to locate a character in a string
		System.out.printf(
		"'c' is located at index %d%n", letters.indexOf('c'));
		System.out.printf(
		"'a' is located at index %d%n", letters.indexOf('a', 1));
		System.out.printf(
		"'$' is located at index %d%n%n", letters.indexOf('&'));

		System.out.printf("Last 'c' is located at index %d%n",
		letters.lastIndexOf('c'));
		System.out.printf("Last 'a' is located at index %d%n",
		letters.lastIndexOf('a', 25));
		System.out.printf("Last '$' is located at index %d%n%n",
		letters.lastIndexOf('$'));
	}


}

class MyString
{
	private String string;

	MyString()
	{
		this(null);
	}

	MyString(String string)
	{
		this.string = string;
	}

	public int indexOf(char c)
	{
		int result = -1;

		for(int i = 0; i < string.length(); i++)
		{
			if(string.charAt(i) == c)
				result = i;
			if(result > -1)
				break;
		}


		return result;
	}


	public int indexOf(char c, int index)
	{
		int result = -1;

		if(!(index >= string.length()))
			for(int i = index; i < string.length(); i++)
			{
				if(string.charAt(i) == c)
					result = i;
				if(result > -1)
					break;
			}


		return result;
	}

	public int lastIndexOf(char c)
	{
		int result = -1;

		for(int i = string.length() - 1 ; i >= 0 ; i--)
		{
			if(string.charAt(i) == c)
				result = i;
			if(result > -1)
				break;
		}


		return result;
	}


	public int lastIndexOf(char c, int index)
	{
		int result = -1;

		if(!(index >= string.length()))
		{
			for(int i = index ; i >= 0 ; i--)
			{
				if(string.charAt(i) == c)
					result = i;
				if(result > -1)
					break;
			}
		}

		return result;
	}
}
