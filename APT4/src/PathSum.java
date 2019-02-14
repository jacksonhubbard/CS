// NOT FINISHED

public class PathSum {
        public int hasPath(int target, TreeNode tree){
            if (tree == null) {
            	if (target ==0) return 1;
            	else return 0;
            }
            
            
            
            int subsum = target - tree.info; 
            if (subsum == 0 && (tree.left == null || tree.right == null))
                return 1; 
            if (tree.left != null) 
                hasPath(subsum, tree.left); 
            if (tree.right != null) 
                hasPath(subsum, tree.right); 
            
            return 0; 
            
            
        	
        	
        	
        }
    }