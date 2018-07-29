
public class ValueOfPi 
{

	public static void main(String[] args) 
	{
	double pi = 4;
	int i= 3, j = 1;
	
	while ((int)(pi * 100000) != 314159)
	{
		if (j%2 == 1)pi -= (double)4/i;
		else pi += (double)4/i;
		System.out.printf("Value of pi is %.20f%n",pi);
		i += 2; 
		j++;
		System.out.println((int)(pi * 100000));
	}
	System.out.printf("%nComputed up to term: %d",i);
	
	}

}
