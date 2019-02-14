import java.util.*;

public class FindPath {
	ArrayList<String> paths = new ArrayList<>();
	
	// returns shortest path of 0's and 1's to a given value
	public String path(TreeNode tree, int target) {
		doWork(tree,target,"");
		Collections.sort(paths);  // sort alphabetically
		Collections.sort(paths, Comparator.comparing(String::length));  // sort by length
		if (paths.size() == 0) return "nopath";
		return paths.get(0);
	}
	
	// makes the path to the target value
	public void doWork(TreeNode t, int target, String path) {
		if (t == null) return;
		if (t.info == target) {
			paths.add(path);
		}
		doWork(t.left,target,path+'0');
		doWork(t.right,target,path+'1');
	}
	
	
}