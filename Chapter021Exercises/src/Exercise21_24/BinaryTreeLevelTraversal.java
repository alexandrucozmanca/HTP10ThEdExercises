package Exercise21_24;

import com.deitel.datastructures.Tree;

/*

 */

public class BinaryTreeLevelTraversal 
{
	public static void main(String[] args)
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
		
		tree1.outputTree();
		System.out.println();
		
		tree1.levelTraversal();
	}

}
