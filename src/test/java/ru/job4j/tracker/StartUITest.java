package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {
	@Test
	public void whenCreateItem() {
		Input in = new StubInput(
			new String[]{"0", "Item name", "1"}
		);
		Output output = new StubOutput();
		Tracker tracker = new Tracker();
		UserAction[] actions = {
			new CreateAction(output),
			new ExitAction()
		};
		new StartUI(output).init(in, tracker, actions);
		assertThat(tracker.findAll()[0].getName(), is("Item name"));
	}

	@Test
	public void whenReplaceItem() {
		Tracker tracker = new Tracker();
		Output output = new StubOutput();
		Item item = tracker.add(new Item("Replaced item"));
		String replacedName = "New item name";
		Input in = new StubInput(
			new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
		);
		UserAction[] actions = {
			new EditAction(output),
			new ExitAction()
		};
		new StartUI(output).init(in, tracker, actions);
		assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
	}

	@Test
	public void whenDeleteItem() {
		Tracker tracker = new Tracker();
		Output output = new StubOutput();
		Item item = tracker.add(new Item("Deleted item"));
		Input in = new StubInput(
			new String[]{"0", String.valueOf(item.getId()), "1"}
		);
		UserAction[] actions = {
			new DeleteAction(output),
			new ExitAction()
		};
		new StartUI(output).init(in, tracker, actions);
		assertThat(tracker.findById(item.getId()), is(nullValue()));
	}

	@Test
	public void whenFindAll() {
		Tracker tracker = new Tracker();
		Item item = tracker.add(new Item("Item"));
		Output output = new StubOutput();
		Input input = new StubInput(new String[]{"0", "1"});
		UserAction[] actions = {new ShowAction(output), new ExitAction()};
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
		Input input = new StubInput(new String[]{"0", String.valueOf(item.getId()), "1"});
		UserAction[] actions = {new FindByIDAction(output), new ExitAction()};
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
		UserAction[] actions = {new FindByNameAction(output), new ExitAction()};
		Input input = new StubInput(new String[]{"0", item.getName(), "1"});
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
		Input in = new StubInput(
			new String[]{"0"}
		);
		Tracker tracker = new Tracker();
		UserAction[] actions = {
			new ExitAction()
		};
		new StartUI(out).init(in, tracker, actions);
		assertThat(out.toString(), is(
			"Menu:" + System.lineSeparator()
				+ "0. Exit Program" + System.lineSeparator()
		));
	}

	@Test
	public void whenInvalidExit() {
		Output out = new StubOutput();
		Input in = new StubInput(new String[]{"1", "0"});
		Tracker tracker = new Tracker();
		UserAction[] actions = new UserAction[]{new ExitAction()};
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