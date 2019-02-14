import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SortByFreqs {
	
    TreeMap<String, Integer> map = new TreeMap<>();

	
	class CompareArray implements Comparator<String>{
		 public int compare(String a, String b) {
			int comp = map.get(b) - map.get(a);
			if(comp != 0) return comp;
			if (comp==0) return a.compareTo(b);
			return 0;
		}
		
		
		
	}
	
      public String[] sort(String[] data) {    	  
          for (String s : data) {
        	  	map.putIfAbsent(s, 0);
        	  	map.put(s, map.get(s)+1);
        	  
          }
          
          Set<String> set = new HashSet<String>();
          Collections.addAll(set, data);
          String[] ans =  set.toArray(new String[set.size()]);

         
          Arrays.sort(ans, new CompareArray()); 

          return ans;
          

    	  
      }
   }