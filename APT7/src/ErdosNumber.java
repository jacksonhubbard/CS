import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ErdosNumber {
	TreeMap<String, Set<String>> myGraph;
    	TreeMap<String, Integer> myDistance;
    	
    	
    public String[] calculateNumbers(String[] pubs) {
    			makeGraph(pubs);
    			ArrayList<String> list = new ArrayList<>();
    			bfsErdos();
    			
    			for(String s : myGraph.keySet()) {
    				if(myDistance.containsKey(s)) {
    					s = s+ " " + myDistance.get(s);
    				}
    				list.add(s);
    			}
    			
    			return list.toArray(new String[0]);
    	
    }

// no paramter for bfsErdos
	private Set<String> bfsErdos(String start) {
		// TODO Auto-generated method stub
		Set<String> visited = new TreeSet<>();
		Queue<String> qu = new LinkedList<>();
		visited.add(start);
		qu.add(start);
		while (qu.size() > 0){
	  		String v = qu.remove();
	  		for(String adj : myGraph.getAdjacent(v)){
	    			if (! visited.contains(adj)) {
	        			visited.add(adj);
	        			qu.add(adj);
	    			}
	  		}
	}
		return visited;

	}


	private void makeGraph(String[] pubs) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i<pubs.length; i++) {
			
			String[] names = pubs[i].split(" ");
			
			for (int k =0; k<names.length; k++) {
				ArrayList<String> coauthors = new ArrayList<String>();
				
				for(int l = 0; l<names.length; l++) {
					if(! names[l].equals(names[k])) coauthors.add(names[l]);
				}
		        		Set<String> setCoAuthors = new TreeSet<String>(coauthors);
		        				        		
					myGraph.putIfAbsent(names[k], new TreeSet<>());
					myGraph.get(names[k]).addAll(setCoAuthors);
					
			}
			
			
		}
	}
	
	
	
	
	
	

		
		
		
	}
