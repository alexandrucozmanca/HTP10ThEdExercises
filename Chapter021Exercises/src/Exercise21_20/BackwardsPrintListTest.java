package Exercise21_20;

import java.util.Random;
import com.deitel.datastructures.List;

//changes made to List class:
/*
	// output list contents in reversed order
	public void printReverseList()
	{
		List<T> reverseList = List.reverse(this);
		
		reverseList.print();
	}
	
		static public <T> List<T> reverse(List<T> list)
	{
		List<T> reversedList = new List<T>();
		
		ListNode<T> current = list.firstNode;
		
		while (current.nextNode != null)
		{
			reversedList.insertAtFront(current.data);
			current = current.nextNode;
		}
		
		reversedList.insertAtFront(list.lastNode.data);
		
		return reversedList;
	}
*/

public class BackwardsPrintListTest 
{
	
	public static void main (String[] args)
	{
		List<Integer> list = new List<>();
		
		for (int i = 0; i < 10; i ++)
			list.insertAtBack(new Random().nextInt(100));
		
		System.out.printf("List printed using \"print\" method:%n");
		list.print();
		
		System.out.printf("%nList printed in reversed order using \"printReverseList\" method:%n");
		list.printReverseList();
		
	}

}
