package Exercise21_19;

import com.deitel.datastructures.Tree;

// changes to Tree class:
/*
  	- added new private instance variable int depth
	- added the two methods below:
	
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
		
		getDepthHelper(current.leftNode, depth + 1);
		getDepthHelper(current.rightNode, depth + 1);
	}
 */



public class DepthTreeTest 
{
	public static void main (String[] args)
	{
		Tree<Integer> tree1 = new Tree<Integer>();
		
		tree1.insertNode(49);
		
		tree1.insertNode(28);
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
		tree1.insertNode(92);
		tree1.insertNode(99);
		
		System.out.println("Tree1:");
		tree1.inorderTraversal();
		
		System.out.println();
		tree1.outputTree();
		
		System.out.printf("%nTree depth is: %d%n", tree1.getDepth());
		
	}

}
