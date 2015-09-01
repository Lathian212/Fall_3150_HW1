/* Author: Lathian (Jonathan) Kwiat
 * Course: 3150 OOP
 * Question 6:
 * Write a program that prompts the user to enter the center coordinates and 
 * radiuses of two circles. Determine whether the are separate from each 
 * other, touching each other, overlapping each other, or completely within 
 * one another. Test each case and show the output.
 */
import java.util.Scanner;

public class Q6TwoCirclesOverlapDetermine {
	//Fudge factor to compare floats.
	static final double EPSILON = 0.00001;
	
	public static void main (String [] args) {
		Scanner input = new Scanner(System.in);
		double radius1, xCord1, yCord1;
		double radius2, xCord2, yCord2;
		double circlesDistance;
		String ans = null;
		do {
			System.out.print("For Circle 1: enter radius: ");
			radius1 = input.nextDouble();
			System.out.print("For Circle 1: enter x cordinate, followed by a space, y cordinate then enter: ");
			xCord1 = input.nextDouble();
			yCord1 = input.nextDouble();
			System.out.print("For Circle 2: enter radius: ");
			radius2 = input.nextDouble();
			System.out.print("For Circle 2: enter x cordinate, followed by a space, y cordinate then enter: ");
			xCord2 = input.nextDouble();
			yCord2 = input.nextDouble();
			circlesDistance = distPoints(xCord1, xCord2, yCord1, yCord2);
			System.out.println(CirclesPositioning(radius1, radius2, circlesDistance));
			System.out.print("Enter x to terminate or y to continue: ");
			ans = input.next();
		} while (!(ans.equalsIgnoreCase("x")));
		input.close();
	}
public static String CirclesPositioning(double r1, double r2, double dist) {
		
		double smallR = 0.0;
		double bigR = 0.0;
		// Using the distinction between big Radius and small to determine whether
		// one circle is completely in
		if (r1 > r2) {
			bigR = r1;
			smallR = r2;
		}
		else {
			bigR = r2;
			smallR = r1;
		}
		if (dist > (smallR + bigR)) {
			return "The two circles are not touching";
		}
		// Below is test for float equality
		// Testing if the circles are basically at the same co-ordinates and they have
		// within EPSILON radi then they are superimposed
		else if ((dist < EPSILON) && Math.abs(bigR-smallR) < EPSILON ){
			return "The two circles are superimposed, touching each other";
		}
		// Below branch tests if any overlap or one is completely inside the other.
		// First test if they are touching in anyway
		else if ((dist + smallR) <= bigR) {
				return "The smaller circle is completely inside the bigger.";
			}
			else if ((dist + smallR) > bigR) {
				return "The two circles overlap";
			}
		return "Method did not function properly a test failed.";
		}
	// Helper method implementing distance between two co-ordinated points
public static double distPoints(double x1, double x2, double y1, double y2) {
	return Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1), 2));
}
}