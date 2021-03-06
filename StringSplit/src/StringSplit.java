/* Herman Peng
 * 1st period
 * October 31st, 2016
 * StringSplit Assignment
 */

public class StringSplit 
{
	/* Main method is used to test whether or not the methods being called work.
	 * Each println tests out a different scenario to see whether or not
	 * the code is able to be flexible for each task.
	 */
	public static void main(String[] args) 
	{
		/* Checks whether the code can find that having two breads next to one
		 * another does not qualify as a sandwich.
		 */
		System.out.println(splitSandwichAtSpaces("bread bread"));
		/* Checks whether or not code can find that having an item in between
		 * two breads qualifies as a sandwich.
		 */
		System.out.println(splitSandwichAtSpaces("bread ham cheese bread"));
		/* Checks whether or not code can find that having an item outside of
		 * two breads means it is not included in the sandwich.
		 */
		System.out.println(splitSandwichAtSpaces("bread turkey bread lettuce"));
		/* Checks whether or not code can ignore items outside of two breads
		 * and then find that two breads with nothing in between in the middle
		 * of the code does not qualify as sandwich.
		 */
		System.out.println(splitSandwichAtSpaces("turkey bread bread lettuce"));
		/* Checks whether or not code can find items in between two breads 
		 * using the second method.
		 */
		System.out.println(splitBread("breadlettucetomatoeturkeybread"));
		/* Checks whether or not code can find items inside the sandwich while
		 * also ignoring items outside of the two breads.
		 */
		System.out.println(splitBread("breadcheeseeggbreadbacon"));
		/* Checks whether or not code can find that two breads besides one 
		 * another does not qualify as a sandwich.
		 */
		System.out.println(splitBread("breadbread"));
		/* Checks whether or not code can eliminate ingredients outside of 
		 * the sandwich.
		 */
		System.out.println(splitBread("cheesebreadeggbaconbreadtomatoe"));
	}
	
	/* This method takes input that contains spaces. The input is then determined
	 * whether or not it has the ingredients and order to make a sandwich, and if so
	 * the code will proceed to take items within the sandwich and return them 
	 * to the user.
	 */
	public static String splitSandwichAtSpaces(String sandwichInput){
		/* "finalAnswer" is the final variable that takes the results of the sandwich
		 * and returns it to the main method, where it is printed.
		 */
		String finalAnswer = "";
		/* "listOfIngredients" gets inputed all the main contents and is then processed
		 * by the code to determine it's parts and items necessary to return.
		 * Spaces are added before and after "listOfIngredients" as a safeguard for the
		 * scenario where a bread is placed at the beginning or end of the code.
		 */
		String listOfIngredients = " " + sandwichInput + " ";
		/* "sandwichBrokenDown" is an array which breaks down all the words of the original
		 * input (based off of the arrangement of spaces) and sticks it into "listOfIngredients."
		 */
		String [] sandwichBrokenDown = sandwichInput.split(" ");
		/* Takes the items from "sandwichBrokenDown" and adds it into "listOfIngredients"
		 * so that the code will further process the input to determine if it is a sandwich
		 * or not.
		 */
		for (int i = 0; i < sandwichBrokenDown.length; i++){
			listOfIngredients += sandwichBrokenDown[i];
		}
		/* "arrayBread" takes all the items in between the intended breads and stores
		 * it for further processing.
		 */
		String[] arrayBread = listOfIngredients.split("bread");
		/* A sandwich must be comprised of at least 3 items, so this code verifies whether
		 * or not there are items in between the breads, and thus whether or not it is a sandwich.
		 */
		if(arrayBread.length <= 2){
			System.out.println("Ingredients entered are not a sandwich.");
		/* The "if" statement was the most basic check for whether sandwich is valid or not,
		 * this "else" statement serves to both verify if it is not a sandwich, but if it is
		 * acts to return it to the main.
		 */
		}
		else {
			for (int i = 1; i < arrayBread.length-1; i++){
				/* The conditions stated in the "if" statement verify that the input entered
				 * does not contain a sandwich, and returns the statment telling the user.
				 */
				if (arrayBread[i].equals("") && i == arrayBread.length - 2){
					System.out.println("Ingredients entered are not a sandwich.");
				}
				/* If the item being tested is proved to be part of a sandwich by the previous
				 * code, it is added to the "finalAnswer" as part of the final return list.
				 */
				else {
					finalAnswer += arrayBread[i];
				}
			}
		}
		/* Result is returned back to the main code where it will be alerted to the user
		 * the ingredients of the sandwich.
		 */
		return finalAnswer;
		}

	
	/* Second method of determining whether or not input is a sandwich. Code entered
	 * will not contain spaces and so the code will have to rely on a different method
	 * of splitting items - positioning and location of "bread."
	 */
	public static String splitBread(String breadInput){
		/*"finalAnswer" is the final variable that takes the results of the sandwich
		 * and returns it to the main method, where it is printed.
		 */
		String finalAnswer = "";
		/* "listOfIngredients" gets inputed all the main contents and is then processed
		 * by the code to determine it's parts and items necessary to return.
		 * Spaces are added before and after "listOfIngredients" as a safeguard for the
		 * scenario where a bread is placed at the beginning or end of the code.
		 */
		String listOfIngredients = " " + breadInput + " ";
		/* The array "arrayBraed" contains all the items of the sandwich, but proceeds
		 * to split the original input based off of the location of "bread", thus riddding
		 * the code of "bread" and leaving its remnants.
		 */
		String[] arrayBread = listOfIngredients.split("bread");
		/* A sandwich must be comprised of at least 3 items, so this code verifies whether
		 * or not there are items in between the breads, and thus whether or not it is a sandwich.
		 */
		if(arrayBread.length <= 2){
			System.out.println("Ingredients entered are not a sandwich.");
		/* The "if" statement was the most basic check for whether sandwich is valid or not,
		 * this "else" statement serves to both verify if it is not a sandwich, but if it is
		 * acts to return it to the main.
		 */
		}else{
			for (int i = 1; i < arrayBread.length-1; i++){
				/* Item being processed by the "for" loop is then added to the String 
				 * "middleSandwich" where it will be further processed and set off.
				 */
				String middleSandwich = arrayBread[i];
				/* In the scenario where breads in succession are determined, the code will
				 * process the output so that a blank is released in its place.
				 */
				if(arrayBread[i].equals("")){
					System.out.print("");
				/* Once the items have been processed and determined proper for the conditions
				 * of the sandwich, the item is added to the "finalAnswer" that will be returned
				 * to the main and then printed.
				 */
				}else{
					finalAnswer += middleSandwich;
				}
			}
		}
		/* Result is returned back to the main code where it will be alerted to the user
		 * the ingredients of the sandwich.
		 */	
		return finalAnswer;
	}
}