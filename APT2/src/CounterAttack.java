public class CounterAttack {
     public int[] analyze(String str, String[] words) {
        
    	 
    	 // how many times words are in str
    	 
    	 
    	 	int[] ans = new int[words.length];
    	 	
    	 	String[] letters = str.split(" ");
    	 	
    	 	for (int k=0; k<words.length; k++) {
    	 		for (int j=0; j<letters.length; j++) {
    	 			if (letters[j].equals(words[k])) {
    	 				ans[k]= ans[k] +1;
    	 			}
    	 		}
    	 	}
    	 
    	 
    	 
    	 
    	 
         return ans;
     }
 }