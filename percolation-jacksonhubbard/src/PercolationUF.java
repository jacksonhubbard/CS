import java.util.Arrays;

public class PercolationUF implements IPercolate {
	protected int[][] myGrid;
	protected int myOpenCount;
	
	protected IUnionFind myFinder;
	private final int VTOP;
	private final int VBOTTOM;

	
	
	public PercolationUF(int size, IUnionFind finder)  {
		myGrid = new int[size][size];
		for (int[] row:myGrid) {
			Arrays.fill(row, BLOCKED);
		}
		finder.initialize(size*size +2);
		myFinder = finder;
		
		
		VTOP = size*size;
		VBOTTOM = size*size+1;
	}


	@Override
	public void open(int row, int col) {
		// TODO Auto-generated method stub
		// Method open throws an Exception when needed, 
		// checks to be sure the cell is not already open, 
		// and then marks the cell as open and connects with open neighbors as described below.
		// || row > myGrid.length || col > myGrid.length
		
		
		if (! inBounds(row,col) ) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		
		if(myGrid[row][col] != BLOCKED) return;
		
		
		int length = myGrid.length;
		
		
		myGrid[row][col] = OPEN;
		myOpenCount ++;
		
		int cell1 = row*length + col;
		
        if (row == 0) {
        		myFinder.union(cell1,  VTOP);
        }
        
        if(row == myGrid.length -1) {
        		myFinder.union(cell1,  VBOTTOM);
        }
        
        if(inBounds(row-1,col) && isOpen(row-1, col) ) {
        			myFinder.union(cell1,  (row-1)*length + col);
        }
		
        if(inBounds(row+1,col) && isOpen(row+1, col) ) {
			myFinder.union(cell1,  (row+1)*length + col);
        }
        
        if(inBounds(row,col+1) && isOpen(row, col+1) ) {
			myFinder.union(cell1,  (row)*length + col+1);
        }
        
        if(inBounds(row,col-1) && isOpen(row, col-1) ) {
			myFinder.union(cell1,  (row)*length + col-1);
        }
                
  }
			
	@Override
	public boolean isOpen(int row, int col) {
		// TODO Auto-generated method stub
		// Method isOpen throws an Exception when needed and 
		// otherwise simply returns the appropriate myGrid value.
		
		if (! inBounds(row, col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		
		
		return myGrid[row][col] != BLOCKED;
	}


	@Override
	public boolean isFull(int row, int col) {
		// TODO Auto-generated method stub
		// Method isFull throws an Exception when needed and 
		// otherwise checks if the (row,col) cell is connected to VTOP.
		
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		
		int cell1 = row*myGrid.length + col;

		return myFinder.connected(cell1, VTOP);
	}


	@Override
	public boolean percolates() {
		// TODO Auto-generated method stub
		// Method percolates checks to see if VTOP is connected to VBOTTOM.

		return myFinder.connected(VTOP,VBOTTOM);
	}


	@Override
	public int numberOfOpenSites() {
		// TODO Auto-generated method stub
		// Method numberOfOpenSites simply returns the value of the appropriate instance variable
		return myOpenCount;
	}
	
//	Create a constructor PercolationUF(int size, IUnionFind finder) that 
//	will construct and initialize the NxN grid stored in the instance variable 
//	myGrid (where N is given by the size parameter). The constructor should 
//	initialize the IUnionFind object of size NxN + 2 by calling finder.initialize 
//	appropriately and then storing this object in the appropriate instance variable.  

	
		protected boolean inBounds(int row, int col) {
			if(row < 0 || row >= myGrid.length ) return false;
			if(col < 0 || col >= myGrid[0].length ) return false;
			return true;
		}
}
