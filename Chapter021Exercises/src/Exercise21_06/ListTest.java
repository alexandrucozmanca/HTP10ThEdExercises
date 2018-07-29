package Exercise21_06;

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
		
		List.concatenate(emptyList1, list1);
		System.out.println("EmptyList1 after concatenating with list1");
		emptyList1.print();
		
		List<Integer> emptyList2 = new List<>();
		List.concatenate(list1, emptyList2);
		System.out.println();
		System.out.println("List1 after concatenating with emptyList2");
		list1.print();
		
		List<Integer> list2 = new List<>();
		list2.insertAtFront(-10);
		list2.insertAtFront(-9);
		list2.insertAtFront(-8);
		list2.insertAtFront(-7);
		
		List.concatenate(list1, list2);
		System.out.println();
		System.out.println("List1 after concatenating with list2");
		list1.print();
		
	}
} // end class ListTest
