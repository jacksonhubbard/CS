import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;

public class MaxDonor {
     public String generous(String[] orgs, int[] amount) {
         
    	 
    	 	HashMap<String, Integer> hashMap= new HashMap<String, Integer>();
    	 	for (int i=0; i<orgs.length; i++) {
    	 		if (! hashMap.containsKey(orgs[i])) {
    	 			hashMap.put(orgs[i], amount[i]);
    	 		}
    	 		
    	 		else {
    	 			hashMap.put(orgs[i], hashMap.get(orgs[i])+amount[i]);
    	 		}
    	 		
    	 	}
    	 	
    	 	
   
                
        int maxAmount = (Collections.max(hashMap.values()));
        String maxDonor = "";
        		
        for (Entry<String, Integer> entry : hashMap.entrySet()) {
        		if (Objects.equals(maxAmount, entry.getValue()))
        			maxDonor = entry.getKey();
        }
    	 
    	 	return maxDonor + ":$" + maxAmount;
    	 	
         
     }
 }