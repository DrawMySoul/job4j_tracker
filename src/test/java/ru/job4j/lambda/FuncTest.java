package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FuncTest {
	@Test
	public void whenLinearFunctionThenLinearResults() {
		List<Double> result = Func.diapason(5, 8, x -> 2 * x + 1);
		List<Double> expected = Arrays.asList(11D, 13D, 15D);
		assertThat(result, is(expected));
	}

	@Test
	public void whenQuadraticFunction() {
		List<Double> result = Func.diapason(5, 8, x -> Math.pow((4 * x), 2) + 3 * x + 1);
		List<Double> expected = Arrays.asList(416D, 595D, 806D);
		assertThat(result, is(expected));
	}

	@Test
	public void whenExponentialFunction() {
		List<Double> result = Func.diapason(5, 8, x -> Math.pow(2, x));
		List<Double> expected = Arrays.asList(32D, 64D, 128D);
		assertThat(result, is(expected));
	}
}