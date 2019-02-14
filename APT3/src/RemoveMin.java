 public class RemoveMin {
      public ListNode remove (ListNode list) {
        
    	  	ListNode first = list;
    	  	int min = first.info;
    	  	
    	  	while (list != null) {
    	  		if (list.info < min) {
    	  			min = list.info;
    	  		}
    	  		list = list.next;
    	  	}
    	  	
    	  	while (first.next != null) {
    	  		if(first.next.info == min) {
    	  			first.next = first.next.next;
    	  		}
    	  		first = first.next;
    	  	}
    	  
	  return first;
      }
  
 }