import java.util.ArrayList;
import java.util.Collections;

public class ValidAddresses {
    ArrayList<String> myList = new ArrayList<String>();

       public String[] valid(String possible){
             String[] parts = new String[4];
             helper(possible, 0, parts);
             
             Collections.sort(myList);
             return myList.toArray(new String[0]);
             
             
       }
       
       
       private void helper(String possible, int index, String[] parts) {
    	   		
       }
       
       private boolean dottedQuadOK (String digits) {
    	   		if (digits.charAt(0) == '0') return false;
    	   		if (Integer.parseInt(digits) > 255) return false;
    	   		if (Integer.parseInt(digits) < 0) return false;
    	   		
    	   		return true;
       }
       
   }



//    "1902426"
//
//   Returns: 
//   { "1.90.24.26",
//    "1.90.242.6",
//    "19.0.24.26",
//    "19.0.242.6",
//    "190.2.4.26",
//    "190.2.42.6",
//    "190.24.2.6" }