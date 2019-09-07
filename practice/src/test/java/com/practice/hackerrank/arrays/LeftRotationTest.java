/**
 * 
 */
package com.practice.hackerrank.arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jacob
 *
 */
public class LeftRotationTest {

	@Test
	public void testPositive() {

		int n = 5;
		int d = 4;
		int[] a = { 1, 2, 3, 4, 5 };
		int[] array = LeftRotation.rotateLeft(n, d, a);
		int[] b = { 5, 1, 2, 3, 4 };
		Assert.assertArrayEquals(b, array);

	}

	@Test
	public void testPositive2() {

		int n = 5;
		int d = 14;
		int[] a = { 1, 2, 3, 4, 5 };
		int[] array = LeftRotation.rotateLeft(n, d, a);
		int[] b = { 5, 1, 2, 3, 4 };
		Assert.assertArrayEquals(b, array);

	}

	@Test
	public void testSame() {

		int n = 5;
		int d = 10;
		int[] a = { 1, 2, 3, 4, 5 };
		int[] array = LeftRotation.rotateLeft(n, d, a);
		Assert.assertArrayEquals(a, array);

	}

	@Test
	public void testZero() {

		int n = 5;
		int d = 0;
		int[] a = { 1, 2, 3, 4, 5 };
		int[] array = LeftRotation.rotateLeft(n, d, a);
		Assert.assertArrayEquals(a, array);

	}

	@Test
	public void testNull() {

		int n = 5;
		int d = 4;
		int[] a = null;
		int[] array = LeftRotation.rotateLeft(n, d, a);
		Assert.assertArrayEquals(null, array);

	}

	@Test
	public void testEmpty() {

		int n = 0;
		int d = 4;
		int[] a = {};
		int[] array = LeftRotation.rotateLeft(n, d, a);
		Assert.assertArrayEquals(null, array);

	}

	@Test
	public void testNegative() {

		int n = 5;
		int d = -4;
		int[] a = { 1, 2, 3, 4, 5 };
		int[] array = LeftRotation.rotateLeft(n, d, a);
		Assert.assertArrayEquals(null, array);

	}

}
