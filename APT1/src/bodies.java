public class Body {
	
	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;
	
	
	/**
	 * Creates a body from parameters
	 * @param xp- initial x position
	 * @param yp- initial y position
	 * @param xv- initial x velocity
	 * @param yv- initial y velocity
	 * @param mass- mass of object
	 * @param filename- file of image for object animation
	 */
	public Body(double xp, double yp, double xv, double yv, double mass, String filename) {
		myXPos = xp;
		myYPos = yp; 
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename; 
	}
	
	
	/**
	 * copy constructor; copy instance variables from one body to this body
	 * @param b- used to initialize this body
	 */
	public Body(Body b) {
		myXPos = b.getX();
		myYPos = b.getY(); 
		myXVel = b.getXVel();
		myYVel = b.getYVel();
		myMass = b.getMass();
		myFileName = b.getName();
	}
	
	
	
	
	public double getX() {
		return myXPos;
	}
	
	
	
	public double getY() {
		return myYPos;
	}
	
	
	public double getXVel() {
		return myXVel;
	}
	
	public double getYVel() {
		return myYVel;
	}
	
	public double getMass() {
		return myMass;
	}
	
	
	public String getName() {
		return myFileName;
	}
	
	
	public double calcDistance(Body b) {
		double body1_x= b.getX();
		double body1_y = b.getY();
		double body2_x = this.getX();
		double body2_y = this.getY(); 
		
		double r_squared = Math.pow((body1_x - body2_x), 2) + Math.pow((body1_y - body2_y), 2);
		double distance = Math.sqrt(r_squared);
		
		return distance;
	}
	

	public double calcForceExertedBy(Body p) {
		double mass_p = p.getMass();
		double mass_this = this.getMass();
		double gravity = 6.67*1e-11;
		double distance = Math.pow(calcDistance(p), 2);
		
		double force = gravity * mass_p * mass_this /distance; 
		
		return force;
	}
	
	
	public double calcForceExertedByX(Body p) {
		double f_value = calcForceExertedBy(p);
		double dx = p.getX() - this.getX();  
		double r = calcDistance (p);
		
		double fx = f_value * dx / r;
		
		return fx;
	}
	
	public double calcForceExertedByY (Body p) {
		double f_value = calcForceExertedBy(p);
		double dy = p.getY() - this.getY();  
		double r = calcDistance (p);
		
		double fy = f_value * dy / r;
		
		return fy;
	}
}
