import java.util.Arrays;
import java.util.Collections;

public class OlympicCandles{
   public int numberOfNights(int[] candles){
      
//	   	int sum = 0;
//	   	
//	   	for(int i= 0; i<candles.length; i++) {
//	   		sum += candles[i];
//	   		
//	   	}
//	   	
//	   	int nights = 0;
//	   	int lit = 1; 
//	   	
//	   	if (sum == 0) return 0;
//	   	if(sum == 1) return 1;
//	   	
//	   	while(sum > 0) {
//	   		nights ++;
//	   		lit += 1;
//	   		sum -= lit;
//	   		
//	   	}
//	   	
//	   	return nights;
	   	
	   
	   
	   int non0 = 0;
	   int nights = 0;
	   
	   Integer[] candlesINT = new Integer[candles.length];
	   
	   for(int i =0; i<candles.length; i++) {
		   candlesINT[i] = candles[i];
	   }
	   
	   
	   for(int c : candles) {
		   if (c != 0) non0++;
	   }
	   
	   
	   while(non0 >= nights && nights < candles.length) {
		   Arrays.sort(candlesINT, Collections.reverseOrder());
		   
		   for(int k = 0; k < nights; k++){
	    		  if (candlesINT[k]>0){
	    			  candlesINT[k] -= 1;
	    		  }
	    		  
	    		  
	    		  int count = 0;
		    	  for (int i: candlesINT){
		    		  if (i!=0){
		    			  count++;
		    			  non0 = count;
		    		  }
		    	  }  	  
		    	  nights++;
		      }
	    		  
	    	  }
	   
	   for (Integer i: candlesINT){
	    	  if (i == 0){
	    		  return nights-1;
	    	  }
	      }
	
	      return nights;
	   }
   }
 