// Herman Peng
// September 24, 2016
// Math Library Creation
// 1st Period

/* The library created here contains 22 different and unique mathematical methods devised to do specific
 * actions to give a specific result. This class is connected to class "DoMath" and thus given the ability
 * to properly insert input to give result. Comments are written out before each method to give
 * greater in depth knowledge about that method to the reader. 
 */

public class Calculate {
	/* square - A call to square returns the square of the value passed. The method accepts an integer and
	 * returns an integer.
	 */
	public static int square(int value){
		return value * value;
	}
	/* cube - A call to cube returns the cube of the value passed. The method accepts an integer and returns
	 * an integer.
	 */
	public static int cube(int value){
		return value * value * value;
	}
	/* average (two values) - A call to average returns the average of the values passed to it. This method
	 * accepts two doubles and returns a double.
	 */
	public static double average(double valueOne, double valueTwo){
		return (valueOne + valueTwo)/2;
	}
	/* average (three values) - Another average method. This one accepts three doubles and returns a double.
	 * The name is the same, the difference is in the header and the calculation. (The ability to define two
	 * or more different methods with the same name but different method signatures is called overloading.
	 * This average method is an example of an "overloaded method".)
	 */
	public static double average(double valueOne, double valueTwo, double valueThree){
		return (valueOne + valueTwo + valueThree)/3;
	}
	/* toDegrees - A call to toDegrees converts an angle measure given in raidans into degrees. The method 
	 * accepts a double and returns a double. The method should use 3.14159 as an approximation for pi.
	 */
	public static double toDegrees(double radian){
		return radian * 180 / 3.14159;
	}
	/* toRadians - A call to toRadians converts an angle measure given in degrees into radians. The method
	 * accepts a double and returns a double. The method should use 3.14159 as an approximation for pi.
	 */
	public static double toRadians(double degree){
		return degree * 3.14159 / 180;
	}
	/* discriminant - A call to discriminant provides the coefficients of a quadratic equation in standard
	 * form (a, b, and c) and returns the value of the discriminant. The method accepts three doubles and 
	 * returns a double.
	 */
	public static double discriminant(double b, double a, double c){
		return (b * b) - (4 * a * c);
	}
	/* toImproperFrac - A call to toImproperFrac converts mixed number (with its pieces provided separately 
	 * in the order numerator then denominator) into a mixed number. The method accepts three integers and 
	 * returns a String
	 */
	public static String toImproperFrac(int wholeNumber, int numerator, int denominator){
		return ((wholeNumber * denominator) + numerator) + "/" + denominator;
	}
	/* toMixedNum - A call to toMixedNum converts an improper fraction (with its pieces provided separately 
	 * in the order numerator then denominator) into a mixed number. The method accepts two integers and 
	 * returns a String
	 */
	public static String toMixedNum(int numerator, int denominator){
		int z = (numerator/denominator);
		int a = (numerator % denominator);
		String text = z + "_" + a + "/" + denominator;
		return text;
	}
	/* foil - A call to foil converts a binomial multiplication of the form (ax + b)(cx + d) into a quadratic
	 * equation of the form ax^2 + bx + c. The method accepts four integers and a String and then returns a
	 * String
	 */
	public static String foil(int a, int b, int c, int d, String variable){
		return (a * c) + variable + "^2 + " + ((a * d) + (b * c)) + variable + " + " + (b * d);
	}
	/* isDivisibleBy - A call to isDivisibleBy determines whether or not one integer is evenly divisible by 
	 * another. The method accepts two integers and returns a boolean.
	 */
	public static boolean isDivisibleBy(int integerOne, int integerTwo){
		if (integerOne % integerTwo == 0){
			return true;
		}
		else{
			return false;
		}
	}
	/* absValue - A call to absValue returns the absolute value of the number passed. The method accepts a 
	 * double and returns a double
	 */
	public static double absValue(double value){
		if (value < 0){
			return value * -1;
		}
		else{
			return value;
		}
	}
	/* maxPt1 - A call to max returns the larger of the values passed. The method accepts two integers and 
	 * returns an integer.
	 */
	public static int max(int valueOne, int valueTwo){
		if (valueOne > valueTwo){
			return valueOne;
		}
		else{
			return valueTwo;
		}
	}
	/* maxPt2 - Overload the max method. This one accepts three doubles and returns a double.
	 */
	public static double max(double valueOne, double valueTwo, double valueThree){
		if (valueOne > valueTwo && valueOne > valueThree){
			return valueOne;
		}
		else if (valueTwo > valueOne && valueTwo > valueThree){
			return valueTwo;
		}
		else{
			return valueThree;
		}
	}
	/* min - A call to min returns the larger of the values passed. The method accepts two integers and 
	 * returns an integer
	 */
	public static int min(int valueOne, int valueTwo){
		if (valueOne < valueTwo){
			return valueOne;
		}
		else{
			return valueTwo;
		}
	}
	/* round2 - A call to round2 rounds a double correctly to 2 decimal places and returns a double.
	 */
	public static double round2(double value){
		value = (value * 100) + 0.5;
		value = (int)value;
		value = (double)value;
		value = value/100;
		return value;
	}
	/* exponent - A call to exponent raises a value to a positive integer power. The method accepts a 
	 * double and an integer and returns a double. For the time being, you can assume that the exponent
	 * is positive.
	 */
	public static double exponent(double base, int exponentRounds){
		int i;
		double multiplier = base;
		for (i = 2; i <= exponentRounds; i++){
			base = base * multiplier;
		}
		return base;
	}
	/* factorial - A call to factorial returns the factorial of the value passed. The method accepts an
	 * integer and returns an integer. For the time being, you can assume that the exponent is positive.
	 */
	public static int factorial(int value){
		int total = 1;
		for (int i = value; i > 0; i--){
			total *= i;
		}
		return total;
	}
	/* isPrime - A call to isPrime determines whether or not an integer is prime. The method accepts an 
	 * integer and returns a boolean. To receive full credit, the method should call another method you've
	 * already written for this library. 
	 */
	public static boolean isPrime(int value){
		boolean prime = true;
		value = (int) absValue(value);
		if (value % 2 == 0){
				prime = false;
		}
		return prime;
	}
	/* gcf - A call to gcf finds the greatest common factor of two integers. The method accepts two positive
	 * integers and returns an integer. For the time being, you can assume that both integers are positive. 
	 * To receive full credit, the method should call another method you've already written for this library.
	 */
	public static int gcf(int valueOne, int valueTwo){
		int gcf = 1;
		for(int i = 1; i <= valueTwo; i++){
			if(isDivisibleBy(valueOne, i) && isDivisibleBy(valueTwo,i)){
				gcf = i;
			}
		}
		return gcf;
	}
	/* sqrt - A call to sqrt returns an approximation of the square root of the value passed, accurate to two
	 * decimal places. The method accepts a double and returns a double. (While the class algorithm for 
	 * this method requires recursion, it is not expected at this point. Feel free to use trial and error
	 * and multiplication to find an appropriate value.)
	 */
	public static double sqrt(double value){
		if (value < 0){
			throw new IllegalArgumentException("Cannot root negatives");
		}
		double num;
		double squareRoot = value/2;
		do {
			num = squareRoot;
			squareRoot = (num + (value/num)) / 2;
		}
		while ((num - squareRoot) != 0);
		return Calculate.round2(squareRoot);
	}
	/* quadForm - A call to quadform uses the coefficients of a quadratic equation in standard form and uses
	 * the quadratic formula to approximate the real roots, if any. The method accepts three integers and
	 * returns a String. To receive full credit, the method should call multiple methods that you've already
	 * written for this library.
	 */
	public static String quadForm(double a, double b, double c){
		double positiveQuadratic = 0;
		double negativeQuadratic = 0;
		double variable = (b * b) - (4 * a * c);
		if(a < 0 && sqrt(variable) < 0){
			return "no real roots";
		}
		else{
			positiveQuadratic = -b + sqrt(((b * b) - (4 * a * c)));
			negativeQuadratic = -b - sqrt(((b * b) - (4 * a * c)));
		}
		if(positiveQuadratic == negativeQuadratic){
			return "" + positiveQuadratic;
		}
		else{
			return negativeQuadratic + " and " + positiveQuadratic;
		}
	}
}
