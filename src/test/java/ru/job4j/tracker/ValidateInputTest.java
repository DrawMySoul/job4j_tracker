package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {
	@Test
	public void whenInvalidInput() {
		Output out = new StubOutput();
		Input in = new StubInput(
			new String[]{"one", "1"}
		);
		ValidateInput input = new ValidateInput(out, in);
		int selected = input.askInt("Enter menu:");
		assertThat(selected, is(1));
	}

	@Test
	public void whenOneInvalidInput() {
		Output output = new StubOutput();
		Input input = new StubInput(new String[]{"1"});
		ValidateInput validateInput = new ValidateInput(output, input);
		int selected = validateInput.askInt("Some text");
		assertThat(selected, is(1));
	}

	@Test
	public void whenManyInvalidInput() {
		Output output = new StubOutput();
		String[] answers = new String[]{"1", "2", "3", "4"};
		Input input = new StubInput(answers);
		ValidateInput validateInput = new ValidateInput(output, input);
		int selected = 0;
		for (int i = 0; i < answers.length; i++) {
			selected = validateInput.askInt("Some text");
		}
		assertThat(selected, is(4));
	}

	@Test
	public void whenNegativeNumberInput() {
		Output output = new StubOutput();
		Input input = new StubInput(new String[] {"-10"});
		ValidateInput validateInput = new ValidateInput(output, input);
		int selected = validateInput.askInt("Some text");
		assertThat(selected, is(-10));
	}
}