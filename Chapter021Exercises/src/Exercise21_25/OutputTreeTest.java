package Exercise21_25;
import java.util.Random;

import com.deitel.datastructures.Tree;

//changes to Tree class: - added the two methods below:
/*

	// begin tree Output
	public void outputTree()
	{
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
		
		outputTreeHelper(current.leftNode,totalSpaces + 5); // traverse left subtree adding 5 spaces for each new branch
		
		output.append(String.format("%s", current.data)); // add and output node data
		System.out.println(output.toString());
		
		outputTreeHelper(current.rightNode, totalSpaces + 5); // traverse right subtree adding 5 spaces for each new branch
	}

*/


public class OutputTreeTest
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
		tree1.insertNode(92);
		tree1.insertNode(99);
		
		System.out.println("Tree1:");
		tree1.inorderTraversal();
		
		System.out.println();
		tree1.outputTree();
		
		Tree<Integer> tree2 = new Tree<Integer>();
		// insert 10 random integers from 0-99 in tree
		for (int i = 1; i <= 10; i ++)
		{
			int value = new Random().nextInt(100);
			System.out.printf("%d ", value);
			tree2.insertNode(value);
		}
		
		System.out.println("\nTree2:");
		tree2.inorderTraversal();
		
		System.out.println();
		tree2.outputTree();
	}
}
