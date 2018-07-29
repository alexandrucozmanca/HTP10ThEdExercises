package Exercise17_07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamOfLines 
{
	public static void main (String[] args) throws IOException
	{
		
		Pattern pattern = Pattern.compile("");
		
		Map<String, Long> charCount2 =
				Files.lines(Paths.get("src/Exercise17_07/Input.txt"))
				.map(line -> line.toUpperCase())
				.map(line -> line.replaceAll("(?!'`)\\p{P}",""))
				.map(line -> line.replace(" ", ""))
				.flatMap(line -> pattern.splitAsStream(line))
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		System.out.println("Input text contains the following characters and no. of occurences");
		charCount2.forEach((k, v) -> System.out.printf("%s :%3d%n", k, v));
		
	}

} // end class StreamOfLines
