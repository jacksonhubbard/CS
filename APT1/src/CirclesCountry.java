
public class CirclesCountry {
	public int leastBorders(int[] x, int[] y, int[] r, int x1, int y1, int x2, int y2) {
	
		int crosses = 0;

		for(int k=0; k<x.length; k++) {
		if ( (isInside(x1, y1, x[k], y[k], r[k]) && ! isInside(x2, y2, x[k], y[k], r[k]) )) {
			crosses += 1;
		}
			if ( (! isInside(x1, y1, x[k], y[k], r[k]) && isInside(x2, y2, x[k], y[k], r[k]) )) {
			crosses += 1;	
		}
		}
		
		return crosses;
	}


	/**
	 * Returns true if a point is inside a circle and 
	 * returns false otherwise.
	 * @param x is x-coordinate of point
	 * @param y is y-coordinate of point
	 * @param cx is center of circle x-coordinate
	 * @param cy is center of circle y-coordinate
	 * @param r is radius of circle
	 * @return true if (x,y) is inside circle, returns
	 * false if (x,y) is on or outside circle
	 */
	public boolean isInside(int x, int y, int cx, int cy, int r){
		// variable dist not shown
		// distance from (x,y) to (cs, cy)
		
		int dist_squared= (x-cx)*(x-cx) + (y-cy)*(y-cy);
		return dist_squared < r*r;
	}

}




