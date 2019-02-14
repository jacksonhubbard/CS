import org.junit.Test;
import org.junit.*;
import java.util.*;

import static org.junit.Assert.*;

public class WordGramTester {

	private WordGram[] myGrams;

	@Before
	public void setUp(){
		String str = "aa bb cc aa bb cc aa bb cc aa bb dd ee ff gg hh ii jj";
		String[] array = str.split("\\s+");
		myGrams= new WordGram[array.length-2];
		for(int k=0; k < array.length-2; k++){
			myGrams[k] = new WordGram(array,k,3);
		}
	}

	@Test
	public void testHashEquals(){
		assertEquals("hash fail on equals 0,3",myGrams[0].hashCode(),myGrams[3].hashCode());
		assertEquals("hash fail on equals 0,6",myGrams[0].hashCode(),myGrams[6].hashCode());
		assertEquals("hash fail on equals 1,4",myGrams[1].hashCode(),myGrams[4].hashCode());
		assertEquals("hash fail on equals 2,8",myGrams[2].hashCode(),myGrams[8].hashCode());
		assertEquals("hash fail on equals 2,5",myGrams[2].hashCode(),myGrams[5].hashCode());
	}

	@Test
	public void testEquals(){

		assertTrue("eq fail on 0,3",myGrams[0].equals(myGrams[3]));
		assertTrue("eq fail on 0,6",myGrams[0].equals(myGrams[6]));
		assertTrue("eq fail on 1,4",myGrams[1].equals(myGrams[4]));
		assertTrue("eq fail on 2,5",myGrams[2].equals(myGrams[5]));
		assertTrue("eq fail on 2,8",myGrams[2].equals(myGrams[8]));
		assertFalse("eq fail on 0,2",myGrams[0].equals(myGrams[2]));
		assertFalse("eq fail on 0,4",myGrams[0].equals(myGrams[2]));
		assertFalse("eq fail on 2,3",myGrams[2].equals(myGrams[3]));
		assertFalse("eq fail no 2,6",myGrams[2].equals(myGrams[6]));
		assertFalse("eq fail no 7,8",myGrams[7].equals(myGrams[8]));
	}

	@Test
	public void testHash(){
		Set<Integer> set = new HashSet<Integer>();
		for(WordGram w : myGrams) {
			set.add(w.hashCode());
		}

		assertTrue("hash code test", set.size() > 9);
	}
	
	
	@Test
	public void testShift() {
		String[] words = {"apple", "zebra", "mongoose", "hat","cat"};
		WordGram a = new WordGram(words,0,4);
		WordGram b = new WordGram(words,1,4);
		String before = a.toString();
		WordGram as = a.shiftAdd("cat");
		String after = a.toString();
		assertEquals("shift add",as.equals(b),true);
		assertEquals("shift add length",as.length() == a.length(),true);
		assertEquals("before after shift",before.equals(after),true);
	}

}
