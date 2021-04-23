package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {
	@Test
	public void twoNumbers() {
		Max maxTest = new Max();
		int first = 19;
		int second = 64;
		int expected = 64;
		int result = maxTest.max(first, second);
		Assert.assertEquals(expected, result);
	}

	@Test
	public void threeNumbers() {
		Max maxTest = new Max();
		int first = 88;
		int second = 93;
		int third = 89;
		int expected = 93;
		int result = maxTest.max(first, second, third);
		Assert.assertEquals(expected, result);
	}

	@Test
	public void fourNumbers() {
		Max maxTest = new Max();
		int first = 84;
		int second = 70;
		int third = 57;
		int fourth = 44;
		int expected = 84;
		int result = maxTest.max(first, second, third, fourth);
		Assert.assertEquals(expected, result);
	}
}