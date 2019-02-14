
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;


public class HuffmanDecoding {
      public String decode(String archive, String[] dictionary) {
            // fill in code here
//          
    	  		
    	  		
    	  		Map<Integer, Character> map = new HashMap<Integer, Character>();
    	  				
    	  		map.put(1, (char) 65);
    	  		map.put(2, (char) 66);
    	  		map.put(3, (char) 67);
    	  		map.put(4, (char)68);
    	  		map.put(5, (char)69);
    	  		map.put(6, (char)70);
    	  		map.put(7, (char)71);
    	  		map.put(8, (char)72);
    	  		map.put(9, (char)73);
    	  		map.put(10, (char)74);
    	  		map.put(11, (char)75);
    	  		map.put(12, (char)76);
    	  		map.put(13, (char)77);
    	  		map.put(14, (char)78);
    	  		map.put(15, (char)79);
    	  		map.put(16, (char)80);
    	  		map.put(17, (char)81);
    	  		map.put(18, (char)82);
    	  		map.put(19, (char)83);
    	  		map.put(20, (char)84);
    	  		map.put(21, (char)85);
    	  		map.put(22, (char)86);
    	  		map.put(23, (char)87);
    	  		map.put(24, (char)88);
    	  		map.put(25, (char)89);
    	  		map.put(26, (char)90);
    	  		
    	  		List<String> list = Arrays.asList(archive);
    	  		
//    	  		for(int = 0; i<archive.length; i++) {
//    	  			if (archive[i] in dict - do something and continue
//    	  			
//    	  			else {
//    	  				for(int k = i+ 1; k<archive.length(); k++) {
//    	  					do something
//    	  				}
//    	  			}
//    	  		}

    	  		
    	  		
    	  		// hashmap using a for loop from 65-90
    	  		
    	  		
//    	  		ArrayList<String> ret = new ArrayList<String>();
//    	  		
//    	  		List<String> mylist = Arrays.asList(dictionary);
//
//    	  		
//    	  		for (int i = 0; i <archive.length(); i++) {
//    	  			if(mylist.contains(archive.charAt(i))) ret.add(mylist.get(i));
//    	  			for (int k = i +1; k<archive.length(); k++) {
//    	  				if (mylist.contains(archive.substring(i,k))) {
//    	  					ret.add((mylist.get(i).substring(0,k)));
//    	  					i = k+1;
//    	  					continue;
//    	  					}
//    	  				continue; 
//    	  		}	
//    	  		}
//    	  		
//    	  		String ans = "";
//    	  		for(String item :ret ) {
//    	  			ans = ans + Character.toString(map.get(item));
//    	  		}
//		
    	  		
    	  	//	while(! done) {
//    	  			for(int i=0; i<archive.length(); i++) {
//    	  				if(list.contains(Character.toString(archive.charAt(i)))) {
//    	  					ans = ans + map.get(i);
//    	  				}
//    	  				else {
//    	  					boolean done2 = false;
//    	  					int k = 1;
//    	  					while (! done2) {
//    	  						if(list.contains(Character.toString(archive.charAt(i)) + Character.toString(archive.charAt(i+k))     )) {
//    	    	  					ans = ans + map.get(i+k);
//    	    	  					done2 = true;
//    	    	  				}
//    	  						else {
//    	  							k++;
//    	  						}
//    	  					}
//    	  				}
//    	  				
//    	  				
//    	  			}
    	  	//	}
    	  		String code = archive;
    	  		String ans = "";
    	  		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	  		while(code.length() >0 ) {
    	  			for (int i=0; i< dictionary.length; i++) {
        	  			if(code.startsWith(dictionary[i])) {
        	  				ans += alpha.charAt(i);
        	  				code = code.substring(dictionary[i].length());
        	  				
        	  			}

    	  			}
    	  		}
    	  			
    	  		return ans;	
    	  		
    	  		
    	  		
    	  		
    	  		// take archive and loop through from 0 to dict length
    	  		// if it starts 
    	  		}
      
      
      
//      private boolean hasRemaining(String archive, String ans) {
//    	  		
//    	  		return false;
//	}
//
//
//
//	private String startsWith(String strand) {
//    	  	
//    	  
//    	  
//      }
   


}

// archive   "101101"

// dictionary   {"00","10","01","11"}

//  Returns: "BDC"