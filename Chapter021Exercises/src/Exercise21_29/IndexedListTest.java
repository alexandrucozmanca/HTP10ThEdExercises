package Exercise21_29;

import com.deitel.datastructures.IndexedList;

public class IndexedListTest 
{
	
	public static void main(String[] args)
	{
		IndexedList list = new IndexedList();
		
		list.insert("a");
		list.insert("bb");
		list.insert("b");
		list.insert("aaaa");
		list.insert("aa");
		
		list.insert("B");
		list.print();
		
		if (list.search("a") == null)
			System.out.printf("a could no be found in the list.%n");
		else 
			System.out.printf("%s found in the list.%n", list.search("a"));
			
		if (list.search("aaa") == null)
			System.out.printf("aaa could no be found in the list.%n");
		else 
			System.out.printf("%s found in the list.%n", list.search("aaa").toString());

		if (list.search("b") == null)
			System.out.printf("b could no be found in the list.%n");
		else 
			System.out.printf("%s found in the list.%n", list.search("b"));
		
	}

}
