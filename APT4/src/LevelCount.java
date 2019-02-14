public class LevelCount {
        public int count(TreeNode t, int level) {
            if (level == 0) return 1;
            
            for (int i=0; i<level; i++) {
            		t = t.left;
            		
            	}
            return 0;
        }
    }