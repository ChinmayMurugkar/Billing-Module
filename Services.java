package billing;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Services {
	
	public int calculateBill(Customer c){
		
		//Object validity
		if(c==null)
			return 0;
		if(c.p ==null)
			return 0;
		if(c.dateOfPurchase==null)
			return 0;
		
		//Plan base fee validity
		if(c.p.BaseFee ==0 || c.p.BaseFee<0 )
			return 0;
		
		Calendar myCal = new GregorianCalendar();
		//set date format 
		DateFormat dateFormat = new SimpleDateFormat("MM DD YYYY");
		//get todays date
		Date todays = new Date();
		//setting time in calender
	    myCal.setTime(todays);
	    //get todays day of month
	    int todaysDay = myCal.get(Calendar.DAY_OF_MONTH);
	    //get days available in todays dates month
	    int daysInMonthTodays =  myCal.getActualMaximum(Calendar.DAY_OF_MONTH);
	    //bill cycle day date validity
	  	if(c.billCycleDay==0 || c.billCycleDay>daysInMonthTodays || c.billCycleDay<1)
	  		return 0;
	    
	     //get previous month
	     myCal.add(Calendar.MONTH, -1);
	     Date prevMonth = myCal.getTime();
	    //only if today is the billing day then calculate the bill
	    if(todaysDay==c.billCycleDay){
	    	//get date of purchase of customer
	    	Date dateOfPurchase = c.dateOfPurchase;
	    	
	    	//Check if the bill contains pro-rated days or is a regular cycle bill
	    	Calendar cal1 = new GregorianCalendar();
	    	Calendar cal2 = new GregorianCalendar();
	    	cal1.setTime(dateOfPurchase); cal2.setTime(prevMonth);
	    	if(cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)){
	    		int daysInPrevMonth = myCal.getActualMaximum(Calendar.DAY_OF_MONTH);
	    		int daysProrated = getDiff(todays, prevMonth);
	    		return calculateProratedBill(c,daysInPrevMonth, daysProrated);
	    	}
	    	else{
	    		return c.p.BaseFee;
	    	}
	    	
	    }
		return 0;
		
	}
	
	//Caluculating the ProratedBill
	private int calculateProratedBill(Customer c,int daysInPrevMonth, int daysProrated){
		
		//pro-rated bill for last month
		int proratedBill = (c.p.BaseFee/daysInPrevMonth) * daysProrated; 	
		//final bill which includes last months pro-rated bill + the next month bill
		int finalBill = c.p.BaseFee + proratedBill;		
		return finalBill;
	}
	
	//Get difference between two dates
	private int getDiff(Date date1, Date date2){

		    long diff = date1.getTime() - date2.getTime();
		    long daysDiff =  TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		    
		    return safeLongToInt(daysDiff);
	}
	
	//cast long to int safely
	public static int safeLongToInt(long l) {
	    if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
	        throw new IllegalArgumentException
	            (l + "The days are above the allowed limit");
	    }
	    return (int) l;
	}
}
