import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class EfficientWordMarkov extends BaseWordMarkov {
	
	private HashMap <WordGram, ArrayList<String>> myMap;
	
	/**
	 * Construct an EfficientWordMarkov object with
	 * the specified order
	 * @param order size of this Markov generator
	 */
	public EfficientWordMarkov(int order) {
		super(order); 
		myMap = new HashMap<WordGram,ArrayList<String>>() ;
	}
	
	
	/**
	 * Default EfficientWordMarkov constructor with an order of 3
	 */
	public EfficientWordMarkov() {
		this(3);
		myMap = new HashMap<WordGram,ArrayList<String>>() ;

	}
	
	/**
	 * Performs the training of the model.
	 * Takes a given Array of words and for each element, 
	 * creates an entry in the HashMap for the word and place 
	 * the word located at the index after the current index
	 * plus the order of the Markov (myOrder)
	 * @param myWords- String[] of all the words from the text 

	 */
	public void setTraining(String text) {
		myMap.clear();
		myWords = text.split("\\s+");
		
		for (int i=0; i<myWords.length - (myOrder-1); i++) {
			WordGram sub = new WordGram(myWords, i, myOrder);
		
		// check to see if sequence is already in HashMap
		if (! myMap.containsKey(sub)) {
			ArrayList<String> val= new ArrayList<String>();
			myMap.put(sub, val);
		}
		// updates value
		if (i<myWords.length-myOrder) {
		String next = myWords[i+myOrder];
		ArrayList<String> newvals = myMap.get(sub);
		newvals.add(next);
		myMap.put(sub, newvals);
	}
		else {
			myMap.get(sub).add(PSEUDO_EOS);
		}
		}
		

		
}
	
	
	/**
	 * Takes a given word and returns the List of the words
	 * that come after it within the text
	 * @param key- the current word
	 * returns the ArrayList<String> of key's value
	 */
	public ArrayList<String> getFollows(WordGram key){
		if(myMap.containsKey(key)) {
			return myMap.get(key);
		}
		throw new NoSuchElementException(key+" not in map");

		
		
	}
	
	
	
}
