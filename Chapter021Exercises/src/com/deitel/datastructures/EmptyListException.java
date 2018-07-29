package com.deitel.datastructures;

public class EmptyListException extends RuntimeException 
{
	// constructor 
	public EmptyListException()
	{
		this("List"); // call other EmptyListException constructor
	}
	
	// constructor 
	public EmptyListException(String name)
	{
		super(name + " is empty");
	}
} // end class EmptyListException
