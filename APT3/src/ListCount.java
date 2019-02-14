public class ListCount {
      public int count (ListNode list) {
    	  		
    	  		int t = 0; 
    	  		while (list != null ) {
    	  			t += 1;
    	  			list = list.next;
    	  			
    	  		}
    	  
    	  		return t;
      }
  }