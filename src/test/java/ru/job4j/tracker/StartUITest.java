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
		Input input = new StubInput(new String[]{"0", "name1", "1", "2"});
		Tracker tracker = new Tracker();
		Output output = new StubOutput();
		UserAction[] actions = {new CreateAction(output), new ShowAction(output), new ExitAction()};
		new StartUI(output).init(input, tracker, actions);
		assertThat(output.toString(), is(
			"Menu:" + System.lineSeparator() + "0. Add new Item" + System.lineSeparator()
				+ "1. Show all items" + System.lineSeparator() + "2. Exit Program" + System.lineSeparator()
				+ "Menu:" + System.lineSeparator() + "0. Add new Item" + System.lineSeparator()
				+ "1. Show all items" + System.lineSeparator() + "2. Exit Program" + System.lineSeparator()
				+ "Menu:" + System.lineSeparator() + "0. Add new Item" + System.lineSeparator()
				+ "1. Show all items" + System.lineSeparator() + "2. Exit Program" + System.lineSeparator()
		));
	}

	@Test
	public void whenFindByID() {
		Input input = new StubInput(new String[]{"0", "name1", "1", "1", "2"});
		Tracker tracker = new Tracker();
		Output output = new StubOutput();
		UserAction[] actions = {new CreateAction(output), new FindByIDAction(output), new ExitAction()};
		new StartUI(output).init(input, tracker, actions);
		assertThat(output.toString(), is(
			"Menu:" + System.lineSeparator() + "0. Add new Item"
				+ System.lineSeparator() + "1. Find item by Id" + System.lineSeparator() + "2. Exit Program"
				+ System.lineSeparator() + "Menu:" + System.lineSeparator() + "0. Add new Item" + System.lineSeparator()
				+ "1. Find item by Id" + System.lineSeparator() + "2. Exit Program" + System.lineSeparator()
				+ "Menu:" + System.lineSeparator() + "0. Add new Item" + System.lineSeparator() + "1. Find item by Id"
				+ System.lineSeparator() + "2. Exit Program" + System.lineSeparator()));

	}

	@Test
	public void whenFindByName() {
		Input input = new StubInput(new String[]{"0", "name1", "1", "name1", "2"});
		Tracker tracker = new Tracker();
		Output output = new StubOutput();
		UserAction[] actions = {new CreateAction(output), new FindByNameAction(output), new ExitAction()};
		new StartUI(output).init(input, tracker, actions);
		assertThat(output.toString(), is(
			"Menu:" + System.lineSeparator() + "0. Add new Item" + System.lineSeparator() + "1. Find items by name"
				+ System.lineSeparator() + "2. Exit Program" + System.lineSeparator() + "Menu:" + System.lineSeparator()
				+ "0. Add new Item" + System.lineSeparator() + "1. Find items by name" + System.lineSeparator()
				+ "2. Exit Program" + System.lineSeparator() + "Menu:" + System.lineSeparator() + "0. Add new Item"
				+ System.lineSeparator() + "1. Find items by name" + System.lineSeparator()
				+ "2. Exit Program" + System.lineSeparator()));
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
}