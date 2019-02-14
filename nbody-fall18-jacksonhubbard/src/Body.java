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
	
	
	
	/**
	 * return x-position of this Body
	 * @return value of x-position of this Body
	 */
	public double getX() {
		return myXPos;
	}
	
	
	
	/**
	 * return y-position of this Body
	 * @return value of y-position of this Body
	 */
	public double getY() {
		return myYPos;
	}
	
	
	
	/**
	 * return x-velocity of this Body
	 * @return value of x-velocity of this Body
	 */
	public double getXVel() {
		return myXVel;
	}
	
	
	/**
	 * return y-velocity of this Body
	 * @return value of y-velocity of this Body
	 */
	public double getYVel() {
		return myYVel;
	}
	
	
	/**
	 * return mass of this Body
	 * @return value of mass of this Body
	 */
	public double getMass() {
		return myMass;
	}
	
	
	/**
	 * return fileName of this Body
	 * @return value of fileName of this Body
	 */
	public String getName() {
		return myFileName;
	}
	
	
	
	/**
	 * returns the distance between this body and another (Body b)
	 * @param b- the other body distance is calculated to
	 * @return distance between this body and Body b
	 */
	public double calcDistance(Body b) {
		double body1_x= b.getX();
		double body1_y = b.getY();
		double body2_x = this.getX();
		double body2_y = this.getY(); 
		
		double r_squared = Math.pow((body1_x - body2_x), 2) + Math.pow((body1_y - body2_y), 2);
		double distance = Math.sqrt(r_squared);
		
		return distance;
	}
	
	
	
	/**
	 * calculates the force a body exerts on another
	 * @param p- other body that is exerting the force  
	 * @return the value of the force exerted by Body p on this Body
	 */
	public double calcForceExertedBy(Body p) {
		double mass_p = p.getMass();
		double mass_this = this.getMass();
		double gravity = 6.67*1e-11;
		double distance = Math.pow(calcDistance(p), 2);
		
		double force = gravity * mass_p * mass_this /distance; 
		
		return force;
	}
	
	
	
	
	/**
	 * calculates the force exerted by one body on another in the x direction
	 * @param p - other body that is exerting the force
	 * @return the value of the force in the x direction exerted by Body p on this Body
	 */
	public double calcForceExertedByX(Body p) {
		double f_value = calcForceExertedBy(p);
		double dx = p.getX() - this.getX();  
		double r = calcDistance (p);
		
		double fx = f_value * dx / r;
		
		return fx;
	}
	
	
	/**
	 * calculates the force exerted by one body on another in the y direction
	 * @param p - other body that is exerting the force
	 * @return the value of the force in the y direction exerted by Body p on this Body
	 */
	public double calcForceExertedByY (Body p) {
		double f_value = calcForceExertedBy(p);
		double dy = p.getY() - this.getY();  
		double r = calcDistance (p);
		
		double fy = f_value * dy / r;
		
		return fy;
	}
	
	/**
	 * calculates the total/net force in the x direction on this Body by all other Bodies
	 * @param bodies- array of all bodies
	 * @return the total x force of all other Bodies on this Body
	 */
	public double calcNetForceExertedByX (Body[] bodies) {
		double total = 0.0; 
		for(Body b : bodies) {
			if (! b.equals(this)) {
				total += calcForceExertedByX(b);
			}
		}
		return total;
	}
	
	
	
	/**
	 * calculates the total/net force in the y direction on this Body by all other Bodies
	 * @param bodies- array of all bodies
	 * @return the total y force of all other Bodies on this Body
	 */
	public double calcNetForceExertedByY (Body[] bodies) {
		double total = 0.0; 
		for(Body b : bodies) {
			if (! b.equals(this)) {
				total += calcForceExertedByY(b);
			}
		}
		return total;
	}
	
	
	/**
	 * updates the instance variables of Body on which called
	 * @param deltaT- time step of how long Body has been acted upon
	 * @param xforce- net x- force exerted on this body by all other bodies in the simulation
	 * @param yforce- net y- force exerted on this body by all other bodies in the simulation
	 */
	public void update(double deltaT, double xforce, double yforce) {
		// step 1
		double ax = xforce / this.getMass();
		double ay = yforce / this.getMass();
		
		// step 2
		double nvx = myXVel + deltaT * ax; 
		double nvy = myYVel + deltaT * ay; 
		
		// step 3 
		double nx = myXPos + deltaT*nvx; 
		double ny = myYPos + deltaT*nvy; 
		
		// step 4
		myXPos = nx;
		myYPos = ny;
		myXVel = nvx; 
		myYVel = nvy;


	}
	
	
	
	/**
	 * draws this Body given its instance variables myXPos, myYPos, and myFileName
	 */
	public void draw() {
		StdDraw.picture(myXPos, myYPos, "images/"+myFileName);
	}
}
