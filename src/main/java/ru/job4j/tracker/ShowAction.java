package ru.job4j.tracker;

public class ShowAction implements UserAction {
	private final Output out;

	public ShowAction(Output out) {
		this.out = out;
	}

	@Override
	public String name() {
		return "Show all items";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		Item[] allItems = tracker.findAll();
		out.println("=== Show all items ===");

		if (allItems.length > 0) {
			for (Item item : allItems) {
				out.println(item);
			}
		} else {
			out.println("Storage does not contain any items");
		}
		out.println("=================");
		return true;
	}
}
