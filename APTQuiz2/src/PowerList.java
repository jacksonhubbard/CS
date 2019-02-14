 public class PowerList {
      public ListNode create(int n) {
    	  	  
          if (n<2) return null;
          
          
          ListNode ans = new ListNode(1);
          ListNode first = ans;
          
          
          
          int i = 1;
          
          while (Math.pow(2, i)< n) {
        	  	Double next2 = Math.pow(2, i);
        	  	int next = next2.intValue();
        	  	ans.next = new ListNode(next ); 
        	  	ans = ans.next; 
        	  	i ++;
          }
	  
          
          return first;
      }
  }