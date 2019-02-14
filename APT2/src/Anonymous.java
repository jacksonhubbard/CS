public class Anonymous {
      public int howMany(String[] headlines, String[] messages) {
            int num = 0;
    	  		int counts[] = new int[256];
            for(String s : headlines) {				// how many you have
            	for(char ch : s.toLowerCase().toCharArray()) {
            		if (ch == ' ') continue; 
            		counts[ch] = counts[ch] + 1;
            	}
            }
            
            
            	for(int k =0; k<messages.length; k++){
           
            int	count_new[] = counts.clone();
            	lab1 : for(char ch : messages[k].toLowerCase().toCharArray()) {
            		if (ch == ' ') continue; 
            		if (count_new[ch] <= 0) break lab1;
            		count_new[ch] = counts[ch] - 1;
            		
            	
            		
            		
            }
            
             
            
      }
      
      return num;
  
   }
}