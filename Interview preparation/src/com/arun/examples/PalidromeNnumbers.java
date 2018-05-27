package com.arun.examples;

import java.util.Scanner;

public class PalidromeNnumbers {

	public static void main(String[] args) {

		int n, b, rev = 0, test;

		Scanner scanner = new Scanner(System.in);
		test = scanner.nextInt();

		int limit = scanner.nextInt();
		
		System.out.println(limit);

		for (int i = 1; i <= limit; i++) {
			n = i;
			while (n > 0) {
				b = n % 10;
				rev = rev * 10 + b;
				n = n / 10;
			}
			if (rev == i) {
				System.out.print(i + " ");
			}
			rev = 0;
		}

	}

}
