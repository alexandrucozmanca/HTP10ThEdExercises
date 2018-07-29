package Exercise20_05;

public class InvalidSubscriptException extends RuntimeException  
{
	public InvalidSubscriptException()
	{
		this("Subscript out of bounds");
	}
	
	public InvalidSubscriptException(String message)
	{
		super(message);
	}
	
}
