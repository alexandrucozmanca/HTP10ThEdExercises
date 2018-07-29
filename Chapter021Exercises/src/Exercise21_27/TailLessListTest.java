package Exercise21_27;

import java.util.Random;

import com.deitel.datastructures.EmptyListException;

// class to represent one node in a list
class ListNode<T> 
{

	// package access members; List can access these directly 
	T data; // data for this node
	ListNode<T> nextNode; // reference to the next node in the List
	
	// constructor creates a ListNode that refers to object
	ListNode(T object)
	{
		this(object, null);
	}
	
	// constructor creates ListNode that refers to the specified object and to the nextListNode
	ListNode(T object, ListNode<T> node)
	{
		data = object;
		nextNode = node;
	}
	
	// return referente to next node in list
	ListNode<T> getNext()
	{
		return nextNode;
	}
	
} // end class ListNode<T>


// class List definition
class TaillessList<T>
{
	
	private ListNode<T> firstNode;
	private String name; // string like "list" used in printing
	private int length;  // list length 
	
	// constructor creates empty List with "list" as the name
	public TaillessList()
	{
		this("List");
	}
	
	// constructor creates an empty List with a name
	public TaillessList(String listName)
	{
		name = listName;
		firstNode = null;
		length = 0;
	}
	
	// insert item at fort of List
	public void insertAtFront(T insertItem)
	{
		if(isEmpty()) //
			firstNode = new ListNode<T>(insertItem);
		else // firstNode refers to newNode
			firstNode = new ListNode<T>(insertItem, firstNode);
		
		length++;
	}
	
	// insert item at end of List
	public void insertAtBack(T insertItem)
	{
		if(isEmpty()) // 
			firstNode = new ListNode<T>(insertItem);
		else // 
		{
			// progress along the list until .nextNode references null - end of the list
			ListNode<T> temp = firstNode;
			while (temp.nextNode != null)
				temp = temp.nextNode;
			
			// initialize a new node and link it to the last node
			temp.nextNode = new ListNode<T>(insertItem);
			
			// the new "last node" has it`s .nextNode reference set to null 			
			temp.nextNode.nextNode = null;
			
		}
		
		length++;
	}

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
		
	// peek at lastNode
	public T peekAtFront()
	{
		if (isEmpty()) // throw exception if List is empty
			throw new EmptyListException(name);
		
		return firstNode.data;
	}
	
	public T peekAtBack()
	{
		if (isEmpty()) // throw exception if List is empty
			throw new EmptyListException(name);
		
		
		// progress along the list until .nextNode references null - end of the list
		ListNode<T> temp = firstNode;
		while(temp.nextNode != null)
			temp = temp.nextNode;
		
		return temp.data;
	}
	
	// remove first node from List
	public T removeFromFront() throws EmptyListException
	{
		if (isEmpty()) // throw exception if List is empty
			throw new EmptyListException(name);
		
		T removedItem = firstNode.data; // retrieve data being removed
		
		//update references firstNode 
		if (firstNode.nextNode == null)
			firstNode = null;
		else
			firstNode = firstNode.nextNode;
		
		length--;
		return removedItem;
	}
	
	// remove last node from 
	public T removeFromBack() throws EmptyListException
	{
		if (isEmpty()) // throw exception if List is empty
			throw new EmptyListException(name);
		
		if(firstNode.nextNode == null) // list has only one item
		{
			T deletedData = firstNode.data; // store data
			firstNode = null; // clear first node 
			length--;
			return deletedData; // return data
		}
		else // list has more that 1 item			
		{
			ListNode<T> temp = firstNode;
			while(temp.nextNode.nextNode != null)
					temp = temp.nextNode;
		
			T deletedData = temp.nextNode.nextNode.data; // store data being removed
			temp.nextNode = null; // update reference to "end" of list
			length--;
			return deletedData;
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
	
	// determine whether list is empty
 	public boolean isEmpty()
	{
		return firstNode == null; // return true if list in empty
	}
	
	// output list contents
	public void print()
	{
		if(isEmpty())
		{
			System.out.printf("Empty %s%n", name);
			return;
		}
		
		System.out.printf("The %s is: ", name);
		ListNode<T> current = firstNode;
		
		// while not at end of list, output current node`s data
		while(current != null)
		{
			System.out.printf("%s ", current.data);
			current = current.nextNode;
		}
		
		System.out.println();
	}

	// output list contents in reversed order
	public void printReverseList()
	{
		TaillessList<T> reverseList = TaillessList.reverse(this);
		
		reverseList.print();
	}
	
	// return list length
	public int length()
	{
		return length;
	}
	
	// search list and return reference to node containing data, or null if no such data found
	public T search(T data)
	{
		if (isEmpty())
			return null; 
		
		return nodeSearch(firstNode, data);
	}
	
	// helper method for search(T data)
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
	
	
	static public <T> void concatenate(TaillessList<T> firstList, TaillessList<T> secondList)
	{
		if (secondList.firstNode == null) // if second list is empty, do nothing 
			return;
		else if(firstList.firstNode == null) // if fist list is empty, just assign secondList`s firstNode to firstList`s firstNode 
		{
			firstList.firstNode = secondList.firstNode;
		}
		else
		{
			ListNode<T> current = firstList.firstNode; 
			
			// loop firstList until next to last element
			while (current.nextNode != null)
				current = current.nextNode;
			
			// assign firstList`s next to last element`s link as the secondList`s firstNode 
			current.nextNode = secondList.firstNode;
							
		}
	}

	static public <T> TaillessList<T> reverse(TaillessList<T> list)
	{
		TaillessList<T> reversedList = new TaillessList<T>();
		
		ListNode<T> current = list.firstNode;
		
		while (current.nextNode != null)
		{
			reversedList.insertAtFront(current.data);
			current = current.nextNode;
		}
		
		reversedList.insertAtFront(current.data);
		return reversedList;
	}
	
}

public class TailLessListTest
{
	public static void main(String[] args)
	{
		TaillessList<Integer> emptyList1 = new TaillessList<>();
		TaillessList<Integer> list1 = new TaillessList<>();
		
		// insert integers in list
		list1.insertAtFront(-1);
		list1.insertAtFront(0);
		list1.insertAtBack(1);
		list1.insertAtBack(5);
		list1.print();
		
		TaillessList.concatenate(emptyList1, list1);
		System.out.println("EmptyList1 after concatenating with list1");
		emptyList1.print();
		
		TaillessList<Integer> emptyList2 = new TaillessList<>();
		TaillessList.concatenate(list1, emptyList2);
		System.out.println();
		System.out.println("List1 after concatenating with emptyList2");
		list1.print();
		
		TaillessList<Integer> list2 = new TaillessList<>();
		list2.insertAtFront(-10);
		list2.insertAtFront(-9);
		list2.insertAtFront(-8);
		list2.insertAtFront(-7);
		list2.print();
		
		TaillessList.concatenate(list1, list2);
		System.out.println();
		System.out.println("List1 after concatenating with list2");
		list1.print();
		
		System.out.println("\nReverse order test");
		TaillessList<Integer> list = new TaillessList<>();
		
		for (int i = 0; i < 10; i ++)
			list.insertAtBack(new Random().nextInt(100));
		
		System.out.printf("List printed using \"print\" method:%n");
		list.print();
		
		System.out.printf("%nList printed in reversed order using \"printReverseList\" method:%n");
		list.printReverseList();
		
		System.out.println("\nSearch test");
		
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
