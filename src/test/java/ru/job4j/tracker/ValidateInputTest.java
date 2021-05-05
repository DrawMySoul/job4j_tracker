package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {
	@Test
	public void whenInvalidInput() {
		Output out = new StubOutput();
		List<String> answer = new ArrayList<>();
		answer.add("one");
		answer.add("1");
		Input in = new StubInput(answer);
		ValidateInput input = new ValidateInput(out, in);
		int selected = input.askInt("Enter menu:");
		assertThat(selected, is(1));
	}

	@Test
	public void whenOneInvalidInput() {
		Output output = new StubOutput();
		List<String> answer = new ArrayList<>();
		answer.add("1");
		Input input = new StubInput(answer);
		ValidateInput validateInput = new ValidateInput(output, input);
		int selected = validateInput.askInt("Some text");
		assertThat(selected, is(1));
	}

	@Test
	public void whenManyInvalidInput() {
		Output output = new StubOutput();
		List<String> answer = new ArrayList<>();
		answer.add("1");
		answer.add("2");
		answer.add("3");
		answer.add("4");
		Input input = new StubInput(answer);
		ValidateInput validateInput = new ValidateInput(output, input);
		int selected = 0;
		for (int i = 0; i < answer.size(); i++) {
			selected = validateInput.askInt("Some text");
		}
		assertThat(selected, is(4));
	}

	@Test
	public void whenNegativeNumberInput() {
		Output output = new StubOutput();
		List<String> answer = new ArrayList<>();
		answer.add("-10");
		Input input = new StubInput(answer);
		ValidateInput validateInput = new ValidateInput(output, input);
		int selected = validateInput.askInt("Some text");
		assertThat(selected, is(-10));
	}
}