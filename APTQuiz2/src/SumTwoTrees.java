//
//    public class SumTwoTrees {
//    		TreeNode node;
//        public TreeNode add(TreeNode a, TreeNode b) {
//        		int aAdd;
//        		int bAdd;
//        		
//        		if (a == null) {
//        			 aAdd = 0;
//        		}
//        		else {
//        			 aAdd = a.info;
//        		}
//        		
//        		if (b == null) {
//        			 bAdd = 0;
//        		}
//        		
//        		else {
//        			 bAdd = b.info;
//        		}
//        		
//			int sum = aAdd + bAdd;
//            
//            node = new TreeNode(sum);
//        		
//            if (a.left == null && a.right == null && b.left == null && b.right==null) return node;
//            
//          
//            
//            add(a.left, b.left);
//            add(a.right, b.right);
//       
//            return node;
//        	
//        	
//        }
//    }



public class SumTwoTrees {
	public TreeNode add(TreeNode a, TreeNode b) {
		if (a == null && b == null) return null;
		if (a != null && b == null) return a;
		if (a == null && b != null) return b;
		
		int sum = a.info + b.info;
		TreeNode ans = new TreeNode(sum, add(a.left, b.left), add(a.right, b.right));
		return ans;
	}
}