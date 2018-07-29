
public class HeartRates
{ private int day, month, year; //instance variables for day, month and year
  private String firstName, lastName; 

	// constructor with validation for day within 1-31 and month within 1-12
  public HeartRates (int day, int month, int year, String lastName, String firstName)
  {
	  if (day <= 31 && day >=1) this.day = day;
	  else this.day=1;
	  
	  if (month <=12 && month >=1) this.month = month;
	  else this.month=1;
	  
	  this.year = year;
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
  
  //	method to modify year 
 
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
  
}
