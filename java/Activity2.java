//Activity 2: In this activity, we are writing a program to check if the sum of all the 10's in the array is exactly 30
package activities;

import java.util.Arrays;

public class Activity2 {

	public static void main(String[] args) {
	
		int [] myArray = {10,77,10,54,-11,10};
		System.out.println("Original Array: " + Arrays.toString(myArray));	
		
		int searchNum = 10;
		int fixedSum = 30;
		
		System.out.println("Result: " + result(myArray, searchNum, fixedSum));
	}
	
	public static boolean result(int[] numbers, int searchNum, int fixedSum) {
		
		int tempSum = 0;
		for(int number: numbers)
		{
				if (number == searchNum) {
					tempSum += searchNum;
				}
				if (tempSum > fixedSum) {
					break;
				}
		}
		return tempSum == fixedSum;
	}
}
