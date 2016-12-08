import java.util.*;

/* Herman Peng
 * 1st period
 * December 5th, 2016
 * StringSplit Assignment
 */
public class FracCalc {
	public static void main(String[] args){
		String input;
		String answer;
		Scanner console = new Scanner(System.in);
		do {
			System.out.println("Please enter in your input. Type \"quit\" to exit.");
			input = console.nextLine();
			answer = produceAnswer(input);
			System.out.println(answer);
		} while (input != "quit");
	}
	public static String produceAnswer(String inputFromMain){
		String[] resultParseInput = parseInput(inputFromMain);
		int[] resultParseOperand = parseOperand(resultParseInput);
		int[] resultToImproperFrac = toImproperFrac(resultParseOperand);
		int[] resultCommonDenominator = commonDenominator(resultToImproperFrac);
		if (resultCommonDenominator[2] == 1){
			return addition(resultCommonDenominator);
		}
		else if (resultCommonDenominator[2] == 2){
			return subtraction(resultCommonDenominator);
		}
		else if (resultCommonDenominator[2] == 3){
			return multiplication(resultCommonDenominator);
		}
		else if (resultCommonDenominator[2] == 4){
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
	public static int[] parseOperand(String[] fromParseInput){
		if (fromParseInput[1] == "+"){
			fromParseInput[1] = "1";
		}
		String[] firstOperand = fromParseInput[0].split("_");
		firstOperand = fromParseInput[0].split("/");
		String[] secondOperand = fromParseInput[2].split("_");
		secondOperand = fromParseInput[2].split("/");
		int[] fullExpressionBrokenDown = new int[7];
		// MAKE FOR STATEMENT TO CONVERT EACH STRING INTO THINGS FOR INT ARRAY
		for (int i = 0; i <= 2; i++){
			fullExpressionBrokenDown[i] = Integer.parseInt(firstOperand[i]);
		}
		for (int i = 4; i <= 7; i++){
			fullExpressionBrokenDown[i] = Integer.parseInt(secondOperand[i]);
		}
		return fullExpressionBrokenDown;
	}
	public static int[] toImproperFrac(int[] operand){
	int wholeNumber1 = operand[0];
	int numerator1 = operand[1];
	int denominator1 = operand[2];
	int operator = operand[3];
	int wholeNumber2 = operand[4];
	int numerator2 = operand[5];
	int denominator2 = operand[6];
	numerator1 = denominator1 * wholeNumber1;
	numerator2 = denominator2 * wholeNumber2;
	int[] improperFraction = new int[5];
	improperFraction[0] = numerator1;
	improperFraction[1] = denominator1;
	improperFraction[2] = operator;
	improperFraction[3] = numerator2;
	improperFraction[4] = denominator2;
	return improperFraction;
	}
	public static int[] commonDenominator(int[] uncommonDenominators){
		int commonDenominator = uncommonDenominators[1] * uncommonDenominators[4];
		uncommonDenominators[1] = commonDenominator;
		uncommonDenominators[4] = commonDenominator;
		return uncommonDenominators;
	}
	public static String addition(int[] expression){
		int intNumerator = expression[0] + expression[3];
		String stringNumerator = Integer.toString(intNumerator);
		String answerString = stringNumerator + "/" + expression[1];
		return answerString;
	}
	public static String subtraction(int[] expression){
		int intNumerator = expression[0] - expression[3];
		String stringNumerator = Integer.toString(intNumerator);
		String answerString = stringNumerator + "/" + expression[1];
		return answerString;
	}
	public static String multiplication(int[] expression){
		int intNumerator = expression[0] * expression[3];
		int intDenominator = expression[1] * expression[4];
		String stringNumerator = Integer.toString(intNumerator);
		String stringDenominator = Integer.toString(intDenominator);
		String answerString = stringNumerator + "/" + stringDenominator;
		return answerString;
	}
	public static String division(int[] expression){
		int intNumerator = expression[0] * expression[4];
		int intDenominator = expression[1] * expression[3];
		String stringNumerator = Integer.toString(intNumerator);
		String stringDenominator = Integer.toString(intDenominator);
		String answerString = stringNumerator + "/" + stringDenominator;
		return answerString;
	}
}
