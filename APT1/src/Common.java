import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Common {
	public int count (String a, String b) {
		ArrayList<String> word_a = new ArrayList<String>(Arrays.asList(a));
		ArrayList<String> word_b = new ArrayList<String>(Arrays.asList(b));
		int count = 0;
		
		for (int k=0; k<a.length(); k++) {
//			if (word_b.contains(word_a.get(k)) ) {
				count += 1; 
//				word_b.remove(word_b.indexOf(String.valueOf(word_a.get(k))));
//			}
//		}
		
		
		
	
	
		}
		return count; 

	}
}

//		ArrayList<String> matches = new ArrayList<String>();
//		int count = 0;
//		
//		for (int k=0; k<a.length(); k++) {
//			if (Arrays.asList(a).contains(Character.toString(b.charAt(k))) ) {
//				count += 1;
////				if (! matches.contains((Character.toString(b.charAt(k))) )) {
////					count += 1;
////					matches.add(Character.toString(b.charAt(k)));
////				}
//			}
//		}
//	return count;	


	
	
	





//def count(a,b):
//    """
//    return the integer number of characters in common
//    to Strings a and b as described below 
//    compare each letter to second word,then delete it from second
//    """
//    letInA= []
//    letInB=[]
//    count=0
//    for j in range (len(b)):
//        letInB.append(b[j])
//        
//    for i in range(len(a)):
//        if a[i] in letInB:
//            letInB.remove(a[i])
//            count+=1
//    
//    
//    return count   
//        
//if __name__ == '__main__':
//    x=count("horse", "moose")
//    print(x)