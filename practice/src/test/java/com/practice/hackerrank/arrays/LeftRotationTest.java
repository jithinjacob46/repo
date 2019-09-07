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
	public void test() {

		int n = 5;
		int d = 4;
		int[] a = { 1, 2, 3, 4, 5 };
		int[] array = LeftRotation.rotateLeft(n, d, a);
		int[] b = { 5, 1, 2, 3, 4 };
		Assert.assertArrayEquals(b, array);

	}

}
