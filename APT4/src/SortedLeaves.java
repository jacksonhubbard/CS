import java.util.ArrayList;
import java.util.Arrays;

public class SortedLeaves {
	ArrayList<String> myList = new ArrayList<>();
	

        public String[] values(TreeNode tree) {
            if (tree == null) return new String[0];
            if(tree.left == null && tree.right == null) {
            		myList.add(Character.toString ((char) tree.info));
            		

            }
        	
            	values(tree.left);
        		values(tree.right);
        	
        	
        		
            String[] ans= myList.toArray(new String[0]);
            Arrays.sort(ans);
            
            return ans;
        }
    }