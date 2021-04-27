package ru.job4j.tracker;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
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
		Input input = new StubInput(new String[]{"0", "Item name", "1", "1", "replaced item", "2"});
		Tracker tracker = new Tracker();
		Output output = new StubOutput();
		UserAction[] actions = {new CreateAction(output), new EditAction(output), new ExitAction()};
		new StartUI(output).init(input, tracker, actions);
		assertThat(tracker.findAll()[0].getName(), is("replaced item"));
	}

	@Test
	public void whenDeleteItem() {
		Input input = new StubInput(new String[]{"0", "Item name", "1", "1", "2"});
		Tracker tracker = new Tracker();
		Output output = new StubOutput();
		UserAction[] actions = {new CreateAction(output), new DeleteAction(output), new ExitAction()};
		new StartUI(output).init(input, tracker, actions);
		assertNull(tracker.findById(0));
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