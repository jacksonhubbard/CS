
public class AlphaPath {
		private String[][] maze;
		
		
		// we are given a String of letters and dots and we want to convert to [] [] (maze)
		// for each row, the col is the char at the col # + ""
		// add a "" to each char in order to make it a String so we can use .equals()
		// if maze [i] [j] == A, store row and col b/c thats starting point for navigate
		
		public String hasPath(String[] arr) {
			int row = 0; 
			int col = 0;
			
			maze = new String[arr.length][arr[0].length()];
			
	        for (int i = 0; i < arr.length; i++) {
	        	for (int j = 0; j < arr[0].length(); j++) {
	        		maze[i][j] = arr[i].charAt(j) +"";
	        		if (maze[i][j].equals("A")) {
	        			row = i;
	        			col = j;
	        		}
	        	}
	        } return navigate(row, col, 'A');
	    }
		
		// recursive solution- baseCase = current letter = Z
		// check neighbors to see if they are the nextLetter by passing through arrays dr and dc
		// if gets through all of maze, return "NO" 
		private String navigate(int row, int col, char letter) {
			if (letter == 'Z') return "YES";
			char nextLetter = (char) ((int) letter + 1);
			
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			
			for (int i = 0; i < 4; i++) {
				int nRow = dr[i]+row;
				int nCol = dc[i]+col;
				if (inBounds(nRow, nCol)) {
					if (maze[nRow][nCol].equals(nextLetter+""))
						return navigate(nRow, nCol, nextLetter);
				}
			}
			
			return "NO";
		}
		
		private boolean inBounds(int row, int col) {
			return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length;
		}
		
		
		
	}