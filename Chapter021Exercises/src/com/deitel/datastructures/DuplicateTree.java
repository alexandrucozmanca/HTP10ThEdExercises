package com.deitel.datastructures;

class DuplicateTreeNode<T extends Comparable<T>>
{
	// package access members
	DuplicateTreeNode<T> leftNode;
	T data;
	DuplicateTreeNode<T> rightNode;
	
	
	// constructor initializes data and makes this a leafNode
	public DuplicateTreeNode(T nodeData)
	{
		data = nodeData;
		leftNode = rightNode = null; // node has no children
	}
	
	// locate insertion point and insert new Node ; ignore duplicate values
	public void insert(T insertValue)
	{
		if (insertValue.compareTo(data) < 0)
		{
			// insert new DuplicateTreeNode
			if (leftNode == null)
				leftNode = new DuplicateTreeNode<T>(insertValue);
			else // continue traversing left subtree recursively
				leftNode.insert(insertValue);
		}
		
		else if(insertValue.compareTo(data) >= 0)
		{
			// insert new DuplicateTreeNode
			if (rightNode == null)
				rightNode = new DuplicateTreeNode<T>(insertValue);
			else // continue traversing right subtree recursively
				rightNode.insert(insertValue);
		}
	}
	
} // end class DuplicateTreeNode

// class Tree definition
public class DuplicateTree <T extends Comparable<T>> 
{
	
	private DuplicateTreeNode<T> root;
	private int depth;
	
	// constructor initializes an empty Tree of integers
	public DuplicateTree()
	{
		root = null;
		depth = 0;
	}
	
	// insert a new node in the binary search tree
	public void insertNode(T insertValue)
	{
		if (root == null)
			root = new DuplicateTreeNode<T>(insertValue); // create root node
		else 
			root.insert(insertValue); // call the insert method
	}
	
	// begin preorder traversal
	public void preorderTraversal()
	{
		preorderHelper(root);
	}

	private void preorderHelper(DuplicateTreeNode <T> node)
	{
		if (node == null)
			return;
		
		System.out.printf("%s ", node.data); // output node data
		preorderHelper(node.leftNode); // traverse left subtree
		preorderHelper(node.rightNode); // traverse right subtree
	}
	
	// begin inorder traversal
	public void inorderTraversal()
	{
		inorderHelper(root);
	}
	
	private void inorderHelper(DuplicateTreeNode <T> node)
	{
		if (node == null)
			return;
		
		inorderHelper(node.leftNode); // traverse left subtree
		System.out.printf("%s ", node.data); // output node data
		inorderHelper(node.rightNode); // traverse right subtree 
	}
	
	// begin postorder traversal 
	public void postorderTraversal()
	{
		postorderTraversalHelper(root);
	}
	
	private void postorderTraversalHelper(DuplicateTreeNode<T> node)
	{
		if (node == null)
			return;
		
		postorderTraversalHelper(node.leftNode); // traverse left subtree
		postorderTraversalHelper(node.rightNode); // traverse right subtree
		System.out.printf("%s ", node.data);
	}
	
	// begin tree Output
	public void outputTree()
	{
		outputTreeHelper(root, 0);
	}
	
	private void outputTreeHelper(DuplicateTreeNode<T> current, int totalSpaces)
	{	
		StringBuilder output = new StringBuilder();
		
		if (current == null)
		{
			return;
		}
		
		// add offset for each branch
		for (int i = 0; i < totalSpaces; i ++)
			output.append(" ");
		
		outputTreeHelper(current.leftNode,totalSpaces + 5); // traverse left subtree adding 5 spaces for each new branch
		
		output.append(String.format("%s", current.data)); // add and output node data
		System.out.println(output.toString());
		
		outputTreeHelper(current.rightNode, totalSpaces + 5); // traverse right subtree adding 5 spaces for each new branch
	}

	public int getDepth()
	{
		getDepthHelper(root, 1);
		
		return depth;
	}
	
	private void getDepthHelper(DuplicateTreeNode<T> current, int depth)
	{
		if (current == null)
			return;
				
		if (depth > this.depth)
			this.depth = depth;
		
		getDepthHelper(current.leftNode, depth + 1);
		getDepthHelper(current.rightNode, depth + 1);
	}

	
} // end class tree

