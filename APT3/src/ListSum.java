public class ListSum {
      public int sum(ListNode list, int thresh) {
          
    	  		int sum = 0;
    	  		
    	  		while (list != null ) {
    	  			if (list.info > thresh) {
    	  				sum += list.info;
    	  			}
    	  			list = list.next;
    	  		}
    	  		
    	  		return sum;
      }
  }