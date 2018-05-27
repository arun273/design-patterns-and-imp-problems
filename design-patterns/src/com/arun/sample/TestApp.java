package com.arun.sample;

import java.util.ArrayList;
import java.util.Arrays;

public class TestApp {

	public static <T> void main(String[] args) {

		String s1 = "madam";

		int i = 0, j = s1.length() - 1;
		boolean check = true;
		while (i < j) {

			if (s1.charAt(i++) != s1.charAt(j--)) {
				check = false;
				break;
			}

		}
		
		if(check){
			System.out.println("Palidrom");
		}else{
			System.out.println("Not ");
		}
		
		
		Object[] elementData = new Object[10];
		T[] copy = (T[]) new Object[5];

		copy[0] = (T) "gte";
		copy[1] = (T) "wsd";
		copy[2] = (T) "dfg";
		copy[3] = (T) "dfe";
		copy[4] = (T) "ffg";

		elementData = copy;

		final ArrayList<String> finalarrayList = new ArrayList<>(5);
		ArrayList<String> nonFinalArrayList = new ArrayList<>();

		finalarrayList.add("A");
		finalarrayList.add("A");
		finalarrayList.add("A");

		finalarrayList.add("A");
		finalarrayList.add("A");
		finalarrayList.add("D");
		finalarrayList.add("M");
		finalarrayList.add("V");
		finalarrayList.add("C");

		System.out.println(finalarrayList);
		System.out.println(Arrays.toString(copy));

	}
}
