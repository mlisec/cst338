//Matthew Lisec
//String manipulation program

//used in order to collect data from the user
import java.util.Scanner;

//Used to specify the format of a number
import java.text.DecimalFormat;

public class stringManipulation {
	
	//storing the min and max hours
	static final int MIN_HOURS = 12;
	static final int MAX_HOURS = 20;

	public static void main(String[] args) {
		
		//enabling the Scanner class to be used
		Scanner scan = new Scanner(System.in);
		
		//asking the user for their first and last name
		//and storing it
		System.out.println("Enter your first name: ");
		String firstName = scan.nextLine();
		System.out.println("Enter your last name: ");
		String lastName = scan.nextLine();
		
		//combining the first and last name with a space
		String fullName = firstName + " " + lastName;
		
		//storing the length of the user's full name
		int nameLength = fullName.length();
		
		//prints the full name and length
		//and printing the full name in upper case and then lower case
		System.out.println(fullName);
		System.out.println(nameLength);
		System.out.println(fullName.toUpperCase());
		System.out.println(fullName.toLowerCase());
		
		//establishes that the decimal should go to one decimal place
		DecimalFormat decimal = new DecimalFormat("0.0");
		
		//Prints the minimum and maximum amount of hours to spend in the class
		System.out.println("The amount of hours you should spend in this"
				+ " class are between " + MIN_HOURS + " and " + MAX_HOURS + ".");
		
		//ask the user for input and store the input value
		System.out.println("How many hours have you spent in this class to 3 decimal places?");
		double hours = scan.nextDouble();
		
		//print the rounded value of the input
		System.out.println(decimal.format(hours));

	}

}
