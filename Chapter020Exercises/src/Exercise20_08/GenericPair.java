package Exercise20_08;

public class GenericPair <F, S>
{
	private F firstElement;
	private S secondElement;

	public void setFirstElement(F firstElement)
	{
		this.firstElement = firstElement;
	}
	
	public void setSecondElement(S secondElement)
	{
		this.secondElement = secondElement;
	}
	
	public F getFirstElement()
	{
		return firstElement;
	}
	
	public S getSecondElement()
	{
		return secondElement;
	}
}
