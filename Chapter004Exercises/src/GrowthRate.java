
public class GrowthRate 
{

	public static void main(String[] args) 
	{
			long worldPopulation = 7500000000L, populationGrowth;
			double growthRate = 1.1;

			int i = 1;
			
			System.out.printf("Current world population is %,d and growth rate is %.2f.%n",
					worldPopulation, growthRate);
			System.out.printf("Year\tWorld Pop\tPop Growth%n");
			
			while (i<=75)
			{
				populationGrowth = (long) (worldPopulation * growthRate / 100);
				worldPopulation += populationGrowth;
				
				System.out.printf("%d\t%,d\t%,d%n",i,worldPopulation,populationGrowth);
				
				i++;
				
			}
			
	}

}
