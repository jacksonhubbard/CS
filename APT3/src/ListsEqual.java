public class ListsEqual {
      public int equal (ListNode a1, ListNode a2) {
          
    	  		while (a1 != null && a2 != null) {
    	  			if (a1.info != a2.info) {
    	  				return 0;
    	  			}
    	  			else {
    	  			a1 = a1.next;
    	  			a2 = a2.next;
    	  			}
    	  			
    	  		}
    	  		
    	  		if (a1 == null && a2 == null) {
    	  			return 1;
    	  		}
    	  		
    	  		
    	  		return 0;
    	  

      }
  }


// 5 4 2
// 5 4 2 
