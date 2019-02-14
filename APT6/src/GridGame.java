public class GridGame {
	
	public int winningMoves(String[] grid) {
		char[][] board = new char[4][4];
		for(int r=0; r < 4; r++) {
			for(int c=0; c < 4; c++) {
				board[r][c] = grid[r].charAt(c);
			}
		}
		return winCount(board);
	}

	private int winCount(char[][] board) {
		int count = 0;
		for(int r=0; r < 4; r++) {
			for(int c=0; c < 4; c++) {
				if (isMoveLegal(board,r,c)) {
					board[r][c] = 'X';
					int opponentCount = winCount(board);
					if (opponentCount == 0) {
						count += 1;
					}
					board[r][c] = '.';
				}
			}
		}
		return count;
	}
	private boolean isMoveLegal(char[][] board, int r, int c) {
		if (r < 0 || c < 0 || r >= 4 || c >= 4) {
			return false;
		}
		if (board[r][c] == 'X') return false;
		int[] rdelta = {-1,1,0,0};
		int[] cdelta = {0,0,-1,1};
		for(int k=0; k < rdelta.length; k++) {
			int nr = r + rdelta[k];
			int nc = c + cdelta[k];
			if (nr >= 0 && nc >= 0 && nr < 4 && nc < 4) {
				if (board[nr][nc] == 'X') return false;
			}
		}
		return true;
	}
}