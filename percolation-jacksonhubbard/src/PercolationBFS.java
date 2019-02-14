import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast {

	public PercolationBFS(int n) {
		super(n);
	}
	
	
	
	@Override
	protected void dfs(int row, int col) {

		int[] rowDelta = {-1,1,0,0};
        int[] colDelta = {0,0,-1,1};
        int size = myGrid.length;

        Queue<Integer> qp = new LinkedList<>();       
        qp.add(row*size + col);
        myGrid[row][col] = FULL;
        
        while (qp.size() != 0){  
        		
            Integer value = qp.remove();
            for(int k=0; k < rowDelta.length; k++){
                int row2 = value / size + rowDelta[k];
                int col2 = value % size + colDelta[k];
                
                if (inBounds(row2,col2)) {
              
                		if (isOpen(row2, col2) && ! isFull(row2, col2)) {
                			myGrid[row2][col2] = FULL;
                			qp.add(row2*size + col2);
                		}
                		

                    
                }
            }
        }

    }
}
	

