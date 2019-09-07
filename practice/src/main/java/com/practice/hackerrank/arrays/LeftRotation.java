/**
 * 
 */
package com.practice.hackerrank.arrays;

import java.util.Arrays;

/**
 * @author jacob
 *
 */
public class LeftRotation {

	/**
	 * @param n
	 * @param d
	 * @param a
	 * @return
	 */
	private static int[] rotateLeft(int n, int d, int[] a) {

		if (n > 0 && d >= 0 && a != null && a.length == n) {

			d = d % n;
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				int temp = a[(i + d) % n];
				arr[i] = temp;
			}
			return arr;
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int n = 5;
		int d = 4;
		int[] a = { 1, 2, 3, 4, 5 };
		int[] array = rotateLeft(n, d, a);
		System.out.print(Arrays.toString(array));
	}

}
