package Exercise21_07;

import java.util.Random;

import com.deitel.datastructures.SortedList;

public class OrderedListTest 
{
	public static void main(String[] args)
	{
		SortedList<Integer> orderedList = new SortedList<>();
		orderedList.insert(2);
		orderedList.print();
		
		orderedList.insert(0);
		orderedList.print();
		
		orderedList.insert(4);
		orderedList.print();
		
		orderedList.insert(3);
		orderedList.print();
		
		System.out.println();
		
		for (int i = 1; i <= 25; i ++)
		{
			orderedList.insert(new Random().nextInt(90));
		}
		orderedList.print();
		
	}
}
