
public class Gravity {
      public double falling(double time, double velo){
	    	  	double meters;
	    	  	double acceleration= 9.8;
	    	  	
	    	  	double formula= velo*time + 0.5*acceleration*(time*time);
	    	  	return formula;
      }
  }



