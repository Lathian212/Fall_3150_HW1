/* 
Author: Lathian (Jonathan) Kwiat
Course: 3150 OOP

Question 5:
Write a program that reads three 2D points A, B, and C from the user. 
Next, calculate the length of each side of the triangle using the 
distance formula: sqrt((x2-x1)^2+(y2-y1)^2). Finally, determine if it's a 
real triangle. For a triangle to be real, the sum of any two sides needs 
to be greater than the third. Make sure your output has some real and at 
least one fake triangle.
*/
import java.util.Scanner;
import java.util.Vector;
import java.math.*;

public class Q5TriangleSidesIsReal {
	public static final int X = 0;
	public static final int Y = 1;
	
	public static void main (String [] args){
		Scanner input = new Scanner (System.in);
		double[][] tPoints = new double[3][2];
		Vector<Double> tSides = new Vector<Double>();
		
		while (true) {
			tSides.clear(); 
			for (int i=0; i < 3; i++) {
				System.out.printf("Enter the %d of 3 pairs of x, y points of"+
						" a triangle separated by a space: ", i+1);
				tPoints[i][X] = input.nextDouble();
				tPoints[i][Y] = input.nextDouble();
			}
			sideCalc(tPoints, tSides);
			// using Vector's sort method.
			tSides.sort(null);
			System.out.println("The length of the sides of the triangle you just entered are as follows:");
			for ( double side : tSides) {
				System.out.printf("%.2f%n", side);
			}
			System.out.printf("%n");
			if (isTriangle (tSides)) {
				System.out.printf(" The points you entered are a triangle because the sum of any two sides is" +
						"greater then the third.%n");
			}
			else {
				System.out.printf(" The points you entered are NOT a triangle because" +
						"the sum of two of the sides is not greater then the third.%n");
				
			}
		}
	}
private static void sideCalc (double[][] tPoints, Vector<Double> tSides){
	int nPt = 0;
	for (int i = 0; i < 3; i++){
		if (i ==2) {
			nPt =0;
		}
		else
			nPt = i+1;
		tSides.add(Math.sqrt(Math.pow((tPoints[nPt][X]-tPoints[i][X]), 2) +
				Math.pow((tPoints[nPt][Y]-tPoints[i][Y]), 2)));
	}
}
private static boolean isTriangle (Vector<Double> tSides){
	// I made a mistake here in the Spring Semester. The SUM of ANY two
	// sides needs to be great then the third.
	return (
			((tSides.elementAt(0) + tSides.elementAt(1)) > tSides.elementAt(2)) &&
			((tSides.elementAt(1) + tSides.elementAt(2)) > tSides.elementAt(0)) &&
			((tSides.elementAt(0) + tSides.elementAt(2)) > tSides.elementAt(1))
			);
}
}