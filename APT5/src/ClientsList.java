import java.util.Arrays;
import java.util.Comparator;

public class ClientsList {
//		class comparePerson implements Comparable<String> {
//			public int compare(String a, String b) {
//				
//			}
//		}
 	class Person implements Comparable<Person> {
    			String first;
    			String last;
    			public Person(String s) {
    				if(s.indexOf(",") <0){
    					first = s.split(" ")[0];
    					last = s.split(" ")[1];
    				}
    				else {
    				int x = s.indexOf(",");
    				String s2 = s.subSequence(0, x) + s.substring(x+1);
    				first = s2.split(" ")[1];
				last = s2.split(" ")[0];
    				}
    			}
    			public String getLast(){
    				return last;
    			}
    			public String getFirst(){
    				return first;
    			}
    			

				@Override
				public int compareTo(Person o) {
					int ldiff = last.compareTo(o.last);
					if (ldiff !=0) return ldiff;
					return first.compareTo(o.first);
				}
    			
	
    			
    		}
	
// 	class ComparePerson implements Comparator<Person>{
//		public int compare(Person p, Person o) {
//			return p.compareTo(o);
//		}
//
//		}
	
	
       public String[] dataCleanup(String[] names) {
    	   		Person[] ans = new Person[names.length];
    	   		for (int i=0; i<names.length; i++) {
    	   			
    	   			String first = new Person(names[i]).getFirst();
    	   			String last = new Person(names[i]).getLast();
    	   			String name = first+ " " +last;
    	   			
    	   			ans[i] = new Person(first + " " +last);
    	   		}
    	   		
    	   		Arrays.sort(ans, Comparator.comparing(Person::getLast).thenComparing(Person::getFirst));
    	   		
    	   		String[] ans2 = new String[names.length];

    	   		for (int i=0; i< ans.length; i++) {
    	   			ans2[i] = ans[i].getFirst() + " " + ans[i].getLast();
    	   		}
    	   		return ans2;
    	   	
    	   
    	   

       }
   }