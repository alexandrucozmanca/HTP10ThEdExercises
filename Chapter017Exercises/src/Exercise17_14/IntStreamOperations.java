package Exercise17_14;
import java.util.stream.IntStream;


public class IntStreamOperations 
{
	public static void main(String[] args)
	{
		int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9 , 7};
		
		// display original values
		System.out.print("Original values: ");
		IntStream.of(values)
			.forEach(value -> System.out.printf("%d ", value));
		System.out.println();
		
		
		System.out.printf("Sum of squares via reduce method: %d%n", 
				IntStream.of(values)
				.map(value -> value * value)
				.reduce(0, (x, y) -> x + y));
				
	}
	
}// end Class IntStreamOperators
