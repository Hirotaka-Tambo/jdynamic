package la.business;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Servlet implementation class CalcAge
 */
public class CalcAge{
	public int howOld(int year, int month, int date) {
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(year, month, date);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		int todayInt = Integer.parseInt(today.format(formatter));
		int birthdayInt = Integer.parseInt(birthday.format(formatter));
		
		return(todayInt - birthdayInt) / 10000;
	}
	
	
}