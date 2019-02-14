import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Internet {
	Map<String, Set<String>> myGraph;
     public int articulationPoints(String[] routers) {
         	
    	 		makeGraph(routers);
    	 		int total = 0;
    	 		for(int k=0; k <routers.length; k++) {
    	 			String vertex = "" + k;
    	 			String start = "0";
    	 			
    	 			if (k==0) start = "1";
    	 			Set<String> set = reachFromSkip(start,vertex);
    	 			if(set.size() != routers.length -1) {
    	 				total +=1;
    	 			}
    	 		}
    	 		return total;
     }


// build a graph 
	private void makeGraph(String[] routers) {
		// TODO Auto-generated method stub
		myGraph = new HashMap<>();
		for(int k=0; k <routers.length; k++) {
 			String vertex = "" + k;
 			String[] adj = routers[k].split(" ");
 			myGraph.putIfAbsent(vertex, new TreeSet<>());
 			for(String s : adj) {
 				myGraph.putIfAbsent(s, new TreeSet<>());
 				myGraph.get(vertex).add(s);
 				myGraph.get(s).add(vertex);
 			}
 			
 			
		}
		
	}
	
	
	// BFS not goig through it
	// gives back set of vertices I can reach from start (almost always 0) skiping the vertex
	// 1 away, 2 away, etc follow every path
	// cant go through the vertex
	private Set<String> reachFromSkip(String start, String vertex) {
		Set<String> visited = new TreeSet<>();
		Stack<String> qu = new Stack<>();
		visited.add(start);
		qu.push(start);
		while (qu.size() > 0){
			String v = qu.pop();
			for(String adj : myGraph.get(v)){
				if (! visited.contains(adj) && ! adj.equals(vertex)) {
					visited.add(adj);
					qu.push(adj);
		}
		}
		}
		return visited;
	}
	
	
	
	public static void main(String[] args) {
		Internet net = new Internet();
		String[] gr = {"2", "2 3", "0 1 3 4", "1 2", "2 5 6","4 6","4 5"};
		System.out.println(net.articulationPoints(gr));
		
	}
  }