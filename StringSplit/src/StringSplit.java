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
		/* 
		 * 
		 */
		String withoutSpaces = "";
		String [] sandwichBrokenDown = sandwichInput.split(" ");
		//Adds all the parts of the String array to a new string
		for (int i = 0; i < sandwichBrokenDown.length; i++){
			withoutSpaces += sandwichBrokenDown[i];
		}
		//Adds space to the end so ending with bread won't impact the code
		withoutSpaces = " " + withoutSpaces;
		withoutSpaces = withoutSpaces + " ";
		String[] arrayBread = withoutSpaces.split("bread");
		//Makes sure there is a sandwich
		if(arrayBread.length <= 2){
			System.out.println("Ingredients entered are not a sandwich.");
		}else {
			//Runs through array with bread and spaces split out
			for(int i = 1; i < arrayBread.length-1; i++){
				//All conditions have to be met to print not a sandwich, guarantees that no faulty return statements happen
				if(arrayBread[i].equals("") && i == arrayBread.length - 2){
					System.out.print("Ingredients entered are not a sandwich.");
				}
				else{
					finalAnswer += arrayBread[i];
				}
			}
			}
		return finalAnswer;
		}
	//	if(revisedSandwich.length == 3){
	//		sandwich = revisedSandwich[1];
	//		System.out.println(sandwich);
	//	}
	public static String splitBread(String breadInput){
		//Adds spaces to the statement in case we start or end with bread
		String finalAnswer = "";
		String check = " " + breadInput + " ";
		// get rid of bread
		String[] arrayBread = check.split("bread");
		// Makes sure it is a sandwich
		if(arrayBread.length <= 2){
			System.out.println("Ingredients entered are not a sandwich.");
		}else{
			for (int i = 1; i <arrayBread.length-1; i++){
				String middleSandwich = arrayBread[i];
				//If two breads are next to each other, there will be a space taking up an index of an Array
				if(arrayBread[i].equals("")){
					System.out.print("");
				}else{
					finalAnswer += middleSandwich;
				}
			}
		}
		return finalAnswer;
	}
}