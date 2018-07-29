package Exercise21_26;

import com.deitel.datastructures.List;

// changes made to list class
/*
 	//	insert item at a given position 
	public void insertAtPosition(T insertItem, int position) throws IndexOutOfBoundsException
	{
		if (position < 1 || position > length)
			throw new IndexOutOfBoundsException("Position out of bounds.");
		
		if(position == 1)
			insertAtFront(insertItem);
		else
		{
			ListNode<T> temp = firstNode;
			ListNode<T> insertNode = new ListNode<T>(insertItem);
			
			for(int i = 1; i < position - 1; i ++)
				temp = temp.nextNode;
			
			insertNode.nextNode = temp.nextNode;
			temp.nextNode = insertNode;
			length ++;
		}
	}
  
	// remove node at given position 
	public T removeFromPosition (int position) throws EmptyListException, IndexOutOfBoundsException
	{
		if(isEmpty())
			throw new EmptyListException("List " + name + " is empty.");
		
		if (position < 1 || position > length)
			throw new IndexOutOfBoundsException("Position out of bounds.");
		
		if(position == 1)
		{
			return removeFromFront();
		}
		
		else if(position == length)
		{
			return removeFromBack();
		}
		
		else
		{	
			ListNode<T> beforeDeletedNode = firstNode;
			for (int i = 2; i < position; i ++)
				beforeDeletedNode = beforeDeletedNode.nextNode;
						
			T data = beforeDeletedNode.nextNode.data;
			beforeDeletedNode.nextNode = beforeDeletedNode.nextNode.nextNode;
			length --;
			return data;
		}
	}  
  
 */

public class Insert_DeleteAnywhereListTest 
{
	public static void main (String[] args)
	{
		List<Integer> list1 = new List<>();
		
		// insert integers in list
		list1.insertAtFront(-1);
		list1.insertAtFront(0);
		list1.insertAtBack(1);
		list1.insertAtBack(5);
		list1.print();
		
		
		list1.insertAtPosition(3, 1);
		list1.print();
		
		System.out.printf("%s%n", list1.removeFromPosition(4));
		list1.print();
		
		
	}
	

}
