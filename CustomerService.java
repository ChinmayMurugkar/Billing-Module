package billing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerService {
	
	//main driving class
		public static void main(String [] args)
		{
			int baseFee = 60;
			int billCycleDay = 17;
			Date dateOfPurchase = new Date();
			
			String dateText = "00 00 0000";
			SimpleDateFormat format = new SimpleDateFormat("M dd yyyy");
			try {
				if(dateText=="00 00 0000" || dateText=="0" || dateText=="")
					dateOfPurchase = null;
				else
					dateOfPurchase = format.parse(dateText);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Plan p = new Plan(baseFee);
			Customer c = new Customer(p,dateOfPurchase,billCycleDay);
			
			Services s = new Services();
			
			int CustomerBill = s.calculateBill(c);
			
			System.out.println("final bill is "+CustomerBill);
		}

}
