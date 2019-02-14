import java.util.Arrays;

public class HashTaggery {
      public String maxTag(String[] tags, String[] messages) {
//          hashtags = {"#duke", "#compsci", "#fun", "hashtag", "#hash", "#tag"}
    	  
//          messages = {"We are @duke and #duke #compsci is #hashtag fun!",
//                  "We are #duke. We have all the #fun. We #hash and call #hashCode.",
//                  "#hash #tag and hashcodes are part of #compsci",
//                  "duke compsci fun is predicated on hashtaggery and #tags"}
    	  
// 			given a list of hashtags, and a list of messages (posts, tweets, etc.), you 
//    	  should complete method maxTag to determine if 75% or more of the messages are 
//	    	  covered by one (or more) of the hashtags    	  
    	  
    	  		int count = 0;
    	  
    	  		for (String message : messages) {
    	  			if (tagIn(message, tags)) {
    	  				count++;
    	  			}
    	  		}
    	  		
    	  		if (count*1.0/messages.length >= 0.75) {
    	  			return "tagged";
    	  		}
    	  		
    	  		return "missed";
      }
    	  		
    	  		
    	  	public boolean tagIn(String message, String[] tags) {
    	  			String[] words = message.split(" ");
    	  			for (int i=0; i<words.length; i++) {
    	  				if (words[i].charAt(0) == '#') {
    	  					if (Arrays.asList(tags).contains(words[i])) {
    	  						return true;
    	  					}
    	  				}
    	  			}
    	  			return false;
    	  		
    	  	}
    	  		
    	  
      }
 