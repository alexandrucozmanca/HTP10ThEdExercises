package Exercise21_22;

import com.deitel.datastructures.Tree;

// changes made to tree class:
/*
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
 
 
 */

public class BinaryTreeDeletion 
{
	public static void main (String[] args)
	{
		Tree<Integer> tree1 = new Tree<Integer>();
		
		tree1.insertNode(49);
		
		tree1.insertNode(28);
		tree1.insertNode(83);
		
		tree1.insertNode(18);
		tree1.insertNode(40);
		tree1.insertNode(71);
		tree1.insertNode(97);
		
		tree1.insertNode(11);
		tree1.insertNode(19);
		tree1.insertNode(32);
		tree1.insertNode(44);
		tree1.insertNode(69);
		tree1.insertNode(72);
		tree1.insertNode(95);
		tree1.insertNode(99);
		tree1.insertNode(9);
		tree1.insertNode(17);
		tree1.insertNode(15);
		tree1.insertNode(14);
		
		
		System.out.println("Tree1:");
		tree1.inorderTraversal();
		
		System.out.println();
		tree1.outputTree();
		
		tree1.delete(49);

		System.out.println();
		System.out.println();
		System.out.println();
		
		tree1.outputTree();

	}

}
