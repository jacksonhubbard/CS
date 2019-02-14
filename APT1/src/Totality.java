
public class Totality {
	     public int sum(int[] a, String stype) {
		    	 int odd_sum = 0;
		    	 int even_sum = 0;
		    	 
		    	 for(int k=0; k< a.length; k+=1) {
		    		 if (k % 2 ==0) {
		    			 even_sum += a[k];
		    		 }
		    		 else {
		    			 odd_sum += a[k];
		    		 }
		    		 
		    		 
		    	 }
		    	 if (stype.equals("odd")) {
		    		 return odd_sum;
		    	 }
		    	 if (stype.equals("even")) {
		    		 return even_sum;
		    	 }
		    	 
		    	 return even_sum + odd_sum;
	     }
}
