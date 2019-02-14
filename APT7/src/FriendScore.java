import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FriendScore {
		Map<Integer, Set<Integer>> myGraph;

		// makeGraph of friends 
		// for each person in the map, get their set of 2friends + friends
		// find max size
      public int highestScore(String[] friends) {
    	  		makeGraph(friends);
    	  		int max =0;
    	  		for(int k =0; k<friends.length; k++) {
    	  			Set<Integer> set = allFriends(k);
    	  			max = Math.max(set.size(), max);
    	  		}
    	  		return max;
      }

      // make graph of each person's one friends
	private void makeGraph(String[] friends) {
		myGraph = new HashMap<>();
		
		for(int k= 0; k<friends.length; k++) {
			String[] adj = friends[k].split("");
			myGraph.putIfAbsent(k, new TreeSet<>());

 			for(int l = 0; l<adj.length; l++) {
 				if(l != k) {
 					if(adj[l].equals("Y")) {
 					myGraph.get(k).add(l);
 				}
 				}	
 			}
		}
	}
	// allfriends- returns list of all my friends (2 friends + friends) 
	// for each of my friends, add all their friends to my set of friends, then remove myself
	private Set<Integer> allFriends(int k) {
		Set<Integer> friends = new HashSet<>();
		friends.addAll(myGraph.get(k));
		
		for (int friend : myGraph.get(k))
			friends.addAll(myGraph.get(friend));
		
		friends.remove(k);
		return friends;
	
	}
		
	
	public static void main(String[] args) {
		FriendScore f = new FriendScore();
		String[] gr = {"NNN",
				 "NNN",
		 "NNN"};
		System.out.println(f.highestScore(gr));
		
	}
   }









