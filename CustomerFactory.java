package billing;



import java.text.ParseException;

public class CustomerFactory implements Icutomer {
	public String dates[] = {"02 15 2015" , "01 15 2015" ,"02 15 2015" , "00 00 0000", "02 15 2015", "02 15 2015"};
	public int day[] = {17 , 17 ,17 , 17,-1,17};
	public int baseFee[] ={60, 60 ,0 , 60,60,-1};
	
	   @Override
	   public Iterator getIterator() {
	      return new CustomerIterator();
	   }
	   
	   private class CustomerIterator implements Iterator {

		      int index;
		      
		      
		      @Override
		      public boolean hasNext() {
		      
		         if(index < dates.length){
		            return true;
		         }
		         return false;
		      }

		      @Override
		      public Object next() {
		      
		         if(this.hasNext()){
		            try {
						return new Customer(new Plan(baseFee[index++]),dates[index++],day[index++]);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		         }
		         return null;
		      }		
		   }
}
