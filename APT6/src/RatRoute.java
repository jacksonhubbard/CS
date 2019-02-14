public class RatRoute {
	int myCheeseRow, myCheeseCol;
    char[][] myBoard;
    
    public int cheeseDistance(int row, int col){
        int dx = Math.abs(row-myCheeseRow);
        int dy = Math.abs(col-myCheeseCol);
        return dx + dy;
    }
    
    public int numRoutes(String[] enc) {
        int ratRow = 0;
        int ratCol = 0;
        myBoard = new char[enc.length][enc[0].length()];
        for(int r=0; r < myBoard.length; r++){
            for(int c=0; c < myBoard[0].length; c++){
                myBoard[r][c] = enc[r].charAt(c);
                if (myBoard[r][c] == 'R'){
                    ratRow = r;
                    ratCol = c;
                }
                else if (myBoard[r][c] == 'C'){
                    myCheeseRow = r;
                    myCheeseCol = c;
                }
            }
        }
        return moveCount(ratRow,ratCol);
    }

    private int moveCount(int r, int c) {
      
        if (r < 0 || c < 0 || 
            r >= myBoard.length || 
            c >= myBoard[0].length) {
            return 0;
        }
        if (myBoard[r][c] == 'X') return 0;
        if (r == myCheeseRow && c == myCheeseCol) return 1;
        
        int distanceNow = cheeseDistance(r,c);       
        int[] deltaRow = {-1,0,0,1};
        int[] deltaCol = {0,-1,1,0};
        int total = 0;
        
        for(int k=0; k < deltaRow.length; k++){
            int nr = r + deltaRow[k];
            int nc = c + deltaCol[k];
            if (cheeseDistance(nr,nc) < distanceNow) {
            	int next = moveCount(nr,nc);
            	total += next;
            }
        }
        return total;
    }
    public static void main(String[] args) {
    	String[] s = {"X..X.X.", "XX.C.X.", ".......",
    	              "..X.X..", ".......", "R.XX..." };
    	RatRoute rr = new RatRoute();
    	System.out.println(rr.numRoutes(s));

    }
}