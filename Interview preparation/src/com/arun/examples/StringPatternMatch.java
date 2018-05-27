package com.arun.examples;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringPatternMatch {

	public static void search(String txt, String pat) {
		int M = pat.length();
		int N = txt.length();

		HashMap<Integer, String> hashMap = new LinkedHashMap<Integer, String>();

		/* A loop to slide pat one by one */
		for (int i = 0; i <= N - M; i++) {
			int j;
			String temp = "";
			/*
			 * For current index i, check for pattern match
			 */
			for (j = 0; j < M; j++) {
				temp += txt.charAt(i + j);
			}
			hashMap.put(i, temp);

		}

		for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {

			if (entry.getValue().equals(pat)) {

				System.out.println("Pattern matched Index is " + entry.getKey());

			}

		}

	}

	public static void main(String[] args) {

		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		search(txt, pat);
	}
}
