package Exercise21_07;

import java.util.Random;

import com.deitel.datastructures.SortedList;

public class SortedListConcatenateTest 
{
	public static void main(String[] args)
	{
		SortedList<Integer> emptyList1 = new SortedList<>();
		SortedList<Integer> list1 = new SortedList<>();
		
		emptyList1.print();	
				
		// insert integers in list
		list1.insert(-1);
		list1.insert(0);
		list1.insert(1);
		list1.insert(5);
		list1.print();
		
		SortedList.concatenate(emptyList1, list1);
		System.out.println("EmptyList1 after concatenating with list1");
		emptyList1.print();
		
		SortedList<Integer> emptyList2 = new SortedList<>();
		SortedList.concatenate(list1, emptyList2);
		System.out.println();
		System.out.println("List1 after concatenating with emptyList2");
		list1.print();
		
		SortedList<Integer> list2 = new SortedList<>();
		list2.insert(-10);
		list2.insert(-9);
		list2.insert(-8);
		list2.insert(-7);
		list2.insert(-1);
		list2.insert(5);
		
		SortedList.concatenate(list1, list2);
		System.out.println();
		System.out.println("List1 after concatenating with list2");
		list1.print();
		
		SortedList<Integer> orderedList1 = new SortedList<>();
		SortedList<Integer> orderedList2 = new SortedList<>();
		
		for (int i = 1; i <= 10; i ++)
		{
			orderedList1.insert(new Random().nextInt(90));
			orderedList2.insert(new Random().nextInt(90));
		}
		orderedList1.print();
		orderedList2.print();
		
		System.out.println();
		SortedList.concatenate(orderedList1, orderedList2);
		orderedList1.print();
		
	}
} // end class ListTest
