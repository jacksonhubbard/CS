import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class MedalTable {
   public String[] generate(String[] results) {
	   Map<String, Medals> map = new HashMap<>();
	   
	   for(String s : results ) {
		   String[] data = s.split(" ");
		   for (int k = 0; k <3; k++) {
			   map.putIfAbsent(data[k], new Medals(data[k]));
			   
		   }
		   
		   map.get(data[0].gold +=1);
		   map.get(data[1].silver +=1);
		   map.get(data[2].bronze +=1);

		 
	   }
	   
	   ArrayList<Medals> list = new ArrayList<>(map.values());
	   list.sort(Comparator.comparing(Medals :: getCountry));
	   list.sort(Collections.reverseOrder(Comparator.comparing(Medals :: getBronze)));
	   list.sort(Collections.reverseOrder(Comparator.comparing(Medals :: getSilver)));
	   list.sort(Collections.reverseOrder(Comparator.comparing(Medals :: getGold)));
	   
	   
	   
   }
   
   
   private class Medals {
	   int gold;
	   int silver;
	   int bronze;
	   int country;
	   
	   public int getBronze() {
		   return bronze;
	   }
	   
	   public int getSilver() {
		   return silver;
	   }
	   
	   public int getGold() {
		   return gold;
	   }
	   
	   public int getCountry() {
		   return country;
	   }
	   
	   
	   public Medals (String s) {
		  int[] medals = s.split(" ");
		  
	   }
	   
	   
   }
   
   
   
   
 }