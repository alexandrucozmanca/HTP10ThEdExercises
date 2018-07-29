
public class Date 
{ private int day, month, year; //instance variables for day, month and year

	// constructor with validation for day within 1-31 and month within 1-12
  public Date (int day, int month, int year)
  {
	  if (day <= 31 && day >=1) this.day = day;
	  else this.day=1;
	  
	  if (month <=12 && month >=1) this.month = month;
	  else this.month=1;
	  
	  this.year = year;
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
	  if (tempInt <= 31 && tempInt >=1) this.day = tempInt;
	}
 
  // method to display data with MM/DD/YYYY patern
  public String displayDate()
  {
	  String displayDate = "00/00/0000";
	  displayDate = String.format("%02d/%02d/%04d",month,day,year);
	  	  return displayDate;
	  
  }
  
}
