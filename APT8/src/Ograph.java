//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Queue;
//import java.util.Set;
//
//

// public class Ograph {
//	Map<Integer, ArrayList<Integer>> graphs = new HashMap<>();
//	Set<Integer> nodes = new HashSet<>();
//	
//	
//	// MakeGraph of data
//	// add all key's of Map (nodes) to nodes
//	// sizes- list of all of nodes
//	public int[] components(String[] data) {
//		makeGraphs(data);
//		nodes.addAll(graphs.keySet());
//		
//		List<Integer> sizes = new ArrayList<>();
//		while(nodes.size() != 0)
//			sizes.add(bfs(nodes.toArray(new Integer[0])[0]));
//		
//		Collections.sort(sizes);
//		int[] ret = new int[sizes.size()];
//		for (int i = 0; i < sizes.size(); i++)
//			ret[i] = sizes.get(i);
//
//        return ret;
//    }
//
//	// make a HashMap(Integer, ArrayList<Integer>) of (Node, connections)
//	// for each i-th element, split it by space to get all connections  		
//	private void makeGraphs(String[] data) {
//		for (int i = 0; i < data.length; i++) {
//			graphs.put(i, new ArrayList<Integer>());
//			String[] connections = data[i].split(" ");
//			for (String conn : connections)
//				graphs.get(i).add(Integer.parseInt(conn));
//		}
//	}
//	
//	
//	private int bfs(Integer start) {
//		Set<Integer> visited = new HashSet<>();
//		Queue<Integer> q = new LinkedList<>();
//		
//		q.add(start);
//		visited.add(start);
//		nodes.remove(start);
//		
//		while (!q.isEmpty()) {
//			Integer node = q.poll();
//			for (Integer conn : graphs.get(node)) {
//				if (!visited.contains(conn)) {
//					visited.add(conn);
//					q.add(conn);
//					nodes.remove(conn);
//				}
//			}
//		}
//		
//		return visited.size();
//	}

	import java.util.*;


	public class Ograph {
		Map<String,Set<String>> myGraph;
		Set<String> myVisited;
		
		public int[] components(String[] data) {
			makeGraph(data);								// String, Set<String> map of each node's connections
			myVisited = new TreeSet<>();
			ArrayList<Integer> list = new ArrayList<>();
			for(String v : myGraph.keySet()) {			// for each key of map (each node)
				if (! myVisited.contains(v)) {			// if haven't already visited it, (so essentially only unconnected nodes) 
					list.add(compSize(v));				// add how many connections it has
				}
			}
			int[] ret = new int[list.size()];
			Collections.sort(list);
			// gets list into an Array b/c thats what we have to return
			for(int k=0; k < list.size(); k++) {
				ret[k] = list.get(k);
			}
			Arrays.sort(ret);
			return ret;
		}
		
		private int compSize(String v) {
			Set<String> visited = new TreeSet<>();
			Stack<String> s = new Stack<>();  				// stack- last in, first out
			visited.add(v);
			s.add(v);
			while (s.size() > 0) {
				v = s.pop();
				for(String adj : myGraph.get(v)) {			// getting all of connections of v
					if (! visited.contains(adj)) {			// if haven't visited connected node, add to stack
						s.push(adj);
						visited.add(adj);
					}
				}
			}
			myVisited.addAll(visited);			// add all visited nodes to myVisited
			return visited.size();				// returns how many nodes you've visited 
												// essentially how many connections does v have
		}
		
		
		
		private void makeGraph(String[] data) {
			myGraph = new TreeMap<>();
			for(int k=0; k < data.length; k++) {
				String s = data[k];   						// s = "1 2"
				String v = ""+k;		 						// v = index = 0
				String[] adj = s.split(" ");  				// ["1", "2"] 
				//System.out.print(v+" : ");print(adj);
				for(String a : adj) {
					myGraph.putIfAbsent(v, new TreeSet<>()); // for node 0, add connections 1 and 2
					myGraph.putIfAbsent(a, new TreeSet<>()); // for node 1 and 2 add connection 
					myGraph.get(v).add(a);
					myGraph.get(a).add(v);
				}
			}
			//System.out.println(myGraph);
		}
}