

public class ListShift {
	
	public ListNode shift(ListNode start, int key) {
        ListNode junkFirst = new ListNode(0);
        ListNode shifted = junkFirst;
        ListNode list = start;
        
        // if info> key move to shifted
        
        // junkFirst= pointer to first place of what we want to return (first value
        				//  is 0, but points to shifted list so return junkFirst.next)
        // shifted= current Node of shifted list
        // list= current Node of original list 
        
        // only progress list if info < key, otherwise, change next pointer as way to progress
        
        while (list.next != null) {
        	
        		// create Node, change next pointer of list, then add new Node to shifted next field
        		// then progress shifted to Node we just added
	        	if (list.next.info > key) {
	        		ListNode toMove = list.next;
	        		list.next = list.next.next;
	        		shifted.next = toMove;
	        		// shifted = toMove;
	        		shifted = shifted.next;
	        	}
	        	else {
	        		list = list.next;
	        	}
        }
        
        // never checked start
        // if start > key, return start but with its next field as shifted list
        if (start.info > key) {
        	 	shifted.next = start.next;
	        	start.next = junkFirst.next;
	        	return start;      
        }
        
        // if start < key, add start to the next field of shifted
        else {
        		shifted.next = start;
            return junkFirst.next;
        }
    }

}
