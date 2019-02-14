
/*************************************************************************
 * @author Kevin Wayne
 *
 * Description: A term and its weight.
 * 
 *************************************************************************/

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term> {

	private final String myWord;
	private final double myWeight;

	/**
	 * The constructor for the Term class. Should set the values of word and
	 * weight to the inputs, and throw the exceptions listed below
	 * 
	 * @param word
	 *            The word this term consists of
	 * @param weight
	 *            The weight of this word in the Autocomplete algorithm
	 * @throws NullPointerException
	 *             if word is null
	 * @throws IllegalArgumentException
	 *             if weight is negative
	 */
	public Term(String word, double weight) {
		// TODO: Complete Term constructor
		
		myWord = word;
		myWeight = weight;
		
		
		if (word == null) {
			throw new NullPointerException() ;
		}
		
		if (weight < 0) {
			throw new IllegalArgumentException("negative weight "+weight);
		}
	}
	
	/**
	 * The default sorting of Terms is lexicographical ordering.
	 */
	public int compareTo(Term that) {
		return myWord.compareTo(that.myWord);
	}

	/**
	 * Getter methods, use these in other classes which use Term
	 */
	public String getWord() {
		return myWord;
	}

	public double getWeight() {
		return myWeight;
	}

	public String toString() {
		return String.format("(%2.1f,%s)", myWeight, myWord);
	}
	
	@Override
	public boolean equals(Object o) {
		Term other = (Term) o;
		return this.compareTo(other) == 0;
	}

	/**
	 * A Comparator for comparing Terms using a set number of the letters they
	 * start with. This Comparator may be useful in writing your implementations
	 * of Autocompletors.
	 *
	 */
	public static class PrefixOrder implements Comparator<Term> {
		private final int myPrefixSize;

		public PrefixOrder(int r) {
			this.myPrefixSize = r;
		}

		/**
		 * Compares v and w lexicographically using only their first r letters.
		 * If the first r letters are the same, then v and w should be
		 * considered equal. This method should take O(r) to run, and be
		 * independent of the length of v and w's length. You can access the
		 * Strings to compare using v.word and w.word.
		 * 
		 * @param v/w
		 *            - Two Terms whose words are being compared
		 */
		public int compare(Term v, Term w) {

			int min_size = Math.min(v.myWord.length(), w.myWord.length());
			
			// prefix shorter than both words
			if (min_size >= myPrefixSize) {
				for (int i =0; i< myPrefixSize; i++) {
					if(v.myWord.charAt(i) - w.myWord.charAt(i)  == 0  ) {
						continue;
					}
					else {
						if (v.myWord.charAt(i) - w.myWord.charAt(i)  < 0 ) return -1;
						if (v.myWord.charAt(i) - w.myWord.charAt(i)  > 0 ) return 1;
					}
				}
			}
			
			// one of words is shorter than prefix
			else {
				for (int i =0; i< min_size; i++) {
					if(v.myWord.charAt(i) - w.myWord.charAt(i)  == 0) {
						continue;
					}
					
					else {
						if (v.myWord.charAt(i) - w.myWord.charAt(i)  < 0 ) return -1;
						if (v.myWord.charAt(i) - w.myWord.charAt(i)  > 0 ) return 1;					
						}
				}
				if (v.myWord.length() > min_size) return 1;
				if (w.myWord.length() > min_size) return -1;
				return 0;
				
			}
			return 0;
				
		}
	}

	/**
	 * A Comparator for comparing Terms using only their weights, in descending
	 * order. This Comparator may be useful in writing your implementations of
	 * Autocompletor
	 *
	 */
	public static class ReverseWeightOrder implements Comparator<Term> {
		public int compare(Term v, Term w) {
			double weight_v = v.getWeight();
			double weight_w = w.getWeight();
			
			if ( weight_v < weight_w) return 1;
			if ( weight_v > weight_w) return -1;
			return 0;
		}
	}

	/**
	 * A Comparator for comparing Terms using only their weights, in ascending
	 * order. This Comparator may be useful in writing your implementations of
	 * Autocompletor
	 *
	 */
	public static class WeightOrder implements Comparator<Term> {
		public int compare(Term v, Term w) {
			double weight_v = v.getWeight();
			double weight_w = w.getWeight();
			
			if ( weight_v < weight_w) return -1;
			if ( weight_v > weight_w) return 1;
			return 0;
			
		}
	}
}
