import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CodonProfilerTest {

	private IDnaStrand myTestStrand;
	private CodonProfiler myProfiler;
	
	public IDnaStrand getEmptyStrand() {
		return new StringStrand();
	}
	
	@Before
	public void setUp() {
		String str = "cgacgacgatagtagtagtagcgacgacgacga";
		myTestStrand = getEmptyStrand();
		myTestStrand.initialize(str);
		myProfiler = new CodonProfiler();
	}
	
	@Test
	public void testNone() {
		String[] codons = {"aaa", "ttt", "gac", "gat"};
		int[] expected = {0,0,0,0};
		int[] counts = myProfiler.getCodonProfile(myTestStrand, codons);
		assertArrayEquals(expected,counts);
	}
	@Test
	public void testMulti() {
		String[] codons = {"cga", "gat","tag"};
		int[] expected = {7,0,4};
		int[] counts = myProfiler.getCodonProfile(myTestStrand, codons);
		assertArrayEquals(expected,counts);
	}

}
