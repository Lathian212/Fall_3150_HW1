/* 
Author: Lathian (Jonathan) Kwiat
Course: 3150 OOP

Question 4:
Feed a file that contains numbers into your program using command line 
redirection. Have your program read & print the file on the screen.
*/
import java.io.*;
import java.util.Scanner;

public class Q4ReadFileDisplayFile {
	public static void main (String [] args) {
		Scanner input = new Scanner(System.in);
		File file = new File(args[0]);
		FileInputStream inst = null;
		try {
			inst = new FileInputStream (file);
		} catch (FileNotFoundException e) {
			System.out.println("The file you entered could not be found.");
			System.out.print("Please enter the name again or press" +
					"ctrl-d to exit the program:");
			String [] args2 = new String[1];
			args2[0] = input.next();
			main(args2);
			return;
		}
		BufferedReader bfrF = new BufferedReader ( new InputStreamReader
				(inst));
		try {
			while (bfrF.ready()) {
				System.out.println(bfrF.readLine());
			}
		} catch (IOException e) {
			System.out.println("Looks like reading of the file got " +
					"interrupted.");
			System.out.print("Do you wish to try read the file again y/n: ");
			String ans = input.next();
			if (ans.equalsIgnoreCase("y")){
				main(args);
				return;
			}
			else
				return;
		}		
	}
}