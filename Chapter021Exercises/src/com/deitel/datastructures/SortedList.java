package com.deitel.datastructures;


// class List definition
public class SortedList<T extends Comparable <T>>
{
	
	private ListNode<T> firstNode;
	private ListNode<T> lastNode;
	private String name; // string like "list" used in printing
	
	// constructor creates empty List with "list" as the name
	public SortedList()
	{
		this("List");
	}
	
	// constructor creates an empty List with a name
	public SortedList(String listName)
	{
		name = listName;
		firstNode = lastNode = null;
	}
	
	// insert item at fort of List
	private void insertAtFront(T insertItem)
	{
		if(isEmpty()) // firstNode and lastNode refer to same object
			firstNode = lastNode = new ListNode<T>(insertItem);
		else // firstNode refers to newNode
			firstNode = new ListNode<T>(insertItem, firstNode);
	}
	
	// insert item at end of List
	private void insertAtBack(T insertItem)
	{
		if(isEmpty()) // firstNode and lastNode refer to same object
			firstNode = lastNode = new ListNode<T>(insertItem);
		else // lastNode`s nextNode refers to new node
			lastNode = lastNode.nextNode = new ListNode<T>(insertItem);
	}
	
	
	// insert item in ordered List
	public void insert(T insertItem)
	{
		if(isEmpty()) // firstNode and lastNode refer to same object
			insertAtFront(insertItem);
		else if (firstNode.data.compareTo(insertItem) > 0) // if insertItem contains data "smaller" that firstNode data, insert at front
			insertAtFront(insertItem);
		else if (lastNode.data.compareTo(insertItem) < 0) // if insertItem contains data "greater" that lastNode data, insert at back 
			insertAtBack(insertItem);
		else
		{
			// loop list until a value "greater" that insert value is found 
			ListNode<T> current = firstNode;
			while (current.nextNode.data.compareTo(insertItem) < 0)
				current = current.nextNode;
			
			// if insert new data only if it is distinct
			if(current.nextNode.data.compareTo(insertItem) != 0)
			{	
				ListNode<T> insertNode = new ListNode<T>(insertItem);
				insertNode.nextNode = current.nextNode;
				current.nextNode = insertNode;
			}
		}
			
		
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
		
		return removedItem; // return removed node data 
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

	
	static public <T extends Comparable <T>> void concatenate(SortedList<T> firstList, 
			SortedList<T> secondList)
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
			ListNode<T> current = secondList.firstNode; 
			
			// loop secondList 
			while (current.nextNode != null)
			{
				firstList.insert(current.data); // insert data from current node into firstList
				current = current.nextNode;
			}
			
			firstList.insert(secondList.lastNode.data);
				
		}
	} 

}
