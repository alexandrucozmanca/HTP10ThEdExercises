package Exercise21_17;

import com.deitel.datastructures.Tree;

public class StringTreeTest 
{
	public static void main (String[] args)
	{
		String sentence = new String("The quick red fox jumps over the lazy hunting dog");
		String[] sentenceArray = sentence.split(" ");
		
		Tree<String> sentenceTree = new Tree<>();
		
		for (int i = 0; i < sentenceArray.length; i ++)
			sentenceTree.insertNode(sentenceArray[i]);
		
		sentenceTree.inorderTraversal();
		System.out.println();
		
		sentenceTree.preorderTraversal();
		System.out.println();
		
		sentenceTree.postorderTraversal();
		System.out.println();
		
		sentenceTree.outputTree();
	}

}
