import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SimpleWordGame {
      public int points(String[] player, String[] dictionary) {
          
    	  		int score= 0;
    	  		
    	  		Set<String> answers = new HashSet<String>(Arrays.asList(player));
    	  		
    	  		String[] unique = answers.toArray(new String[0]);
    	  		
    	  		for (int k= 0; k<unique.length; k++) {
    	  			String word = unique[k];
    	  			if (Arrays.asList(dictionary).contains(word)) {
    	  				score += word.length()*word.length();
    	  			}
    	  		}
    	  		return score;
      }
  }