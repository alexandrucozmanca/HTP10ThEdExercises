import static java.lang.System.out;

public class HealthProfile
{ private int day, month, year, heightInCm, weightInKg; //instance variables for day, month and year
  private String gender, firstName, lastName; 

	// constructor with validation for day within 1-31 and month within 1-12
  public HealthProfile (int day, int month, int year, int heightInCm, int weightInKg, 
		  String gender, String lastName, String firstName)
  {
	  if (day <= 31 && day >=1) this.day = day;
	  else this.day=1;
	  
	  if (month <=12 && month >=1) this.month = month;
	  else this.month=1;
	  
	  if (heightInCm > 0) this.heightInCm = heightInCm;
	  else this.heightInCm = 0;
	  
	  if (weightInKg > 0) this.weightInKg = weightInKg;
	  else this.weightInKg = 0;
	  
	  this.year = year;
	  this.gender = gender;
	  this.lastName = lastName;
	  this.firstName = firstName;
  }

  // method to return day
  public int getDay()
  {
	  return day;
  }
  
  // method to modify day with validation for day less or equal 31
  public void setDay(int tempInt)
  {
	  if (tempInt <= 31 && tempInt >=1) this.day = tempInt;
  }
  
  //method to return month
  public int getMonth()
  {
	  return month;
  }
 
  // method to modify month with validation for day less or equal 31
  public void setMonth(int tempInt)
  {
	  if (tempInt <= 12 && tempInt >=1) this.month = tempInt;
  }
 
  //method to return year
  public int getYear()
  {
	  return year;
  }

  //	method to modify year 
  public void setYear(int tempInt)
	{
	 this.year = tempInt;
	}
  
  
  // method to return height
  public int getHeight()
  {
	  return heightInCm;
  }
  
  // method to modify height with validation for positive
  public void setHeight(int tempInt)
  {
	  if (tempInt > 0) this.heightInCm = tempInt;
  }
  
  // method to return height
  public int getWeight()
  {
	  return weightInKg;
  }
  
  // method to modify height with validation for positive
  public void setWeight(int tempInt)
  {
	  if (tempInt > 0) this.weightInKg = tempInt;
  }
    
    //method for retrieving first name
	public String getGender()
	{
		return gender;
	}

	// method for modifing first name
	public void setGender(String tempString)
	{
		gender = tempString;
	}
  
  
   //method for retrieving first name
	public String getFirstName()
	{
		return firstName;
	}

	// method for modifing first name
	public void setFirstName(String tempString)
	{
		firstName = tempString;
	}
		
	// method for retrieving last name
	public String getLastName()
	{
		return lastName;
	}

	// method for modifing first name
	public void setLastName(String tempString)
	{
		lastName = tempString;
	}
    
  // method to display data with DD/MM/YYYY patern
  public String displayDate()
  {
	  String displayDate = "00/00/0000";
	  displayDate = String.format("%02d/%02d/%04d",day,month,year);
	  	  return displayDate;	  
  }
  
  // method to compute age
  public int getAge()
  {
	  return 2017-year;
  }
  
//method to max heartrate
 public int maxHeartRate()
 {
	  return 220-(2017-year);
 }
 
 //method to return optimum range - as string
 public String heartRateOptimum()
 {   double year = this.year;
	 String temp = "";
	 temp = String.format("%.0f - %.0f",0.5*(220-(2017-year)),0.85*(220-(2017-year)));
	 return temp;
 }
 
 //method to compute BMI
 public double computeBMI()
 {  double weightInKg = this.weightInKg;
 	double heightInCm = this.heightInCm;
	double BMI=0; 
	BMI= weightInKg*10000/(heightInCm*heightInCm);
	return BMI;
 }
 
 //method to display BMI info
 void displayBMIInfo()
 {
	out.printf("%s\t\t%s%n","BMI","Values");
	out.printf("%s\t%s%n","Underweight","less than 18.5");
	out.printf("%s\t\t%s%n","Normal","between 18.5 and 24.9");
	out.printf("%s\t%s%n","Overweight","between 24.9 and 29.9");
	out.printf("%s\t\t%s%n","Obese","30 or greater");
 }
  
}
