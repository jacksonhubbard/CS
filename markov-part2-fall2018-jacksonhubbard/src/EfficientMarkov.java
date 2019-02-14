import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.NoSuchElementException;

//  The new class inherits the protected instance variables and methods of 
//  the parent class BaseMarkov


public class EfficientMarkov extends BaseMarkov {
	
	
	private HashMap <String, ArrayList<String>> myMap;
	
	
	/**
	 * Construct an EfficientMarkov object with
	 * the specified order
	 * @param order size of this markov generator
	 */
	public EfficientMarkov(int order) {
		super(order);
		myMap = new HashMap<String,ArrayList<String>>() ;
	}
	
	/**
	 * Default EfficientMarkov constructor with an order of 3
	 */
	public EfficientMarkov() {
		this(3);
		myMap = new HashMap<String,ArrayList<String>>() ;
	}
	
	
	/**
	 * Takes a given letter and returns the List of the letters
	 * that come after it within the text
	 * @param key- the current letter
	 * returns the ArrayList<String> of key's value
	 */
	@Override
	public ArrayList<String> getFollows(String key){
		if(myMap.get(key)!= null) {
			return myMap.get(key);
		}
		throw new NoSuchElementException(key+" not in map");

		
		
	}
	
	
	
	
	/**
	 * Performs the training of the model. Loops the text and add each
	 * myOrder sequence to the HashMap. This HashMap stores all of the 
	 * 3 letter sequences in the text. Then gets the next character after
	 * each sequence and assign it to that key's value
	 * @param text- String of the text we are using
	 */
	@Override
	public void setTraining(String text) {
		myText = text; 
		
		myMap.clear();
		
		// loops through text and adds each 3 letter seq to map as (seq, next letter)
		
		for (int i=0; i<myText.length()-(myOrder-1); i++) {
			String sub = myText.substring(i, i+myOrder);
			
			// check to see if sequence is already in HashMap
			if (! myMap.containsKey(sub)) {
				ArrayList<String> val= new ArrayList<String>();
				myMap.put(sub, val);
			}
			// updates value
			if (i<text.length()-myOrder) {
			char next = text.charAt(i+myOrder);
			ArrayList<String> newvals = myMap.get(sub);
			newvals.add(Character.toString(next));
			myMap.put(sub, newvals);
			
			}
			else {
				myMap.get(sub).add(PSEUDO_EOS);
			}
		}
	}
	
	
	
}
