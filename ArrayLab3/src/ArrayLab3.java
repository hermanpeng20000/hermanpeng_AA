import java.util.*;

/* Herman Peng
 * 1st period
 * November 7th, 2016
 * ArrayLab3
 */

public class ArrayLab3 {
	public static void main(String[] args){
		// Setting up all the test variables
		int[] a1 = { 5, 10, 15, 20, 25, 30, 35, 40 };
		int[] a2 = { 7, 14, 21, 28, 35, 42, 49, 56 };
		int[] sumArr = sum(a1, a2);
		int appendNum = 200;
		// Setting up all the method test scenarios
		int[] appendArr = append(a1, appendNum);
		int removeIdx = 5;
		int[] removeArr = remove(a2, removeIdx);
		int sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
		// Printing out each result onto the console
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr));
		System.out.println(sumOfEvens);
	}
	
	/* "sum" is a method that accepts two arrays of integers
	 * "arr2" and "arr2" and returns an array of integers, in 
	 * which every element is the sum of the elements at that
	 * index for the arrays "arr1" and "arr2".
	 */
	public static int[] sum(int[] arr1, int[] arr2) {
		// At each position add value of "arr1" and "arr2" to "arr3"
		int arr3[] = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			arr3[i] = arr1[i] + arr2[i];
		}
		return arr3;
	}
	
	/* "append" is a method that accepts an array of integers
	 * "arr" of length n and an integer "num", and returns an
	 * array of integers of length n+1 that consists of the
	 * two elements of "arr" with "num" appended to the end.
	 */
	public static int[] append(int[] arr, int num) {
		// Create "arr2" of length arr.length + 1, add "num" to end
		int arr2[] = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i ++) {
			arr2[i] = arr[i];
		}
		arr2[arr2.length - 1] = num;
		return arr2;
	}
	
	/* "remove" is a method that accepts an array of integers
	 * "arr" and an integer "idx" and returns an array of integers
	 * consisting of all of the elements of "arr" except for the 
	 * elements at index "idx".
	 */
	public static int[] remove(int[] arr, int idx) {
		// Create "arr2" of 1 less length than "arr"
		int arr2[] = new int[arr.length-1];
		int counter = 0;
		// For every value of "arr" before "idx", copy onto "arr2"
		for (int i = 0; i < idx; i++){
			arr2[i] = arr[i];
			counter = i;
		}
		// Skip over "idx", copy rest of list
		for (int i = idx + 1; i <= arr.length - 1; i++) {
			arr2[counter + 1] = arr[i];
			counter ++;
		}
		return arr2;
	}
	
	/* "sumEven" is a method that accepts an array of integers 
	 * "arr" and returns an integer containing the sum of the
	 * elements at the even indices of "arr"
	 */
	public static int sumEven(int [] arr) {
		// Create for loop that copies every other value of "arr"
		int sum = 0;
		for (int i = 0; i <= arr.length; i= i + 2) {
			sum += arr[i];
		}
		return sum;
	}
	
	/* "rotateRight is a method that accepts an array of integers
	 * "arr" and does not return a value. The "rotateRight" method
	 * moves each element of arr one index to the right.
	 */
	public static void rotateRight(int[] arr) {
		// Shift every value one to the right
		int[] arr2 = new int [arr.length];
		for (int i = 0; i < arr.length - 2; i++) {
			arr2[i + 1] = arr[i];
		}
		// Make the first value of "arr2" the last of "arr"
		arr2[0] = arr[arr.length - 1];
	}
}
