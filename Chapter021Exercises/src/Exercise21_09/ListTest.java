package Exercise21_09;

import com.deitel.datastructures.List;

public class ListTest 
{
	public static void main(String[] args)
	{
		List<Integer> emptyList1 = new List<>();
		List<Integer> list1 = new List<>();
		
		emptyList1.print();	
				
		// insert integers in list
		list1.insertAtFront(-1);
		list1.insertAtFront(0);
		list1.insertAtBack(1);
		list1.insertAtBack(5);
		list1.print();
		
		List<Integer> list2 = List.reverse(list1); 
		list2.print();
		
	}
} // end class ListTest
