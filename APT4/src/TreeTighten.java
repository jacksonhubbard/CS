public class TreeTighten {
        public TreeNode tighten(TreeNode t) {
            if (t == null) return null;
            if (t.right == null && t.left == null) {
            		t.left = tighten(t.left);
            		t.right = tighten(t.right);
            		return t;
            }
            
            if (t.left != null && t.right == null) {
            		return tighten(t.left);
            }
            
            if (t.right != null && t.left == null) {
            		return tighten(t.right);
            }
            
            t.left = tighten(t.left);
            t.right = tighten(t.right);
            
            return t;
            
           
        }
    }