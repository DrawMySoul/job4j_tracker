package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
	@Test
	public void when979to397then663() {
		Point a = new Point(9, 7, 9);
		Point b = new Point(3, 9, 7);
		double result = a.distance3d(b);
		double expected = 6.63;
		Assert.assertEquals(expected, result, 0.01);
	}

	@Test
	public void when285to346then424() {
		Point a = new Point(2, 8, 5);
		Point b = new Point(3, 4, 6);
		double result = a.distance3d(b);
		double expected = 4.24;
		Assert.assertEquals(expected, result, 0.01);
	}

	@Test
	public void when882to865then360() {
		Point a = new Point(8, 8, 2);
		Point b = new Point(8, 6, 5);
		double result = a.distance3d(b);
		double expected = 3.60;
		Assert.assertEquals(expected, result, 0.01);
	}
}