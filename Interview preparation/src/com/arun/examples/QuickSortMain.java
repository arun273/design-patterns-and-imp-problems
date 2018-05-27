package com.arun.examples;

import java.util.Arrays;

public class QuickSortMain {

	private static int array[];

	public static void sort(int[] arr) {

		if (arr == null || arr.length == 0) {
			return;
		}
		array = arr;
		quickSort(0, array.length - 1);
	}

	private static void quickSort(int left, int right) {

		int i = left;
		int j = right;
		// find pivot number, we will take it as mid
		int pivot = array[left + (right - left) / 2];

		while (i <= j) {
			/**
			 * In each iteration, we will increment left until we find element
			 * greater than pivot We will decrement right until we find element
			 * less than pivot
			 */
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchange(i, j);
				// move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (left < j)
			quickSort(left, j);
		if (i < right)
			quickSort(i, right);
	}

	private static void exchange(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String a[]) {
		int[] input = { 33, 21, 45, 64, 55, 34, 11, 8, 3, 5, 1 };
		System.out.println("Before Sorting input : ");
		System.out.println(Arrays.toString(input));
		sort(input);
		System.out.println("==================");
		System.out.println("After Sorting : ");
		printArray(input);

		int[] inputArry = { 101, 21, 45, 99, 55, 34, 11, 8, 3, 80, 1 };

		System.out.println("Before Sorting inputArry: ");
		System.out.println(Arrays.toString(input));

		sort(inputArry, 0, inputArry.length - 1);
		System.out.println("==================");
		System.out.println("After Sorting : ");
		printArray(inputArry);

	}

	/*
	 * This function takes last element as pivot, places the pivot element at
	 * its correct position in sorted array, and places all smaller (smaller
	 * than pivot) to left of pivot and all greater elements to right of pivot
	 */
	private static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than or
			// equal to pivot
			if (arr[j] <= pivot) {
				i++;

				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	/*
	 * The main function that implements QuickSort() arr[] --> Array to be
	 * sorted, low --> Starting index, high --> Ending index
	 */
	private static void sort(int arr[], int low, int high) {

		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
