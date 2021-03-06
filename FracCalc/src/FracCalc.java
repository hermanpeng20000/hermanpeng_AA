import java.util.*;

/* Herman Peng
 * 1st period
 * December 5th, 2016
 * StringSplit Assignment
 */
public class FracCalc {
	public static void main(String[] args){
		String input;
		Scanner console = new Scanner(System.in);
		do {
			System.out.println("Please enter in your input. Type \"quit\" to exit.");
			input = console.nextLine();
			System.out.println(produceAnswer(input));
		} while (input != "quit");
	}
	public static String produceAnswer(String inputFromMain){
		String[] resultParseInput = parseInput(inputFromMain);
		String leftOperand = resultParseInput[0];
		String operator = resultParseInput[1];
		String rightOperand = resultParseInput[2];
		int[] parsedLeftOperand = parseOperand(leftOperand);
		int[] parsedRightOperand = parseOperand(rightOperand);
		int[] improperFracLeftOperand = toImproperFrac(parsedLeftOperand);
		int[] improperFracRightOperand = toImproperFrac(parsedRightOperand);
		int[] resultCommonDenominator = commonDenominator(improperFracLeftOperand, improperFracRightOperand);
		if (operator.equals("+")){
			return addition(resultCommonDenominator);
		}
		else if (operator.equals("-")){
			return subtraction(resultCommonDenominator);
		}
		else if (operator.equals("*")){
			return multiplication(resultCommonDenominator);
		}
		else if (operator.equals("/")){
			return division(resultCommonDenominator);
		}
		else {
			String error = "Encountered unexpected error.";
			return error;
		}
	}
	public static String[] parseInput(String userInput){
		String[] separateOperandsOperators = userInput.split(" ");
		return separateOperandsOperators;
	}
	public static int[] parseOperand(String operand){
		String[] wholeNumber = operand.split("_");
		String[] splitNumeratorDenominator = wholeNumber[1].split("/");
		String[] threeDigitsSort = {wholeNumber[0], splitNumeratorDenominator[0], splitNumeratorDenominator[1]};
		int[] threeIntsInOrder = new int[3];
	    for (int i=0; i < threeDigitsSort.length; i++) {
	    	threeIntsInOrder[i] = Integer.parseInt(threeDigitsSort[i]);
	    }
	    return threeIntsInOrder;
	}
	public static int[] toImproperFrac(int[] operand){
		operand[1] = operand[2] * operand[0] + operand[1];
		int[] improperFraction = {operand[1], operand[2]};
		return improperFraction;
	}
	public static int[] commonDenominator(int[] leftOperand, int[] rightOperand){
		int leftNumerator = leftOperand[0] * rightOperand[1];
		int rightNumerator = rightOperand[0] * leftOperand[1];
		int denominator = leftOperand[1] * rightOperand[1];
		int[] twoCommonFractions = {leftNumerator, rightNumerator, denominator};
		return twoCommonFractions;
	}
	public static String addition(int[] expression){
		int intNumerator = expression[0] + expression[1];
		String stringNumerator = Integer.toString(intNumerator);
		String answerString = stringNumerator + "/" + expression[2];
		return answerString;
	}
	public static String subtraction(int[] expression){
		int intNumerator = expression[0] - expression[1];
		String stringNumerator = Integer.toString(intNumerator);
		String answerString = stringNumerator + "/" + expression[2];
		return answerString;
	}
	public static String multiplication(int[] expression){
		int intNumerator = expression[0] * expression[1];
		int intDenominator = expression[2] * expression[2];
		String stringNumerator = Integer.toString(intNumerator);
		String stringDenominator = Integer.toString(intDenominator);
		String answerString = stringNumerator + "/" + stringDenominator;
		return answerString;
	}
	public static String division(int[] expression){
		int intNumerator = expression[0] * expression[2];
		int intDenominator = expression[1] * expression[2];
		String stringNumerator = Integer.toString(intNumerator);
		String stringDenominator = Integer.toString(intDenominator);
		String answerString = stringNumerator + "/" + stringDenominator;
		return answerString;
	}
}