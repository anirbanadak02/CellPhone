package com.energyone;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static int[] originalArray;
	public static int m,n;
	public static boolean[] visitedArray;
	private static boolean result = false;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int count = 0; count < T; count++) {

			n = scanner.nextInt();
			originalArray = new int[n];
			visitedArray = new boolean[n];
			Arrays.fill(visitedArray, false);
			m = scanner.nextInt();
			for (int index = 0; index < n; index++) {
				originalArray[index] = scanner.nextInt();
			}
			result = false;
			isPossible(0);
			if (result) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		scanner.close();

	}

	private static void isPossible(int i) {
		if (i > n || i + m >= n || i == n - 1) {
			result = true;
			return;
		}
		if (visitedArray[i] == true) {
			return;
		}
		visitedArray[i] = true;
		if (i + 1 < n && originalArray[i + 1] == 0) {
			isPossible(i + 1);
		}
		if (i - 1 >= 0 && originalArray[i - 1] == 0) {
			isPossible(i - 1);
		}
		if (i + m < n && originalArray[i + m] == 0) {
			isPossible(i + m);
		}
	}
}
