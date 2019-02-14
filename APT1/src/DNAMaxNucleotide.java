
public class DNAMaxNucleotide {
      public String max(String[] strands, String nuc) {
          
            int max= 0;
            String max_word=""; 
            char match= nuc.charAt(0); 
            
            for(String strand : strands) {
            	int count = 0;
            for(int k=0; k<strand.length(); k++) {
            	if (strand.charAt(k)== match) {
            		count += 1;
            }
            }
            if (count== max) {
            	if(strand.length()>max_word.length() && count != 0) {
            		max_word= strand;
            }
            }
            if (count> max) {
            	max= count;
            	max_word= strand; 
            }
            }
            return max_word;
            
            
            
            
            
            
            
      }
   }