package billing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
	Plan p;
	Date dateOfPurchase;
	int billCycleDay;
	
	public Customer(){
		this.p = null;
		this.dateOfPurchase = new Date();
		this.billCycleDay = 0;
	}
	
	public Customer(Plan p, Date dateOfPurchase, int billCycleDay){
		this.p =p;
		this.dateOfPurchase = dateOfPurchase;
		this.billCycleDay = billCycleDay;
	}
	
	public Customer(Plan p, String dateText, int billCycleDay) throws ParseException{
		this.p =p;
		SimpleDateFormat format = new SimpleDateFormat("M dd yyyy");
		if(dateText=="00 00 0000" || dateText=="0" || dateText==""){
			this.dateOfPurchase = null;
			}
		else
			this.dateOfPurchase = format.parse(dateText);
		//this.dateOfPurchase = dateOfPurchase;
		this.billCycleDay = billCycleDay;
	}
}
