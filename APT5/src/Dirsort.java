import java.util.Arrays;
import java.util.Comparator;

public class Dirsort {
     public String[] sort(String[] dirs) {
          Arrays.sort(dirs, new DirComp());
          return dirs;
     }
     
     
     
     public class DirComp implements Comparator<String> {
    	 
    	 
    	 	@Override
    	 	public int compare(String a, String b) {
    	 		String[] arr = a.split("/");
    	 		String[] brr = b.split("/");
    	 		if (arr.length > brr.length) return 1;
    	 		if (arr.length < brr.length) return -1;
    	 		
    	 		for (int i= 0; i<arr.length; i ++) {
    	 			if(arr[i].compareTo(brr[i]) > 0) return 1;
    	 			if(arr[i].compareTo(brr[i]) < 0) return -1;

    	 		}
    	 		
    	 		return 0;
    	 	}
     }
  }