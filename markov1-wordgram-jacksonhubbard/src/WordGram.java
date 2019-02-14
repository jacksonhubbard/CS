
/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author Jackson Hubbard
 *
 */

public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * This WordGram constructor initializes myWords and updates it by looping through the 
	 * String[]. It then sets the instance variable myWords = null and myHash = 0. 
	 * @param source- initial array of words to use
	 * @param start- starting index to use
	 * @param size - how many strings to store
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		int counter = 0;
		for(int dex = start; dex<start + size; dex++) {
			myWords[counter]= source[dex];
			counter+=1;
		}
		myToString = null;
		myHash = 0;
		
		
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * length finds the length of the instance variable myWords, which is a String array of all
	 * of the words
	 * @return the length of the string[] myWords
	 */
	public int length() {
		return myWords.length;
	}

	/**
	 * equals checks to see if two wordGrams are equal
	 * does this by first checking to see if they are both Wordgram objects and then comparing
	 * each word of the two Wordgram objects
	 * @return boolean that represents whether or not they are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		WordGram wg = (WordGram) o;
		
		if(toString().equals(wg.toString())) {
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * hashCode takes the String of Wordgrams and returns its HashCode
	 * only executed if hashCode has not already been set
	 * @returns hash value of the wordgram
	 */	
	@Override
	public int hashCode(){
		// TODO: complete this method
		if (myHash == 0) {
		myHash = toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * shiftAdd shifts the Wordgram by removing the first element and inserting parameter last
	 * in as the last element
	 * @param last is last String of returned WordGram
	 * @return returns new Wordgram object wg that is shifted as specified
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);		
		for(int i = 1; i<myWords.length; i++) {
			wg.myWords[i-1] = wg.myWords[i];
		}
		wg.myWords[length()-1] = last;
		return wg;
	}

	@Override
	/**
	 * Create toString returns one String of all Wordgram words joined by a space
	 * @return returns a String of all of the wordgram words
	 */
	public String toString(){
		// TODO: Complete this method
		if(myToString == null) {
		myToString = String.join(" ", myWords);
		}
		return myToString;
	}
}
