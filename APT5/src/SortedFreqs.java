import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class SortedFreqs {
      public int[] freqs(String[] data) {
    	    		TreeMap<String, Integer> map = new TreeMap<>();

    	  		String[] words = data.clone();
    	  		
    	  		for (String s : words) {
            	  	map.putIfAbsent(s, 0);
            	  	map.put(s, map.get(s)+1);            	  
              }

    	  		Set<String> set = new HashSet<String>();
    	        Collections.addAll(set, words);
    	        String[] setArray =  set.toArray(new String[set.size()]);
    	        Arrays.sort(setArray);
    	        
    	        int size = setArray.length;
    	        int[] ans = new int[size];
    	        
    	        for (int i=0; i<setArray.length; i++) {
    	        		ans[i] = map.get(setArray[i]);		
    	        }
    	        return ans;
      }
   }


