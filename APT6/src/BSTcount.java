public class BSTcount {
	
	long[] memo = new long[5000];
		
		
      public long howMany(int[] values) {
    	  		return helper(values.length);
    	  
    	  
    	  
      }
      
      
    	  private long helper(int n) {
    		  
    		  if (memo[n] != 0) return memo[n];
    		  
    		  if (n ==0 || n == 1) return 1;
    		  long total = 0;
    		  for (int leftCount = 0; leftCount <n; leftCount ++) {
    			  total += helper(leftCount) * helper(n-leftCount -1);
    		  }
    		  memo[n] = total; 
    		  
    		  return total;
    	  }
      
   }