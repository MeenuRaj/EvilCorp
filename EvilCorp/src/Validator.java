import java.util.Scanner;

public class Validator {

	public static String getString(Scanner scan, String prompt) {
		System.out.print(prompt);
		String s = scan.next();
		scan.nextLine();
		return s;
	}

	public static int getInt(Scanner scan, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (scan.hasNextInt()) {
				i = scan.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer value. Try Again ");

			}
			scan.nextLine();
		}
		return i;
	}
	
	
	public static double getDouble(Scanner scan, String prompt) {
		double i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (scan.hasNextDouble()) {
				i = scan.nextDouble();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer value. Try Again ");

			}
			scan.nextLine();
		}
		return i;
	}
	
	

	public static int getInt(Scanner scan, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(scan, prompt);
			if (i <= min || i >= max)
				System.out.println("error! number must be greater than " + min
						+ ".");
			else
				isValid = true;
		}
		return i;
	}

}