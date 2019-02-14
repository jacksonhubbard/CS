import java.util.ArrayList;

public class StringCuts {
     public String[] filter(String[] list, int minLength) {
         // replace this with your code
    	 
    	 
    	 	ArrayList<String> ans = new ArrayList<String>();
    	 	
    	 	for (int i=0; i <list.length; i++) {
    	 		String word = list[i];
    	 		
    	 		if (word.length() >= minLength) {
    	 			if (! ans.contains(word)) {
    	 				ans.add(word);
    	 			}
    	 		}
    	 	}
    	 	
    	 	String[] ans2 = ans.toArray(new String[0]);
    	 	
         return ans2;
     }
 }