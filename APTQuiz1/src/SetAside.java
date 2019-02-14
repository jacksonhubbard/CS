
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class SetAside {
      public String common(String[] list) {
         
  	 	HashMap<String, Integer> hashMap= new HashMap<String, Integer>();
  	 	ArrayList<String> ans = new ArrayList<String>();
  	 	
    	  	
  	 	for (String phrase : list) {
    	  		
    	  		String[] words = phrase.split(" ");
    	  		
    	  		Set<String> mySet = new HashSet<String>(Arrays.asList(words)); 
    	  		
    	  		String[] words2 = mySet.toArray(new String[mySet.size()]);
    	  		
    	  		for (int i = 0; i<words2.length; i++) {
    	  			if (! hashMap.containsKey(words2[i])) {
        	 			hashMap.put(words2[i], 1);
        	 			
        	 		}
        	 		
    	  			
        	 		else {
        	 			hashMap.put(words2[i], hashMap.get(words2[i])+1);
        	 		}
    	  			
    	  		}
    	  	}
    	  	
    	  	for (Entry<String, Integer> entry : hashMap.entrySet()) {
    	  		if(entry.getValue() == list.length) {
    	  			ans.add(entry.getKey());
    	  		}
    	  	}
    	  	Collections.sort(ans);
        
    	  	String[] ans2 = ans.toArray(new String[0]);
    	  	
    	  	if (ans2.length == 0) {
    	  		return "";
    	  	}
    	  	
    	  	String ans3 = "";
    	  	
    	  	for (String w : ans2) {
    	  		ans3 = ans3 + w + " ";
    	  	}
    	  	
    	  	return ans3.trim(); 
    	  	
      }
  }
  
