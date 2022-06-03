package com.qa.utility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CurrentSystemDate {
	SimpleDateFormat dateFormatter;
	Calendar calendar;
	public String currentDate()//--method name
	{
		
		dateFormatter = new SimpleDateFormat("MMM dd, yyyy");	
		calendar = Calendar.getInstance();
		Date currentDateTime = calendar.getTime();
		//System.out.println(dateFormatter.format(currentDateTime));
		return dateFormatter.format(currentDateTime);
				
	}
	public String pastDate(int past_daysCnt)
	{
		//Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -past_daysCnt);
		Date pastDateTime = calendar.getTime();
		return dateFormatter.format(pastDateTime);
		
		//System.out.println(dateFormatter.format(pastDateTime));
	}
	public String futureDate(int future_daysCnt)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, future_daysCnt);
		Date futureDateTime = calendar.getTime();
		return dateFormatter.format(futureDateTime);
		
		//System.out.println(dateFormatter.format(futureDateTime));
	}
//	public static void main(String[] args) {
//		CurrentSystemDate a = new CurrentSystemDate();
//		a.currentDate();
//		a.pastDate(1);
//		a.futureDate(1);
	//}

}


