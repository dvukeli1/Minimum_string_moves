
package view;

import java.util.Scanner;

import controllers.MinMovesInterface;
import controllers.MinMovesSearchController;


public class Main {
	
	static String consoleInput = "";
	private static Scanner scanner;

	
	public static void main(String[] args) {
		
		MinMovesInterface minMoves = new MinMovesSearchController();
		String s1 = "";
		String s2 = "";
		int movesNumber;
		clearConsole();
		inputString("Insert first word (1-2000 characters):");
		if(testString(consoleInput)){
			s1 = consoleInput;
		}
		while(!testString(consoleInput)){
			System.out.println("Wrong input !!");
			inputString("Insert first word (1-2000 characters):");
		}
		s1 = consoleInput;
		
		inputString("Insert second word (1-2000 characters):");
		if(testString(consoleInput) || s1.length()== consoleInput.length()){
			s2 = consoleInput;
		}
		while(!testString(consoleInput) || s1.length() != consoleInput.length()){
			System.out.println("Wrong input !!");
			inputString("Insert second word (1-2000 characters):");
		}
		s2 = consoleInput;
		
       movesNumber = minMoves.String_mover(s1, s2);
       
       System.out.println("Minimum moves  = " + movesNumber);
	}
	
	/**
	 * User input 
	 * @param text - question
	 * @return user consoleInput
	 */
	static void inputString(String text) {
		System.out.println(text);
		scanner = new Scanner(System.in);
		consoleInput = scanner.nextLine();
		//return consoleInput;
	}
	
	/**
	 * Test string for numbers and special characters
	 * @param s1 user input
	 * @return true if string contains only alphabet a-z and if 
	 * 1 <= length(A) = length(B) <= 2000
	 */
	static boolean testString(String s1){
		boolean testResult = false;
		s1= s1.replaceAll("[*a-zA-Z]", "");
		if(s1.isEmpty() || s1.isEmpty() || s1.length() > 2000){
			testResult = true;
		}
		return testResult;
	}

	/**
	 * Clear console function
	 */
	 static void clearConsole() {
		try {
			final String os = System.getProperty("os.name"); // get OS name

			if (os.contains("Windows")) // windows function
			{
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear"); // unix function
			}
		} catch (final Exception e) {
			// Handle any exceptions.
		}
	}
}
