
// want to return # nodes w/ info within range low, high
public class TreeSome {
	public int count(TreeNode t, int low, int high) {
		if (t == null) return 0;
		int count = 0;
		if (low <= t.info && t.info <= high) count = 1;
		
		return count + count(t.left,low,high) + count(t.right,low,high);
	}
}