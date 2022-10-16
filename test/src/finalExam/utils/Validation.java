package finalExam.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Validation {

	public static LocalDate isDate(String daytime) { 
		// chuyển kiểu String thành localday
		LocalDate localDate1 = LocalDate.parse(daytime, DateTimeFormatter.ofPattern("dd/MM/yyyy"));	
		return localDate1;
	}

	public static int isnumber(String choose) {
		int number = 0; 
		try { 
			number = Integer.parseInt(choose);
		}catch (NumberFormatException exception) {
			throw new NumberFormatException();
		}
		return number;
	}

}
