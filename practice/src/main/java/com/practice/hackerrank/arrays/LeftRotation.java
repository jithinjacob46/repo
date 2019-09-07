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
	 * @param d
	 * @param a
	 * @return
	 */
	static int[] rotateLeft(int d, int[] a) {

		if (d >= 0 && a != null) {

			int n = a.length;
			if (n == 0) {
				return a;
			}
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

		int d = 4;
		int[] a = { 1, 2, 3, 4, 5 };
		System.out.print(Arrays.toString(rotateLeft(d, a)));
	}

}
