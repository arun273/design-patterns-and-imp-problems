package com.arun.sample;


import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {

		System.out.println("Counting sort in Java");
		int[] input = { 5, 1, 4, 2, 1 };

		// find the smallest and the largest value
		int min = input[0];
		int max = input[0];
		for (int i = 1; i < input.length; i++) {
			if (input[i] < min) {
				min = input[i];
			} else if (input[i] > max) {
				max = input[i];
			}
		}

		System.out.println("integer array before sorting");
		System.out.println(Arrays.toString(input));

		// sorting array using Counting Sort Algorithm
		countingSort(input, max);

		System.out
				.println("integer array after sorting using counting sort algorithm");
		System.out.println(Arrays.toString(input));

		// Geeksforgeeks logic

		char arr[] = { 'g', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'g', 'e', 'e',
				'k', 's' };

		sort(arr);
		System.out.print("Sorted character array is : ");
		for (int i = 0; i < arr.length; ++i)
			System.out.print(arr[i]);

	}

	private static void countingSort(int[] input, int k) {
		// create buckets
		int counter[] = new int[k + 1];

		// fill buckets
		for (int i : input) {
			counter[i]++;
		}

		// sort array
		int ndx = 0;
		for (int i = 0; i < counter.length; i++) {
			while (0 < counter[i]) {
				input[ndx++] = i;
				counter[i]--;
			}
		}
	}

	private static void sort(char arr[]) {
		int n = arr.length;

		// The output character array that will have sorted arr
		char output[] = new char[n];

		// Create a count array to store count of individual
		// characters and initialize count array as 0
		int count[] = new int[256];
		for (int i = 0; i < 256; ++i)
			count[i] = 0;

		// store count of each character
		for (int i = 0; i < n; ++i)
			++count[arr[i]];

		// Change count[i] so that count[i] now contains actual
		// position of this character in output array
		for (int i = 1; i <= 255; ++i)
			count[i] += count[i - 1];

		// Build the output character array
		for (int i = 0; i < n; ++i) {
			output[count[arr[i]] - 1] = arr[i];
			--count[arr[i]];
		}

		// Copy the output array to arr, so that arr now
		// contains sorted characters
		for (int i = 0; i < n; ++i)
			arr[i] = output[i];
	}

}

