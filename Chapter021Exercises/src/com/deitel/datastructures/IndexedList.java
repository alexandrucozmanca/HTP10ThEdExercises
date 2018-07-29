package com.deitel.datastructures;


// class List definition
public class IndexedList
{
	
	private ListNode<String> firstNode;
	private ListNode<String> lastNode;
	private String name; // string like "list" used in printing
	private ListNode<String>[] index; // 2 dim array containing the index
	
	// constructor creates empty List with "list" as the name
 	public IndexedList()
	{
		this("List");
	}
	
	// constructor creates an empty List with a name
	public IndexedList(String listName)
	{
		name = listName;
		firstNode = lastNode = null;
		index = new ListNode[26];	
		for (int i = 0; i < index.length; i ++)
			index[i] = null;
		
	}
	
	// insert item at fort of List
	private void insertAtFront(String insertItem)
	{
		if(isEmpty()) // firstNode and lastNode refer to same object
			firstNode = lastNode = new ListNode<String>(insertItem);
		else // firstNode refers to newNode
			firstNode = new ListNode<String>(insertItem, firstNode);
	}
	
	// insert item at end of List
	private void insertAtBack(String insertItem)
	{
		if(isEmpty()) // firstNode and lastNode refer to same object
			firstNode = lastNode = new ListNode<String>(insertItem);
		else // lastNode`s nextNode refers to new node
			lastNode = lastNode.nextNode = new ListNode<String>(insertItem);
	}
	
		
	// insert item in ordered List
	public void insert(String insertItem)
	{
		if(isEmpty()) // firstNode and lastNode refer to same object
		{
			insertAtFront(insertItem);
			index[(int)(insertItem.toLowerCase().charAt(0)) - 97] = new ListNode<String>("");
			index[(int)(insertItem.toLowerCase().charAt(0)) - 97].nextNode = firstNode;
 		}
		
		else if (firstNode.data.compareTo(insertItem.toLowerCase()) > 0) // if insertItem contains data "smaller" that firstNode data, insert at front
			insertAtFront(insertItem);
		else if (lastNode.data.compareTo(insertItem.toLowerCase()) < 0) // if insertItem contains data "greater" that lastNode data, insert at back 
			insertAtBack(insertItem);
		else
		{
			ListNode<String> insertedNode = new ListNode<>(insertItem);
			
			// determine index and assign new value if need be
			
			// determine if current data already is already indexed 
			//if not assign index to the node that will contain the data
			if(index[(int)(insertItem.toLowerCase().charAt(0)) - 97] == null) // if no index present
			{
				index[(int)(insertItem.toLowerCase().charAt(0)) - 97] = new ListNode<String>("");
				index[(int)(insertItem.toLowerCase().charAt(0)) - 97].nextNode = insertedNode;
				
				// search for the greatest valid index smaller that the current index
				int lowerIndex = (int) insertItem.toLowerCase().charAt(0) - 97;
				while(lowerIndex > 0 || index[lowerIndex] == null)
					lowerIndex --;
				
				ListNode<String> current = index[lowerIndex].nextNode;
				
				if(current.nextNode == null)
				{
					current.nextNode = insertedNode;
					insertedNode.nextNode = lastNode;
				}
				else 
				{
					while (current.nextNode.data.compareTo(insertItem.toLowerCase()) < 0)
				
					current = current.nextNode;
												
					insertedNode.nextNode = current.nextNode;
					current.nextNode = insertedNode;
				}
			}
			else // index is present
			{
				// start search from indexed node
				ListNode<String> current = index[(int)(insertItem.toLowerCase().charAt(0)) - 97].nextNode;
				
				
				// test if current data is "smaller" than first node from the index
				if(current.data.compareTo(insertItem.toLowerCase()) > 0)
					index[(int)(insertItem.toLowerCase().charAt(0)) - 97].nextNode = current; // updata indexed node
				
				// insert item
				while (current.nextNode.data.compareTo(insertItem.toLowerCase()) < 0)
					current = current.nextNode;
												
					insertedNode.nextNode = current.nextNode;
					current.nextNode = insertedNode;
			}
			
		}
	}
	
	// remove first node from List
	public String removeFromFront() throws EmptyListException
	{
		if (isEmpty()) // throw exception if List is empty
			throw new EmptyListException(name);
		
		String removedItem = firstNode.data; // retrieve data being removed
		
		//updata references firstNode and lastNode
		if (firstNode == lastNode)
			firstNode = lastNode = null;
		else
			firstNode = firstNode.nextNode;
		
		return removedItem;
	}
	
	// remove last node from 
	public String removeFromBack() throws EmptyListException
	{
		if (isEmpty()) // throw exception if List is empty
			throw new EmptyListException(name);
		
		String removedItem = lastNode.data; // retrieve data being removed
		
		// update references firstNode and lastNode
		if (firstNode == lastNode)
			firstNode = lastNode = null;
		else //locate new last node
		{
			ListNode<String> current = firstNode;
			
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
		ListNode<String> current = firstNode;
		
		// while not at end of list, output current node`s data
		while(current != null)
		{
			System.out.printf("%s ", current.data);
			current = current.nextNode;
		}
		
		System.out.println();
	}
		
	public String search(String data)
	{
		if (isEmpty())
			return null; 
	
		ListNode<String> searchNode = firstNode;
		
		// if index exist update searchNode
		if(index[(int)(data.toLowerCase().charAt(0)) - 97] != null)
			searchNode = index[(int)(data.toLowerCase().charAt(0)) - 97].nextNode;
		else 
			return null; 
						
		return nodeSearch(searchNode, data);
	}
	
	// helper method for search(T data)
	private String nodeSearch(ListNode<String> current, String data)
	{
		if (current.data.toLowerCase().charAt(0) != data.toLowerCase().charAt(0))
			return null;
		else
			if(current.data.equals(data))
				return current.data;
			else 
				return nodeSearch(current.nextNode, data);
	}
}
