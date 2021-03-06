/* Author : Herman Peng
 * Due : October 3, 2016
 * Name : Collaborative Project
 * Partner : Kevin Weng
 * Class : AP Computer Science - Ms. Dreyer - Period 1 */

/* Description : This project prompts you to enter in numbers 
 * in a string. The code then sorts out the integers to reveal
 * which which inputted number is largest and smallest. The 
 * total for all your even numbers will be returned, as well as
 * the largest even number. */

import java.util.Scanner;

public class CollaborativeProject {
	
	public static void main(String[] args) {
		
		/* Create a scanner that asks the user for the string
		 * of numbers that will be sorted by the code.*/
		Scanner console = new Scanner(System.in);
		
	    /* Parameters for the user's input are given. Insure
		 * that code will run. */
		System.out.println("Enter in numbers in A B C D... format");
		System.out.println("Only integers will be accepted");
		System.out.println("Enter in spaces between numbers");
		System.out.println("Do not enter commas");
		System.out.println("If no even numbers are entered, '0' will be returned");
		System.out.println("Enter at least 2 numbers");
		
		/* Sets the input as a String that can be converted
		 * into integers and then sorted. */
		String input = console.nextLine();
		
		/* Checks to see if 2 numbers are entered, if not
		 * a message will be returned. */
		if (input.length() <= 2){
			System.out.println("Not enough numbers");
		}
		
		/* The String is broken down into individual
		 * Strings so that it can be sorted. */
		String[] individualInputs = input.split(" ");
		
		/* Sets the integer "currentNumberLocation" to the
		 * initial integer so that the initialized variables
		 * can set themselves to the first number. */
		int currentNumberLocation = Integer.parseInt(individualInputs[0]);
		
		/* The variables are set. Each is set to a different
		 * value that takes into account their purpose. "min"
		 * and "max" are set to the first number so that the
		 * first number will be compared to the rest of the
		 * numbers. */
		int min = currentNumberLocation;
		int max = currentNumberLocation;
		int maxEven = Integer.MIN_VALUE;
		int totalEven = 0;
		
		/* A for loop is set that scans for the numbers we
		 * are looking for. The identified numbers are than
		 * locked into a variable to be later printed. The
		 * "currentNumberLocation" is set to the number that
		 * the loop is set to. */
		for (int i = 0; i < individualInputs.length; i++){
			
			/* The "parse" function changes the individual
			 * String into an integer that will be sorted
			 * out in the rest of the loop. */
			currentNumberLocation = Integer.parseInt(individualInputs[i]);
			
			/* This if statement checks whether the number
			 * being checked is larger than the previous 
			 * number, thus eventually finding the largest
			 * input. */
			if (currentNumberLocation > max){
					max = currentNumberLocation;
			}
			
			/* This if statement checks whether the number
			 * being checked is smaller than the previous 
			 * number, thus eventually finding the smallest
			 * input. */
			if (currentNumberLocation < min){
				min = currentNumberLocation;
			}
			
			/* This if statement checks whether the number
			 * being checked is even, and if it is, adds
			 * that number to the total sum of even numbers.
			 * Another if statement than checks if the current
			 * even number is the largest even number yet
			 * found. */
			if (currentNumberLocation % 2 == 0){
				totalEven += currentNumberLocation;
				if(currentNumberLocation > maxEven){
					maxEven = currentNumberLocation;
				}
			}
			
			/* This if statement checks whether an even 
			 * number was typed in. If not, it sets the
			 * two variables regarding even numbers to 0,
			 * which was previously stated to be the signal
			 * showing that no even number was given. */
			if (maxEven == Integer.MIN_VALUE || totalEven == 0){
				System.out.println("No Even Number Inputted");
				maxEven = 0;
			}
		}
		
		/* The information required to be printed out is then
		 * printed out on the console and given to the user. */
		System.out.println(" ");
		System.out.println("Largest Number : " + max);
		System.out.println("Smallest Number : " +  min);
		System.out.println("Even Numbers Total : " + totalEven);
		System.out.println("Largest Even Number : " + maxEven);
		
	}
}
