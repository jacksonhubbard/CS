import java.util.Arrays;

public class SandwichBar
{
   public int whichOrder(String[] available, String[] orders){
      for(int k=0; k<orders.length; k++) {
    	  	Boolean[] result = new Boolean[orders[k].length()];
    	  	String[] order= orders[k].trim().split("\\s+");
    	  	
    	  			
    	  	for (int j=0; j<order.length; j++) {
    	  		if (Arrays.asList(available).contains(order[j])) { 
    	  			result[j]= true;
    	  		}else { 
    	  				result[j] = false;
    	  			
    	  			}
    	  		}	
    	  	if(!Arrays.asList(result).contains(false)) {
    	  		return k;
    	  	}
    	  	
      }
    	  return -1;
   }
}

