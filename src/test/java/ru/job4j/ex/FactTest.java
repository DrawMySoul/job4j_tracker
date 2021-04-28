package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactTest {
	@Test(expected = IllegalArgumentException.class)
	public void whenException() {
		Fact fact = new Fact();
		fact.calc(-10);
	}

	@Test
	public void normalTest() {
		Fact fact = new Fact();
		int result = fact.calc(10);
		assertThat(result, is(3_628_800));
	}
}