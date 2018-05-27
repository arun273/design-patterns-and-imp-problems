package com.arun.examples;

import java.util.HashSet;
import java.util.Set;

public class FindBalancedIndexes {

	public static void main(String[] args) {
		System.out.println(getIndexes(new int[] { 5, 0, -5, 4 }));
		System.out.println(getIndexes(new int[] { 1, 2, 1 }));
	}

	private static Set<Integer> getIndexes(int[] arr) {
		Set<Integer> indexes = new HashSet<Integer>();
		int leftElementsSum = 0;
		int rightElementsMultiplication = 0;
		if (arr == null || arr.length == 0 || arr.length == 2) {
			// return Empty set
			return indexes;
		}
		if (arr.length == 1) {
			// If it is Only One Element, previous and next are equal..
			indexes.add(0);
			return indexes;
		}
		/**
		 * Time Complexity O(n)
		 */
		for (int i = 1; i < arr.length; i++) {
			// Calculate Previous Elements sum
			leftElementsSum += arr[i - 1];
			// Reset last element
			rightElementsMultiplication = arr[arr.length - 1];
			// Calculate multiplication
			/**
			 * Time Complexity becomes here O(n2)[N square]
			 */
			for (int j = arr.length - 2; j > i; j--) {
				rightElementsMultiplication = rightElementsMultiplication * arr[j];
			}
			// Check Previous Sum and Next Multiplication is Equal..
			if (leftElementsSum == rightElementsMultiplication) {
				indexes.add(i);
			}
		}
		/**
		 * For the last element in the array, if the SUM of 0 to N-2 Elements
		 * are ZERO, then include last Element Index.
		 */
		if (leftElementsSum == 0) {
			indexes.add(arr.length - 1);
		}
		return indexes;
	}
}
