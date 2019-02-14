
public class LinkStrand implements IDnaStrand{
	
	private class Node {
		String info;
		Node next;
		public Node(String s) {
			info = s;
			next = null;
		}
	}
	
	private Node myFirst;
	private Node myLast;
	private long mySize;
	private int myAppends;
	
	private Node myCurrent;
	private int myIndex;
	private int myLocalIndex;
	
	
	/*
	 * constructs LinkStrand object with an empty String as the 
	 * parameter for the default constructor
	 */
	public LinkStrand() {
		this("");
	}
	/*
	 * constructs LinkStrand object with the given String parameter
	 * @param s- String that the LinkStrand is initialized with
	 */
	public LinkStrand(String s) {
		initialize(s);
	}
	
	
	@Override
	public long size() {
		return mySize;
	}
	
	
	/*
	 * initializes a given String source parameter to 
	 * a linked list and initializes instance variables 
	 * myAppends to 0 and mySize to the length of parameter
	 * @param source- source of String about to be initialized
	 */
	@Override
	public void initialize(String source) {
		myFirst = new Node(source);
		myLast = myFirst;
		myAppends = 0;
		mySize = source.length();
		
		myCurrent = myFirst;
		myIndex = 0;
		myLocalIndex = 0;
	}

	
	/*
	 * Returns this object as a LinkStrand 
	 * @param source is data from which object constructed
	 * @return a LinkStrand whose .toString() method will be source
	 */
	@Override
	public IDnaStrand getInstance(String source) {
		return new LinkStrand(source);
	}

	
	/*
	 * Returns LinkStrand with one new node and updates instance
	 * variables so that myFirst remains the same, myLast points to
	 * the new node added, mySize is incremented by the length of 
	 * the new node, and myAppends is incremented by one. 
	 * @param dna- dna strand to be appended
	 * @return LinkStrand with new node 
	 */
	@Override
	public IDnaStrand append(String dna) {
		myLast.next = new Node(dna);
		myLast = myLast.next;
		mySize += dna.length();
		myAppends +=1;
		return this;
	}
	
	/*
	 * returns new LinkStrand object that is reverse of LinkStrand 
	 * on which it is called without altering existing LinkStrand object
	 * @returns new LinkStrand object that is reverse of LinkStrand 
	 * object on which it is called
	 */
	@Override
	public IDnaStrand reverse() {
		Node current = myFirst;
		Node reversed = new Node("");
		
		while (current.next != null) {
			String rev = current.info;
			StringBuilder toRev = new StringBuilder(rev);
			toRev.reverse();
			reversed.info = toRev.toString();
			Node previous = new Node("");
			previous.next = reversed;
			reversed = previous;
			current = current.next;
			
			
		}
		String rev = current.info;
		StringBuilder toRev = new StringBuilder(rev);
		toRev.reverse();
		reversed.info = toRev.toString();
		LinkStrand copy = new LinkStrand(reversed.info);
		while (reversed.next != null) {
			reversed = reversed.next;
			copy.append(reversed.info);
		}
		return copy;
		
		
	}
	
	/*
	 * return number of appends made
	 * @return int myAppends which is number of appends made
	 */
	@Override
	public int getAppendCount() {
		return myAppends;
	}

	
	/*
	 * Returns the character at a specified index in the 
	 * LinkStrand
	 * @param index- desired index
	 * @return character at specified index 
	 */
	@Override
	public char charAt(int index) {
		
		if (index < myIndex) {
			myIndex = 0;
			myLocalIndex = 0;
			myCurrent = myFirst;
			}
	
			if (index < 0 || index >= mySize) {
				throw new IndexOutOfBoundsException();
			}	
			
			// temporary vars to do comparision with
			Node current = myCurrent;
			int num = myIndex;
			int localIndex = myLocalIndex;
			
			
			while (num != index) {
				localIndex = localIndex +1;
				num = num +1;
				
				
				if (localIndex >= current.info.length()) {
					localIndex = 0;
					current = current.next;
				}
			}
			
			myCurrent = current;
			myIndex = num;
			myLocalIndex = localIndex;
			
			char ans = current.info.charAt(myLocalIndex);
			return ans;	
	}
	
	
	/*
	 * converts LinkStrand to a String and returns it
	 * @returns String of the LinkStrand
	 */
	public String toString() {
		
		StringBuilder ret = new StringBuilder();
		Node current = myFirst;
		while(current.next != null) {
			ret.append(current.info);
			current = current.next;
		}
		ret.append(current.info);
		return ret.toString();
		

	}
	
}
