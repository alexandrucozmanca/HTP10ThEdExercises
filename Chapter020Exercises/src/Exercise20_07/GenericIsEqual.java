package Exercise20_07;

public class GenericIsEqual 
{
	public static <T extends Comparable<T>> boolean isEqualTo(T first, T second)
	{
		if (first.compareTo(second) == 0)
			return true;
		
		return false;
	}
	
	public static void main (String[] args)
	{
		Integer firstInteger = 1;
		Integer secondInteger = 2;
		Integer thirdInteger = 1;
		
		System.out.printf("%d %s equal to %d%n", firstInteger, isEqualTo(firstInteger, secondInteger) ? "is" : "is not", secondInteger);
		System.out.printf("%d %s equal to %d", firstInteger, isEqualTo(firstInteger, thirdInteger) ? "is" : "is not", thirdInteger);
	}
	
}
