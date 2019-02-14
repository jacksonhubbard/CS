//public class FullComplete {
//        public TreeNode create(int n) {
//        		
//        		TreeNode root = new TreeNode(2);
//        		
//            	
//        		if (getHeight(root) == n) return root;
//        		
//        		
//        		while (getHeight(root) < n) {
//	        		root.left = createLeft(root, n);
//	        		root.right = createRight(root, n);
//	        		
//	        		
//	        		
//        		}
//        		return root;
//            
//        }
//        
//        
//        public TreeNode createLeft(TreeNode root, int n) {
//    			if (getHeight(root) == n) return root;
//
//        		root.left = new TreeNode(2);
//        		root = root.left;
//        		return createLeft(root.left, n);
//        		
//        }
//        
//        public TreeNode createRight(TreeNode root, int n) {
//			if (getHeight(root) == n) return root;
//
//	    		root.right = new TreeNode(2);
//	    		root = root.right;
//	    		return createLeft(root.right, n);
//    		
//    }
//        
//        
//        public int getHeight(TreeNode node) {
//       	 	if (node == null) return 0;
//       	 	return 1 + Math.max(getHeight(node.left), getHeight(node.right));
//       	}
//    }
//
//
//



public class FullComplete {
	public TreeNode create(int n) {
		if (n < 1 ) return null;
		TreeNode ans = new TreeNode(2, create(n-1), create(n-1));
		return ans;
	}
}