
public class PrefixCode { 
      public String isOne(String[] words) {
          // fill in body of this function
    	  String ans = "";		
    	  for(int i =0; i<words.length; i ++) {
    		  for (int k = 0; k < words.length; k++) {
    		        if (words[i] != words[k]) {
    		            if (words[k].startsWith(words[i])) {
    		            		ans = "No, ";
    		            		ans += Integer.toString(i);
    		            		return ans;
    		            }
    		            
    		            
    		        }
    		  
    	  }
 //   		  List<String> prefixesList = Arrays.asList("Mon", "Tues", "Wed", "Thurs", "Fri");
 //   		  if(StringUtils.startsWithAny(newStr4, prefixesList.toArray(new String[0])))
    	  	
      }
    	  return "Yes";
   }
      
}