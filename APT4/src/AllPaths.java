import java.util.ArrayList;
import java.util.Collections;

public class AllPaths {
		ArrayList<String> myList = new ArrayList<>();
		
        public String[] paths(TreeNode root) {
            if (root != null) {
            	doPaths(root, "");
            }
        		
            Collections.sort(myList);
            return myList.toArray(new String[0]);
        	
        }
        
        
        private void doPaths (TreeNode root, String path) {
        		if (root == null) return;
        		if (root.left == null && root.right == null) {
        			path = path + root.info;
        			myList.add(path);
        			return;
        		}
        	
        	path = path + root.info + "->";
        	doPaths(root.left, path);
        	doPaths(root.right, path);

        }
    }