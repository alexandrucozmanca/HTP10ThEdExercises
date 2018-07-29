package com.deitel.datastructures;

import com.deitel.datastructures.List;
import com.deitel.datastructures.ListNode;

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
	
	// return referencte to next node in list
	ListNode<T> getNext()
	{
		return nextNode;
	}
	
} // end class ListNode<T>


// class List definition
public class List<T>
{
	
	private ListNode<T> firstNode;
	private ListNode<T> lastNode;
	private String name; // string like "list" used in printing
	private int length;  // list length 
	
	// constructor creates empty List with "list" as the name
	public List()
	{
		this("List");
	}
	
	// constructor creates an empty List with a name
	public List(String listName)
	{
		name = listName;
		firstNode = lastNode = null;
		length = 0;
	}
	
	// insert item at fort of List
	public void insertAtFront(T insertItem)
	{
		if(isEmpty()) // firstNode and lastNode refer to same object
			firstNode = lastNode = new ListNode<T>(insertItem);
		else // firstNode refers to newNode
			firstNode = new ListNode<T>(insertItem, firstNode);
		
		length++;
	}
	
	// insert item at end of List
	public void insertAtBack(T insertItem)
	{
		if(isEmpty()) // firstNode and lastNode refer to same object
			firstNode = lastNode = new ListNode<T>(insertItem);
		else // lastNode`s nextNode refers to new node
			lastNode = lastNode.nextNode = new ListNode<T>(insertItem);
		
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
		
		return lastNode.data;
	}
	
	// remove first node from List
	public T removeFromFront() throws EmptyListException
	{
		if (isEmpty()) // throw exception if List is empty
			throw new EmptyListException(name);
		
		T removedItem = firstNode.data; // retrieve data being removed
		
		//updata references firstNode and lastNode
		if (firstNode == lastNode)
			firstNode = lastNode = null;
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
		
		T removedItem = lastNode.data; // retrieve data being removed
		
		// update references firstNode and lastNode
		if (firstNode == lastNode)
			firstNode = lastNode = null;
		else //locate new last node
		{
			ListNode<T> current = firstNode;
			
			// loop while current node does not refer to lastNode
			while(current.nextNode != lastNode)
				current = current.nextNode;
			
			lastNode = current; // current in new lastNode
			current.nextNode = null;
		}
		
		length--;
		return removedItem; // return removed node data 
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
		List<T> reverseList = List.reverse(this);
		
		reverseList.print();
	}
	
	// return list length
	public int length()
	{
		return length;
	}
	
	// search list and return reference to node containg data, or null if no such data found
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
	
	
	static public <T> void concatenate(List<T> firstList, List<T> secondList)
	{
		if (secondList.firstNode == null) // if second list is empty, do nothing 
			return;
		else if(firstList.firstNode == null) // if fist list is empty, just assign secondList`s firstNode and 
		//lastNode values to firstList
		{
			firstList.firstNode = secondList.firstNode;
			firstList.lastNode = secondList.lastNode;
		}
		else
		{
			ListNode<T> current = firstList.firstNode; 
			
			// loop firstList until next to last element
			while (current.nextNode != null)
				current = current.nextNode;
			
			// assign firstList`s next to last element`s link as the secondList`s firstNode 
			current.nextNode = secondList.firstNode;
			// assign  firstList`s last node as the secondList`s last node
			firstList.lastNode = secondList.lastNode;
				
		}
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
	
}
