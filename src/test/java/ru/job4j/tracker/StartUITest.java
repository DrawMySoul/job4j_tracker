package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {
	@Test
	public void whenCreateItem() {
		List<String> answer = new ArrayList<>();
		answer.add("0");
		answer.add("Item name");
		answer.add("1");
		Input in = new StubInput(answer);
		Output output = new StubOutput();
		Tracker tracker = new Tracker();
		List<UserAction> actions = new ArrayList<>();
		actions.add(new CreateAction(output));
		actions.add(new ExitAction());

		new StartUI(output).init(in, tracker, actions);
		assertThat(tracker.findAll().get(0).getName(), is("Item name"));
	}

	@Test
	public void whenReplaceItem() {
		Tracker tracker = new Tracker();
		Output output = new StubOutput();
		Item item = tracker.add(new Item("Replaced item"));
		String replacedName = "New item name";
		List<String> answer = new ArrayList<>();
		answer.add("0");
		answer.add(String.valueOf(item.getId()));
		answer.add(replacedName);
		answer.add("1");
		Input in = new StubInput(answer);

		List<UserAction> actions = new ArrayList<>();
		actions.add(new EditAction(output));
		actions.add(new ExitAction());

		new StartUI(output).init(in, tracker, actions);
		assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
	}

	@Test
	public void whenDeleteItem() {
		Tracker tracker = new Tracker();
		Output output = new StubOutput();
		Item item = tracker.add(new Item("Deleted item"));
		List<String> answer = new ArrayList<>();
		answer.add("0");
		answer.add(String.valueOf(item.getId()));
		answer.add("1");
		Input in = new StubInput(answer);
		List<UserAction> actions = new ArrayList<>();
		actions.add(new DeleteAction(output));
		actions.add(new ExitAction());

		new StartUI(output).init(in, tracker, actions);
		assertThat(tracker.findById(item.getId()), is(nullValue()));
	}

	@Test
	public void whenFindAll() {
		Tracker tracker = new Tracker();
		Item item = tracker.add(new Item("Item"));
		Output output = new StubOutput();
		List<String> answer = new ArrayList<>();
		answer.add("0");
		answer.add("1");
		Input input = new StubInput(answer);
		List<UserAction> actions = new ArrayList<>();
		actions.add(new ShowAction(output));
		actions.add(new ExitAction());
		new StartUI(output).init(input, tracker, actions);
		assertThat(output.toString(), is(
			"Menu:" + System.lineSeparator() + "0. Show all items" + System.lineSeparator()
				+ "1. Exit Program" + System.lineSeparator() + "=== Show all items ===" + System.lineSeparator()
				+ item + System.lineSeparator() + "=================" + System.lineSeparator()
				+ "Menu:" + System.lineSeparator() + "0. Show all items"
				+ System.lineSeparator() + "1. Exit Program" + System.lineSeparator()
		));
	}

	@Test
	public void whenFindByID() {
		Tracker tracker = new Tracker();
		Item item = tracker.add(new Item("Item"));
		Output output = new StubOutput();
		List<String> answer = new ArrayList<>();
		answer.add("0");
		answer.add(String.valueOf(item.getId()));
		answer.add("1");
		Input input = new StubInput(answer);
		List<UserAction> actions = new ArrayList<>();
		actions.add(new FindByIDAction(output));
		actions.add(new ExitAction());
		new StartUI(output).init(input, tracker, actions);
		assertThat(output.toString(), is(
			"Menu:" + System.lineSeparator() + "0. Find item by Id" + System.lineSeparator() + "1. Exit Program"
				+ System.lineSeparator() + "=== Find by id ===" + System.lineSeparator() + item
				+ System.lineSeparator() + "Menu:" + System.lineSeparator() + "0. Find item by Id"
				+ System.lineSeparator() + "1. Exit Program" + System.lineSeparator()
		));

	}

	@Test
	public void whenFindByName() {
		Tracker tracker = new Tracker();
		Item item = tracker.add(new Item("Item"));
		Output output = new StubOutput();
		List<UserAction> actions = new ArrayList<>();
		actions.add(new FindByNameAction(output));
		actions.add(new ExitAction());
		List<String> answer = new ArrayList<>();
		answer.add("0");
		answer.add(item.getName());
		answer.add("1");
		Input input = new StubInput(answer);
		new StartUI(output).init(input, tracker, actions);
		assertThat(output.toString(), is(
			"Menu:" + System.lineSeparator() + "0. Find items by name"
				+ System.lineSeparator() + "1. Exit Program" + System.lineSeparator() + "=== Find by name ==="
				+ System.lineSeparator() + item + System.lineSeparator() + "Menu:" + System.lineSeparator()
				+ "0. Find items by name" + System.lineSeparator() + "1. Exit Program" + System.lineSeparator()
		));
	}

	@Test
	public void whenExit() {
		Output out = new StubOutput();
		List<String> answer = new ArrayList<>();
		answer.add("0");
		Input in = new StubInput(answer);
		Tracker tracker = new Tracker();
		List<UserAction> actions = new ArrayList<>();
		actions.add(new ExitAction());
		new StartUI(out).init(in, tracker, actions);
		assertThat(out.toString(), is(
			"Menu:" + System.lineSeparator()
				+ "0. Exit Program" + System.lineSeparator()
		));
	}

	@Test
	public void whenInvalidExit() {
		Output out = new StubOutput();
		List<String> answer = new ArrayList<>();
		answer.add("1");
		answer.add("0");
		Input in = new StubInput(answer);
		Tracker tracker = new Tracker();
		List<UserAction> actions = new ArrayList<>();
		actions.add(new ExitAction());
		new StartUI(out).init(in, tracker, actions);
		String ln = System.lineSeparator();
		assertThat(out.toString(), is(
			"Menu:" + ln
				+ "0. Exit Program" + ln
				+ "Wrong input, you can select: 0 .. 0" + ln
				+ "Menu:" + ln
				+ "0. Exit Program" + ln
			)
		);
	}
}