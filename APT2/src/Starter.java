import java.util.HashSet;
import java.util.Set;

public class Starter {
     public int begins(String[] words, String first) {
         int count = 0;
         Set<String> matches = new HashSet<String>();
         
    	 	for (String word :words) {
    	 		if (Character.toString(word.charAt(0)).equals(first)) {
    	 			if (! matches.contains(word)) {
    	 				count ++;
    	 				matches.add(word);
    	 			}
    	 		}
    	 	}
    	 
    	 
    	 
         return count;
     }
 }