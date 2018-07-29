package Exercise014_008;

import java.util.Scanner;

public class TokenizedTelephoneNumbers {

	public static void main (String[] args){

		System.out.println("Please input phone number using the following format: (XXX) XXX-XXXX");
		Scanner keyboard = new Scanner(System.in);

		String phoneNumber = keyboard.nextLine();
		
		String regex = "\\(\\d{3}\\) \\d{3}-\\d{4}";

		if(phoneNumber.matches(regex))
		{
			String[] temp = phoneNumber.split(" ");
			String areaCode = temp[0].substring(1, temp[0].length() - 1);
			temp = phoneNumber.split("-");
			String phoneSubNumber = (temp[0].substring(5, temp[0].length())).concat(temp[1]);
			System.out.printf("Area code: %s, number: %s", areaCode, phoneSubNumber);
		}
		
		else 
			System.out.println("Incorrect number pattern");
		

		keyboard.close();
	}

}
