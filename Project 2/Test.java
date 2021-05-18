package project2;
import java.util.*;


public class Test {
	
	public static void main(String[] args) {
		
		double a; 
		double b;
		double c; 
		double d;
		double e; 
		double f;
		double x;
		double y;
		
		Scanner input = new Scanner(System.in);
		
		/* 
		 * Displays message for user to enter a value for each variable
		 * and reads the input as a double
		 */
		System.out.print("Please enter value for " + "a: ");
		a = input.nextDouble();
		System.out.print("Please enter value for " + "b: ");
		b = input.nextDouble();
		System.out.print("Please enter value for " + "c: ");
		c = input.nextDouble();
		System.out.print("Please enter value for " + "d: ");
		d = input.nextDouble();
		System.out.print("Please enter value for " + "e: ");
		e = input.nextDouble();
		System.out.print("Please enter value for " + "f: ");
		f = input.nextDouble();
		
		LinearEquation linEq = new LinearEquation(a,b,c,d,e,f);
		
		/*
		 * Sets error to the value that isSolvable returns and if it
		 * is set to false, the program displays message stating no solution
		 * and terminates
		 */
		boolean error = linEq.isSolvable();
		if (error == false) {
			System.exit(0);
		}
		
		/* 
		 * Sets the value for x and y equal to the value that
		 * getX and getY return
		 */
		x = linEq.getX();
		y = linEq.getY();
		
		/* Displays the solutions for x and y */
		System.out.println("The solution for 'x' is: " + x);
		System.out.println("The solution for 'y' is: " + y);
		
		input.close();
	}




}
