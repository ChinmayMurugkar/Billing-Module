package billing;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServiceTest {
	
	Services serv;
	
	@Before
	public void before(){
		serv = new Services();
	}
	
	@After
	public void After(){
		serv = null;
	}
	
	@Test
	public void testCalculateBill() throws ParseException {
		CustomerFactory cItr = new CustomerFactory();
		
		//Customer unit test different test cases
		int expectedFees[] ={114,60 ,0, 0,0,0,0};
		String dates[] = {"02 15 2015" , "01 15 2015" ,"02 15 2015" , "00 00 0000", "02 15 2015", "02 15 2015",""};
		int day[] = {17 , 17 ,17 , 17,-1,17,17};
		int baseFee[] ={60, 60 ,0 , 60,60,-1,60};
		
		//object creation for test and calling the function
		for(int i=0; i<dates.length; ++i){
			Customer c= new Customer(new Plan(baseFee[i]),dates[i],day[i]);
			Services s = new Services();
			int output = s.calculateBill(c);
			int expectedOutput = expectedFees[i];
			assertEquals(expectedOutput,output);
		}
		/*int i=0;
		Iterator iter = cItr.getIterator();
		while(iter.hasNext()){
	         Customer c = (Customer) iter.next();
	         Services s = new Services();
	         int OtuputBill = s.calculateBill(c);
	         assertEquals(expectedFees[i],OtuputBill);
	         i++;
	      } */	
	}
	
	@Test
	public void testCalculateProratedtest(){
		
	}

}
