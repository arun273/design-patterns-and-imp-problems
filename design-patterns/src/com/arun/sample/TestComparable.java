package com.arun.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestComparable {
	 public static void main(String[] args) {
	      // Sort and search an "array" of Strings
	      String[] array = {"Hello", "hello", "Hi", "HI"};
	 
	      // Use the Comparable defined in the String class
	      Arrays.sort(array);
	      System.out.println(Arrays.toString(array));  // [HI, Hello, Hi, hello]
	 
	      // Try binary search - the array must be sorted
	      System.out.println(Arrays.binarySearch(array, "Hello")); // 1
	      System.out.println(Arrays.binarySearch(array, "HELLO")); // -1 (insertion at index 0)
	 
	      // Sort and search a "List" of Integers
	      List<Integer> lst = new ArrayList<Integer>();
	      lst.add(22);  // auto-box
	      lst.add(11);
	      lst.add(44);
	      lst.add(33);
	      Collections.sort(lst);    // Use the Comparable of Integer class
	      System.out.println(lst);  // [11, 22, 33, 44]
	      System.out.println(Collections.binarySearch(lst, 22)); // 1
	      System.out.println(Collections.binarySearch(lst, 35)); // -4 (insertion at index 3)
	   }

}
