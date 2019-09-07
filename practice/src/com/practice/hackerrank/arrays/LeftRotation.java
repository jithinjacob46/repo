/**
 * 
 */
package com.practice.hackerrank.arrays;

/**
 * @author jacob
 *
 */
public class LeftRotation {

	/**
	 * @param n
	 * @param d
	 * @param a
	 */
	private static void rotateLeft(int n, int d, int[] a) {
		// TODO Auto-generated method stub

		d = d % n;
		// int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			int temp = a[(i + d) % n];
			// arr[i] = temp;
			System.out.print(temp + " ");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 5;
		int d = 4;
		int[] a = { 1, 2, 3, 4, 5 };
		rotateLeft(n, d, a);
	}

}
