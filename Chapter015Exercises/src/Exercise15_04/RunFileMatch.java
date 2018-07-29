package Exercise15_04;

public class RunFileMatch {
	
	public static void main (String[] args)
	{
		FileMatch fileMatch = new FileMatch();
		
		fileMatch.openFiles();
		fileMatch.processFiles();
		fileMatch.closeFiles();
				
	}

}
