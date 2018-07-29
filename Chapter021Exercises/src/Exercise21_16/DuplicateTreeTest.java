package Exercise21_16;

import com.deitel.datastructures.DuplicateTree;

// changes to TreeNode inner class in Tree Class
/*
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
		
		else if(insertValue.compareTo(data) >= 0)   <-- changes in this line
		{
			// insert new TreeNode
			if (rightNode == null)
				rightNode = new TreeNode<T>(insertValue);
			else // continue traversing right subtree recursively
				rightNode.insert(insertValue);
		}
	}
  
 */


public class DuplicateTreeTest
{

	public static void main (String[] args)
	{
		DuplicateTree<Integer> tree1 = new DuplicateTree<Integer>();
		
		tree1.insertNode(49);
		
		tree1.insertNode(28);
		tree1.insertNode(83);
		
		tree1.insertNode(18);
		tree1.insertNode(28);
		tree1.insertNode(40);
		tree1.insertNode(71);
		tree1.insertNode(97);
		
		tree1.insertNode(11);
		tree1.insertNode(19);
		tree1.insertNode(32);
		tree1.insertNode(44);
		tree1.insertNode(69);
		tree1.insertNode(72);
		tree1.insertNode(92);
		tree1.insertNode(99);
		
		System.out.println("Tree1:");
		tree1.inorderTraversal();
		
		System.out.println();
		tree1.outputTree();
				
	}
}
