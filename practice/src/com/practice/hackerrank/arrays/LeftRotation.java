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

		d = d % n;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			int temp = a[(i + d) % n];
			arr[i] = temp;
		}
		return arr;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int n = 5;
		int d = 4;
		int[] a = { 1, 2, 3, 4, 5 };
		System.out.print(Arrays.toString(rotateLeft(n, d, a)));
	}

}
