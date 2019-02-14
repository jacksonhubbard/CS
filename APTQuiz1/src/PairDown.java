import java.util.ArrayList;

public class PairDown {
     public int[] fold(int[] list) {
         ArrayList<Integer> ans = new ArrayList<Integer>();
         
         if(list.length %2 ==0) {
        	 for(int k=0; k<list.length; k+=2) {
        		 ans.add(list[k]+list[k+1]);
        	 }
         }
         
         else {
        	 for(int k=0; k<list.length-1; k+=2) {
        		 ans.add(list[k]+list[k+1]);
        	 }
        	 ans.add(list[list.length-1]);
         }
         
         int[] ans2 = new int[ans.size()];
         int count = 0;
         
         for (Integer n : ans) {
        	 ans2[count++] = n.intValue();
         }
         
         
         
         
    	 
    	 	
    	 
    	 
    	 
         return ans2;
     }
 }