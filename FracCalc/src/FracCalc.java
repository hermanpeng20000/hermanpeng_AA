import java.util.*;

/* Herman Peng
 * 1st period
 * October 31st, 2016
 * StringSplit Assignment
 */
public class FracCalc {
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter in your input.");
		String input = console.next();
		System.out.println(produceAnswer(input));
	}
	public static String produceAnswer(String inputFromMain){
		String [] firstOperand = inputFromMain.split("-");
		return firstOperand.toString();
	}
}
