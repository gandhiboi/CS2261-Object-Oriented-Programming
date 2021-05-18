package project2;

public class LinearEquation {
	
	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;
	
	/*
	 * Constructor that takes in the arguments and sets the variables
	 * equal to the corresponding variable
	 */
	public LinearEquation(double a, double b, double c, double d, double e, double f) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
	}
	
	/* 
	 * Six getter methods for the six variables that return the value
	 */
	public double getA() {
		return a;
	}
	public double getB() {
		return b;
	}
	public double getC() {
		return c;
	}
	public double getD() {
		return d;
	}
	public double getE() {
		return e;
	}
	public double getF() {
		return f;
	}
	
	/* 
	 * Method that determines whether or not the denominator is 
	 * equal to zero; if it is not equal to zero return true otherwise
	 * it displays "error" message and returns false
	 */
	public boolean isSolvable() {
		if ((a*d) - (b*c) != 0) {
			return true;
		}
		else {
			System.out.println("There is no solution to the equation");
			return false;
		}
	}
	
	/*
	 * Calls the method isSolvable to check if the denominator is
	 * equal to zero and solves for x and y, then returns x
	 */
	public double getX() {
		isSolvable();
		double x;
		x = ((e*d) - (b*f)) / ((a*d) - (b*c));
		return x;
	}
	
	/*
	 * Calls the method isSolvable to check if the denominator is
	 * equal to zero and solves for y and then returns y
	 */
	public double getY() {
		isSolvable();
		double y;
		y = ((a*f) - (e*c)) / ((a*d) - (b*c));
		return y;
	}
	
	
}