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
		Tracker tracker = new Tracker();
		UserAction[] actions = {
			new CreateAction(),
			new ExitAction()
		};
		new StartUI().init(in, tracker, actions);
		assertThat(tracker.findAll()[0].getName(), is("Item name"));
	}

	@Test
	public void whenReplaceItem() {
		Input input = new StubInput(new String[]{"0", "Item name", "1", "1", "replaced item", "2"});
		Tracker tracker = new Tracker();
		UserAction[] actions = {new CreateAction(), new EditAction(), new ExitAction()};
		new StartUI().init(input, tracker, actions);
		assertThat(tracker.findAll()[0].getName(), is("replaced item"));
	}

	@Test
	public void whenDeleteItem() {
		Input input = new StubInput(new String[]{"0", "Item name", "1", "1", "2"});
		Tracker tracker = new Tracker();
		UserAction[] actions = {new CreateAction(), new DeleteAction(), new ExitAction()};
		new StartUI().init(input, tracker, actions);
		assertNull(tracker.findById(0));
	}
}