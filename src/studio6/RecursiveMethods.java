package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		
			// FIXME compute the geometric sum for the first n terms recursively
		
		if (n == 0) {
			return 0;
		}
		else if (n == 1) {
			return 0.5;
		}
		else {
			return Math.pow(0.5, n) + geometricSum(n-1);
		}
		
	}

	
	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius, double radiusMinimumDrawingThreshold) {
		
		// FIXME complete the recursive drawing
		double bound = 5.0;
		StdDraw.setXscale(-bound, bound);
		StdDraw.setYscale(-bound, bound);
		
		if (radius < radiusMinimumDrawingThreshold) {
			return;
		}
		
		StdDraw.circle(xCenter,  yCenter,  radius);
		
		double newRadius = radius/3;
		
		
		// Top
	    circlesUponCircles(xCenter, yCenter + radius, newRadius, radiusMinimumDrawingThreshold);
	    // Bottom
	    circlesUponCircles(xCenter, yCenter - radius, newRadius, radiusMinimumDrawingThreshold);
	    // Left
	    circlesUponCircles(xCenter - radius, yCenter, newRadius, radiusMinimumDrawingThreshold);
	    // Right
	    circlesUponCircles(xCenter + radius, yCenter, newRadius, radiusMinimumDrawingThreshold);

		
		
		/*int factor= (int)(radius/radiusMinimumDrawingThreshold);
		//(radius/3)*factor;
		
		if (factor == 1) {
			StdDraw.circle(xCenter,  yCenter, radius);
		}
		else {
			StdDraw.circle(xCenter,  yCenter+radius, radius*3);
		}
		
		
		
		
		
		
		double updateYCenter = xCenter;
		double updateXCenter = yCenter;
		
		StdDraw.setPenColor(0,0,0);
		
		StdDraw.circle(xCenter,  yCenter, radius);
		
		if (radius == radiusMinimumDrawingThreshold) {
			StdDraw.circle(xCenter,  yCenter,  radiusMinimumDrawingThreshold);
		}
		else {
			radius = radius/3;
			
			circlesUponCircles(updateXCenter, updateYCenter, radius, radiusMinimumDrawingThreshold);
		}
		
		updateXCenter - (radius/2)
		
		
		StdDraw.circle(xCenter,  yCenter+radius, radius);
		StdDraw.circle(-xCenter,  yCenter+radius, radius);
		StdDraw.circle(xCenter+radius,  yCenter, radius);
		StdDraw.circle(xCenter+radius,  -yCenter, radius); 
		
		
		
		
		
		StdDraw.setPenColor(0,0,0);
		
		
		
		StdDraw.circle(xCenter-radius,  yCenter, radius);
		StdDraw.circle(-xCenter+radius,  yCenter, radius);
		StdDraw.circle(xCenter,  yCenter-radius, radius);
		StdDraw.circle(xCenter,  -yCenter+radius, radius);
		
		
		if (radius > radiusMinimumDrawingThreshold) {
			StdDraw.circle(xCenter-radius,  yCenter, radius);
			StdDraw.circle(-xCenter+radius,  yCenter, radius);
			StdDraw.circle(xCenter,  yCenter-radius, radius);
			StdDraw.circle(xCenter,  -yCenter+radius, radius);
			circlesUponCircles(xCenter-radius, yCenter-radius, radius/3, radiusMinimumDrawingThreshold);
		}*/
		
	}
	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		
			// FIXME create a helper method that can recursively reverse the given array
		
		int[] reversed = new int[array.length];
	    
		if (array.length == 0) {
			return new int[0];
		}
		else {
		toReversedHelper(array, reversed, 0);
	    return reversed;
		}
	}

	private static void toReversedHelper(int[] original, int[] reversed, int index) {
	    int lastIndex = original.length - 1;
	    if (index > lastIndex / 2) {
	        return;
	    }

	    int mirrorIndex = lastIndex - index;
	    reversed[index] = original[mirrorIndex];
	    reversed[mirrorIndex] = original[index];

	    toReversedHelper(original, reversed, index + 1);
	}

	
	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		
			// FIXME compute the gcd of p and q using recursion
		
		if (p % q == 0) {
			return q;
		}
		else {
			int temp = q;
			q = p % q;
			p = temp;
			return gcd(p,q);
		}
		
		
		
	}


}
