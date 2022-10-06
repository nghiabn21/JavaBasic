package learn.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationRules { 
	 
	public static boolean isValidEmail(String email) throws ParseException
	{
	    if (email != null)
	    {
	        Pattern p = Pattern.compile("^[A-Za-z].*?@gmail\\.com$");
	        Matcher m = p.matcher(email);
	        return m.find();
	    }
	    return false;
	} 
	 
//	public int GetvalidNumber(int number) {
//	     number = 0; 
//	     Scanner sc = new Scanner(System.in);
//	     while(true) {
//	        try {     	
//	            System.out.print("Enter a 7 digit number: ");
//	            number = sc.nextInt();
//	            if (number > 0 && Integer.toString(number).length() == 7)
//	                break;
//	        } catch(InputMismatchException e) {
//	            sc.nextLine();
//	            System.out.println("Invalid input: Use digits 0 to 9 only");
//	            continue;
//	        }
//	        System.out.println("Invalid input: Not 7 digits long");
//
//	     }
//	     return number;
//	} 
	 
	public boolean inValidNumber(String number) throws ParseException{ 
	//	System.out.print("Enter a 7 digit number: "); 
		boolean pa = Pattern.matches("[0-9]{7}" ,number);
		return pa; 	
	} 
	 
	 public Date StringToDate(String dob) throws ParseException{
	      //Instantiating the SimpleDateFormat class
	      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	      //Parsing the given String to Date object
	      Date date = formatter.parse(dob);
	   //   System.out.println("Date object value: "+date);
	      return date;
	   }

}
