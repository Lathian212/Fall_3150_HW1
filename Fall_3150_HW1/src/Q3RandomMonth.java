/* 
Author: Lathian (Jonathan) Kwiat
Course: 3150 OOP

Question 3:
Write a program that randomly generates an integer between 1 & 12, and 
displays the English name of that month. Run the program & show the 
output.
*/
import java.util.Random;
import java.time.Month;

public class Q3RandomMonth {
	public static void main (String [] args) {
		Random rnd = new Random();
		int rndMonth = rnd.nextInt(12)+1;
		System.out.printf("The pseudorandom month is %s%n", Month.of(rndMonth));
	}
}