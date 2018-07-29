package com.deitel.datastructures;

class TreeNode<T extends Comparable<T>>
{
	// package access members
	TreeNode<T> leftNode;
	T data;
	TreeNode<T> rightNode;


	TreeNode(T nodeData)
	{
		data = nodeData;
		leftNode = rightNode = null; // node has no children
	}

	// locate insertion point and insert new Node ; ignore duplicate values
	public void insert(T insertValue)
	{
		if (insertValue.compareTo(data) < 0)
		{
			// insert new TreeNode
			if (leftNode == null)
				leftNode = new TreeNode<T>(insertValue);
			else // continue traversing left subtree recursively
				leftNode.insert(insertValue);
		}

		else if(insertValue.compareTo(data) > 0)
		{
			// insert new TreeNode
			if (rightNode == null)
				rightNode = new TreeNode<T>(insertValue);
			else // continue traversing right subtree recursively
				rightNode.insert(insertValue);
		}
	}

}

// class Tree definition
public class Tree <T extends Comparable<T>>
{

	private TreeNode<T> root;
	private int depth;

	// constructor initializes an empty Tree of integers
	public Tree()
	{
		root = null;
		depth = 0;
	}

	// insert a new node in the binary search tree
	public void insertNode(T insertValue)
	{
		if (root == null)
			root = new TreeNode<T>(insertValue); // create root node
		else
			root.insert(insertValue); // call the insert method
	}

	// begin preorder traversal
	public void preorderTraversal()
	{
		if (root == null)
			System.out.println("Tree is empty");
		else
			preorderHelper(root);
	}

	private void preorderHelper(TreeNode <T> node)
	{
		if (node == null)
			return;

		System.out.printf("%s ", node.data); // output node data
		preorderHelper((TreeNode<T>) node.leftNode); // traverse left subtree
		preorderHelper((TreeNode<T>) node.rightNode); // traverse right subtree
	}

	// begin inorder traversal
	public void inorderTraversal()
	{
		if (root == null)
			System.out.println("Tree is empty");
		else
			inorderHelper(root);
	}

	private void inorderHelper(TreeNode <T> node)
	{
		if (node == null)
			return;

		inorderHelper((TreeNode<T>) node.leftNode); // traverse left subtree
		System.out.printf("%s ", node.data); // output node data
		inorderHelper((TreeNode<T>) node.rightNode); // traverse right subtree
	}

	// begin postorder traversal
	public void postorderTraversal()
	{
		if (root == null)
			System.out.println("Tree is empty");
		else
			postorderTraversalHelper(root);
	}

	private void postorderTraversalHelper(TreeNode<T> node)
	{
		if (node == null)
			return;

		postorderTraversalHelper((TreeNode<T>) node.leftNode); // traverse left subtree
		postorderTraversalHelper((TreeNode<T>) node.rightNode); // traverse right subtree
		System.out.printf("%s ", node.data);
	}

	// begin tree Output
	public void outputTree()
	{
		if (root == null)
			System.out.println("Tree is empty");
		else
			outputTreeHelper(root, 0);
	}

	private void outputTreeHelper(TreeNode<T> current, int totalSpaces)
	{
		StringBuilder output = new StringBuilder();

		if (current == null)
		{
			return;
		}

		// add offset for each branch
		for (int i = 0; i < totalSpaces; i ++)
			output.append(" ");

		outputTreeHelper((TreeNode<T>) current.leftNode, totalSpaces + 5); // traverse left subtree adding 5 spaces for each new branch

		output.append(String.format("%s", current.data)); // add and output node data
		System.out.println(output.toString());

		outputTreeHelper((TreeNode<T>) current.rightNode, totalSpaces + 5); // traverse right subtree adding 5 spaces for each new branch
	}

	// return depth of tree(the largest number of sub-branches of the tree)
	public int getDepth()
	{
		getDepthHelper(root, 1);

		return depth;
	}

	private void getDepthHelper(TreeNode<T> current, int depth)
	{
		if (current == null)
			return;

		if (depth > this.depth)
			this.depth = depth;

		getDepthHelper((TreeNode<T>) current.leftNode, depth + 1);
		getDepthHelper((TreeNode<T>) current.rightNode, depth + 1);
	}

	public TreeNode <T> searchTree(T searchData)
	{
		if (root == null)
			return null;

		return searchTreeNode(root, searchData);
	}

	private TreeNode<T> searchTreeNode(TreeNode <T> node, T searchData)
	{
		if (node == null)
			return null;

		if (node.data.equals(searchData))
			return node;
		else
			if (node.data.compareTo(searchData) > 0)
				return searchTreeNode(node.leftNode, searchData);
			else
				if (node.data.compareTo(searchData) < 0)
					return searchTreeNode(node.rightNode, searchData);
				else
					return null;


	}

	public void delete(T data)
	{
		TreeNode<T> nodeToBeDeleted = searchTree(data);
		
		int deleteCase = -1; // variable denoting which deletion case occurs
		
		if(nodeToBeDeleted == null) 
			deleteCase = 0; // situation when data is not present in the tree
		else 
			if(nodeToBeDeleted.leftNode == null && nodeToBeDeleted.rightNode == null)
				deleteCase = 1; // case 1, data present in a leaf node - delete node, by replacing parent node`s reference to null
			else 
				if (nodeToBeDeleted.leftNode == null && nodeToBeDeleted.rightNode != null || 
						nodeToBeDeleted.leftNode != null && nodeToBeDeleted.rightNode == null) 
					deleteCase = 2; // case 2 - data present in a node with only one sub-branch
				else 
					if(nodeToBeDeleted.leftNode != null && nodeToBeDeleted.rightNode != null)  
						deleteCase = 3;  // case 3 - data present in a node with two sub-branches
		
		switch(deleteCase)
		{
			case 0:	
				System.out.printf("%s not present, no modifications made.%n", data);
				break;
				
			case 1:
				// if node is both a leaf and the root - then the tree contains only one node - the root 
				// as such root becomes null
				if (nodeToBeDeleted == root)
					root = null;
				else // node is not root
				{
					// test which branch nodeToBeDeleted occupies in the parent node
					if (findParent(nodeToBeDeleted).leftNode == nodeToBeDeleted) // if left node
						findParent(nodeToBeDeleted).leftNode = null; // clear leftNode reference
					else
						findParent(nodeToBeDeleted).rightNode = null; // clear rightNode reference
				}
				break;
				
			case 2:
				// case 2, data present in a branch with only one sub-branch/ child
				if (nodeToBeDeleted.leftNode == null && nodeToBeDeleted.rightNode != null) // determine which child reference is valid
				{
					// test which branch nodeToBeDeleted occupies in the parent node
					if (findParent(nodeToBeDeleted).leftNode == nodeToBeDeleted) // if left node
						findParent(nodeToBeDeleted).leftNode = nodeToBeDeleted.rightNode; // clear leftNode reference
					else
						findParent(nodeToBeDeleted).rightNode = nodeToBeDeleted.rightNode; // clear rightNode reference
				}
				else
				{
					// test which branch nodeToBeDeleted occupies in the parent node
					if (findParent(nodeToBeDeleted).leftNode == nodeToBeDeleted) // if left node
						findParent(nodeToBeDeleted).leftNode = nodeToBeDeleted.leftNode; // clear leftNode reference
					else
						findParent(nodeToBeDeleted).rightNode = nodeToBeDeleted.leftNode; // clear rightNode reference
				}
				break;
				
			case 3:
				// case 3, data is present in a branch with two sub-branches
				
				// find replacementNode - the node containing the "smallest" value greater than the deleted` nodes value
				TreeNode <T> replacementNode = nodeToBeDeleted.leftNode; // start walking the left sub-branch
				
				// advance until the replacementNode refers to the deepest right node on the nodeToBeDeleted left branch
				while (replacementNode.rightNode != null)
					replacementNode = replacementNode.rightNode;
				
				if(nodeToBeDeleted != root)
				{
					if (replacementNode.leftNode == null) // replacementNode is a leaf
					{
						findParent(replacementNode).rightNode = null; 
						replacementNode.leftNode = nodeToBeDeleted.leftNode;
						replacementNode.rightNode = nodeToBeDeleted.rightNode;
						
						if (findParent(nodeToBeDeleted).leftNode == nodeToBeDeleted) // if left node
							findParent(nodeToBeDeleted).leftNode = replacementNode; // reset leftNode reference
						else
							findParent(nodeToBeDeleted).rightNode = replacementNode; // reset rightNode reference
										
					}
					
					else // replacementNode has a right sub-branch
					{
						findParent(replacementNode).rightNode = replacementNode.leftNode;
	
						replacementNode.leftNode = nodeToBeDeleted.leftNode;
						replacementNode.rightNode = nodeToBeDeleted.rightNode;
						
						if (findParent(nodeToBeDeleted).leftNode == nodeToBeDeleted) // if left node
							findParent(nodeToBeDeleted).leftNode = replacementNode; // reset leftNode reference
						else
							findParent(nodeToBeDeleted).rightNode = replacementNode; // reset rightNode reference
					}
				}
				else // node to be deleted is the root node
				{
					if (replacementNode.leftNode == null) // replacementNode is a leaf
					{
						findParent(replacementNode).rightNode = null; 
						replacementNode.leftNode = nodeToBeDeleted.leftNode;
						replacementNode.rightNode = nodeToBeDeleted.rightNode;
						
						root = replacementNode;
										
					}
					
					else // replacementNode has a right sub-branch
					{
						findParent(replacementNode).rightNode = replacementNode.leftNode;
	
						replacementNode.leftNode = nodeToBeDeleted.leftNode;
						replacementNode.rightNode = nodeToBeDeleted.rightNode;
						
						root = replacementNode;						
					}
				}
					
				break;
				
			default:
				System.out.println("There is an error in the algorithm");
				
		}
			
	}

	// helper method for delete - used to find the parent node of a given node
	private TreeNode<T> findParent(TreeNode<T> childNode)
	{
		return findParentHelper(root, childNode);
	}
	
	// helper method for findParent
	private TreeNode<T> findParentHelper(TreeNode<T> parentNode,TreeNode<T> childNode)
	{
		// if current node is the parent of the target node the return current node
		if(parentNode.leftNode == childNode || parentNode.rightNode == childNode)
			return parentNode;
		// if not determine branch to follow
		else
			// if data in childNode in "smaller" than parent Node - continue on left branch
			if (childNode.data.compareTo(parentNode.data) < 0)
				return findParentHelper(parentNode.leftNode, childNode);
			else // continue on right branch
				return findParentHelper(parentNode.rightNode, childNode);
	}
	
	public void levelTraversal()
	{
		Queue <TreeNode <T>> levelQueue = new Queue<>();
		
		levelQueue.enqueue(root);
				
		while (!levelQueue.isEmpty())
		{
			TreeNode <T> temp = levelQueue.dequeue();
			System.out.printf("%s ", temp.data);
			
			if(temp.leftNode != null) 
				levelQueue.enqueue(temp.leftNode);
			if(temp.rightNode != null)
				levelQueue.enqueue(temp.rightNode);
		}
		
	}

} // end class tree

