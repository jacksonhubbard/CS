import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class DonorStats {
      public String[] calculate(String[] donations) {
     
    	  
  	 	HashMap<String, String> hashMap= new HashMap<String, String>();
  	 	
  	 	for (String donat : donations) {
  	 	
  	 		
  	 		String[] info = donat.split(":");
  	 		
  	 		String name = info[0];
  	 		String money = info[1] + ",";
  	 
  	 		if (! hashMap.containsKey(name)) {
	 			hashMap.put(name, money);
	 		}
	 		
	 		else {
	 			hashMap.put(name, hashMap.get(name)+ money);
	 		} 
  	 		
  	 	}
  	 
  	 	ArrayList<String> ans = new ArrayList<String>();	

  	 	for (Entry<String, String> entry : hashMap.entrySet()) {
  	 		String[] values = entry.getValue().split(",");
  	 		
  	 		int tot = values.length;
  	 		int sum = 0;
  	 		
  	 		for (int i=0; i<tot; i++) {
  	 			sum += Integer.parseInt(String.valueOf(values[i]));
  	 		}
  	 		
  	 		ans.add(entry.getKey() + ":" + tot +":"+sum);
  	 	}
  	 	
  	 	String[] ans3 = ans.toArray(new String[0]);
          return ans3;
      }
  }
 
