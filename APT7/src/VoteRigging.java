import java.util.Arrays;
import java.util.Collections;

public class VoteRigging {
      public int minimumVotes(int[] votes) {
          // fill in code here
    	  		if(votes.length == 0) return 0;
    	  		if(votes.length == 1) return 0;

    	  		int me = votes[0];
    	  		int stolen = 0;
    	  		int[] them = Arrays.copyOfRange(votes, 1, votes.length);
    	  		Arrays.sort(them);
    	  		int max = them[them.length - 1];
    	  		
    	  		
    	  		while(me <=  them[them.length - 1]) {
    	  			them[them.length -1] -= 1;
    	  			me +=1;
    	  			stolen += 1;
    	  			Arrays.sort(them);
    	  		}; 
    	  		
    	  		return stolen;
    	  
      }
   }