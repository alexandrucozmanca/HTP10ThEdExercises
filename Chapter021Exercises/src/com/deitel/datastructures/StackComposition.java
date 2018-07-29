package com.deitel.datastructures;

public class StackComposition<T> 
{
	private List<T> stackList;
	
	// constructor
	public StackComposition()
	{
		stackList = new List<T>("stack");
	}
	
	// add object to stack
	public void push(T object)
	{
		stackList.insertAtFront(object);
	}
	
	// remove object from stack
	public T pop() throws EmptyListException
	{
		return stackList.removeFromFront();
	}
	
	public T peek() throws EmptyListException
	{
		return stackList.peekAtFront();
	}
	
	// determine if stack is empty
	public boolean isEmpty()
	{
		return stackList.isEmpty();
	}
	
	//output stack contents
	public void print()
	{
		stackList.print();
	}
}
