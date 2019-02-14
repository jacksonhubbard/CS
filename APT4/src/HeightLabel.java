
public class HeightLabel {
        public TreeNode rewire(TreeNode t) {
            if (t == null) return null;
            t.info = getHeight(t);
            rewire(t.left);
            rewire(t.right);
            return t;
            
           
            
        }
        
        
        public int getHeight(TreeNode node) {
        	 if (node == null) return 0;
        	 return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        	}
    }