package Exercise21_23;

import com.deitel.datastructures.Tree;

// changes made to Tree class:
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
 
 */

public class BinaryTreeSearch 
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
		
		int data = 29;
		System.out.printf("%s %s in tree", data, (tree1.searchTree(data) != null) ? "found" : "not found");
		
		
	}
	
}
