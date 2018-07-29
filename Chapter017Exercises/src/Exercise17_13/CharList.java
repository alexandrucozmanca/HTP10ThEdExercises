package Exercise17_13;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Comparator;

public class CharList 
{
	public static void main (String[] args)
	{
		List<Character> charList = new ArrayList<Character>();
		Random generator = new Random();
		for (int i = 0; i < 30; i ++)
			charList.add((char) (97 + generator.nextInt(25)));
		
		for(int i = 0; i < charList.size(); i++)
			System.out.printf("%c ", charList.get(i));
		
		System.out.println();
		charList.stream()
		.sorted()
		.forEach(c -> System.out.printf("%c ",c));
				
		System.out.println();
		charList.stream()
		.sorted(Comparator.reverseOrder())
		.forEach(c -> System.out.printf("%c ",c));
		
		
		System.out.println();
		charList.stream()
		.sorted()
		.distinct()
		.forEach(c -> System.out.printf("%c ", c));
		
	}

}
