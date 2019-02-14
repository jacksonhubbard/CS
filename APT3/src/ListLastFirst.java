public class ListLastFirst {
      public ListNode move(ListNode list) {
 	  
    	  			ListNode first = list;		// first = 1, 2
    	  			ListNode change = list; 
    	  			
    	  			ListNode ans = list.next;	// ans = 2, 3
    	  			
    	  			while (change.next != null) {
    	  				change = change.next;
    	  			}
    	  			ListNode last = change;
    	  			
    	  			
    	  			
    	  			while (ans.next != null) {
    	  				ans = ans.next;
    	  				if (ans.next == last) {
    	  					ans.next = null;
    	  				}
    	  			}
    	  			
    	  			
    	  			ListNode ans2 = new ListNode(last.info, first);
    	  			
    	  			return ans2;
      }
  }


