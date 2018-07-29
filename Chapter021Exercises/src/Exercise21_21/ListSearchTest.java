package Exercise21_21;

import java.util.Random;

import com.deitel.datastructures.List;


// changes made to list class
/*
 	public T search(T data)
	{
		if (isEmpty())
			return null; 
		
		return nodeSearch(firstNode, data);
	}
	
	// helper method for seach(T data)
	private T nodeSearch(ListNode<T> current, T data)
	{
		if (current == null)
			return null;
		else
			if(current.data.equals(data))
				return current.data;
			else 
				return nodeSearch(current.nextNode, data);
	}
 */


public class ListSearchTest 
{
	
	public static void main (String[] args)
	{
		List<Integer> list = new List<>();
		 
		for (int i = 0; i < 10; i ++)
			list.insertAtBack(new Random().nextInt(100));
		
		list.insertAtBack(3);
		
		System.out.printf("List printed using \"print\" method:%n");
		list.print();

		if (list.search(2) == null)
			System.out.printf("2 could no be found in the list.%n");
		else 
			System.out.printf("%s found in the list.%n", list.search(2).toString());
			
		if (list.search(3) == null)
			System.out.printf("3 could no be found in the list.%n");
		else 
			System.out.printf("%s found in the list.%n", list.search(3).toString());
							
		list.insertAtFront(4);
		list.print();
		
		if (list.search(4) == null)
			System.out.printf("4 could no be found in the list.%n");
		else 
			System.out.printf("%s found in the list.%n", list.search(4).toString());
		
		
	}
	
}
