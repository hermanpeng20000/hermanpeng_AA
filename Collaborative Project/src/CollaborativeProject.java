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
		System.out.println("Enter at least 1 numbers");
		
		/* Sets the input as a String that can be converted
		 * into integers and then sorted. */
		
		String input = console.nextLine();
		
		/* Checks to 
		 */
		if (input.length() < 2){
			System.out.println("Not enough numbers");
		}
		//Gets rid of all the spaces between the int values
		String[] individualInts = input.split(" ");
		int currentNumberLocation = Integer.parseInt(individualInts[1]);
		int min = currentNumberLocation;
		int max = currentNumberLocation;
		int maxEven = Integer.MIN_VALUE;
		int totalEven = 0;
		//for loop that runs for the length of modified string
		for (int i = 0; i < individualInts.length; i++){
			//parse changes the string values to int values
			currentNumberLocation = Integer.parseInt(individualInts[i]);
			if (currentNumberLocation > max){
					max = currentNumberLocation;
			}
			if (currentNumberLocation < min){
				min = currentNumberLocation;
			}
			if (currentNumberLocation % 2 == 0){
				totalEven += currentNumberLocation;
				if(currentNumberLocation > maxEven){
					maxEven = currentNumberLocation;
				}
			}
			if (maxEven == Integer.MIN_VALUE || totalEven == 0){
				System.out.println("No Even Number Inputted");
				totalEven = 0;
				maxEven = 0;
			}
		}
		//Print out all the required data
		System.out.println(" ");
		System.out.println("Largest Number : " + max);
		System.out.println("Smallest Number : " +  min);
		System.out.println("Even Numbers Total : " + totalEven);
		System.out.println("Largest Even Number : " + maxEven);
		
	}
}
