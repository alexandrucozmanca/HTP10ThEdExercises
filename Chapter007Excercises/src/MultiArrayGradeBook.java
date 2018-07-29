import java.util.Scanner;

public class MultiArrayGradeBook
{
	Scanner keyboardReader = new Scanner (System.in);
	private String courseName;
	private int[][] grades;

	public MultiArrayGradeBook(String courseName, int studentNumber, int examsNumber)
	{
		int [][] grades = new int[studentNumber][examsNumber];
		for (int student = 0; student < studentNumber; student ++)
			for (int exam = 0; exam < examsNumber; exam ++)
				grades[student][exam] = -1;
		this.courseName = courseName;
		this.grades = grades;
	}

	public void setCourseName (String courseName)
	{
		this.courseName = courseName;
	}

	public void setGrade (int student, int exam, int grade)
	{
		grades[student - 1][exam - 1] = grade;
	}


	public void setGrades()
	{

		String grade = "";
		for (int student = 0; student < grades.length; student ++)
			for (int exam = 0; exam < grades[student].length; exam ++)
			{
				grade = "";
				System.out.printf("Please input grade for student %d and exam %d: ", student + 1, exam + 1);
				grade = keyboardReader.nextLine();

				try
				{
					grades[student][exam] = Integer.parseInt(grade);
				}

				catch(NumberFormatException e)
				{
					System.out.printf("Invalid grade for student %d at exam %d, try again after completing this process.%n",
							student + 1, exam + 1);
				}


			}
	}


	public String getCourseName()
	{
		return courseName;
	}

	public void outputGrades()
	{
		System.out.printf("The grades are: %n%n");
		System.out.printf("%12s","");
		for (int test = 0; test < grades[0].length; test++)
			System.out.printf("%7s ","Test",test);
		System.out.printf(" %s%n","Average");

		for (int gradeRow = 0; gradeRow < grades.length; gradeRow++)
		{
			int gradeTotal = 0;
			System.out.printf("Student %2d:", gradeRow + 1);
			for (int gradeColumn = 0; gradeColumn < grades[gradeRow].length; gradeColumn++)
				{
				System.out.printf("%8d",grades[gradeRow][gradeColumn]);
				if (grades[gradeRow][gradeColumn] >= 0)
					gradeTotal = gradeTotal + grades[gradeRow][gradeColumn];
				}
			System.out.printf("%9.2f%n", (double)gradeTotal / grades[gradeRow].length);
		}
	}

	public int getMinimumGrade()
	{
		int minimum = 100;
		for (int gradeRow = 0; gradeRow < grades.length; gradeRow++)
			for (int gradeColumn = 0; gradeColumn < grades[gradeRow].length; gradeColumn++)
				if (grades[gradeRow][gradeColumn] >= 0)
					if (minimum > grades[gradeRow][gradeColumn])
						minimum = grades[gradeRow][gradeColumn];

		return minimum;
	}

	public int getMaximumGrade()
	{
		int maximum = 0;

		for (int gradeRow = 0; gradeRow < grades.length; gradeRow++)
			for (int gradeColumn = 0; gradeColumn < grades[gradeRow].length; gradeColumn++)
				if (grades[gradeRow][gradeColumn] >= 0)
					if (maximum < grades[gradeRow][gradeColumn])
						maximum = grades[gradeRow][gradeColumn];

		return maximum;
	}

	/*
	public double getAverage()
	{
		double total = 0, average;

		for (int grade: grades)
			total += grade;
		average = total/grades.length;

		return average;
	}
	*/

	public void outputBarChart()
	{
		int[] frequency = new int[11];

		for (int gradeRow = 0; gradeRow < grades.length; gradeRow++)
			for (int gradeColumn = 0; gradeColumn < grades[gradeRow].length; gradeColumn++)
				if (grades[gradeRow][gradeColumn] >= 0)
					frequency[grades[gradeRow][gradeColumn]/10]++;

		String output = "\nGrade distribution:\n";

		for(int counter = 0 ; counter < frequency.length ; counter ++)
		{

			if (counter == 10)
				output = output + String.format("%5d: ",counter*10);
			else
				output = output + String.format("%02d-%02d: ",counter * 10 ,counter * 10 + 9);
			for (int grade = 0; grade < frequency[counter]; grade ++)
				output = output + "[]";
			output = output + "\n";
		}

		System.out.print(output);
	}

	public void processGrades()
	{
		outputGrades();



		System.out.printf("Lowest grade is %d.%nHighest grade is %d.%n",
				getMinimumGrade(),getMaximumGrade());

		outputBarChart();
	}

}
