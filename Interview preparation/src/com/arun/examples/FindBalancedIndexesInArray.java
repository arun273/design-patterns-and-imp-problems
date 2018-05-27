package com.arun.examples;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindBalancedIndexesInArray {

	public static void main(final String[] args) {
		System.out.println(getIndexes(new int[] { 5, 0, -5, 4 }));
		System.out.println(getIndexes(new int[] { 5, 0, -5, 4, 0, 2, 2 }));
		System.out.println(getIndexes(new int[] { 1, 2, 1, 3 }));
	}

	private static Set<Integer> getIndexes(final int[] arr) {
		final Set<Integer> indexes = new HashSet<Integer>();
		int leftElementsSum = 0;
		if (arr == null || arr.length == 0) {
			// return Empty set
			return indexes;
		}
		if (arr.length == 1) {
			// If it is Only One Element, previous and next are equal..
			indexes.add(0);
			return indexes;
		}
		/**
		 * Product Map should hold the Product Of The the particular index.
		 */
		final Map<Integer, Integer> productMap = new HashMap<Integer, Integer>();

		int product = arr[arr.length - 1];
		/**
		 * last But one
		 */
		productMap.put(arr.length - 2, product);
		/**
		 * For the last in Array the Product should be zero.
		 */
		productMap.put(arr.length - 1, 0);
		/**
		 * Calculate Product of the array elements
		 */
		for (int i = arr.length - 2; i > 0; i--) {
			product *= arr[i];
			productMap.put(i - 1, product);
		}
		/**
		 * For the First Element.
		 */
		productMap.put(0, product);
		/**
		 * Time Complexity O(n)
		 */
		for (int i = 0; i < arr.length; i++) {
			// Calculate Previous Elements sum
			if (i != 0) {
				leftElementsSum += arr[i - 1];
			}
			// calculate Product
			// Check Previous Sum and Next Multiplication is Equal..
			/**
			 * The Time Complexity of Map.get(key) is O(1)
			 */
			if (leftElementsSum == productMap.get(i)) {
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
