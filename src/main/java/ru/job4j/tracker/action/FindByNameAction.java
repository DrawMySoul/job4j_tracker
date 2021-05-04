package ru.job4j.tracker.action;

import ru.job4j.tracker.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

import java.util.ArrayList;

public class FindByNameAction implements UserAction {
	private final Output out;

	public FindByNameAction(Output out) {
		this.out = out;
	}

	@Override
	public String name() {
		return "Find items by name";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		out.println("=== Find by name ===");
		String name = input.askStr("Enter name: ");
		ArrayList<Item> itemsByName = tracker.findByName(name);

		if (itemsByName.size() != 0) {
			for (Item item : itemsByName) {
				out.println(item);
			}
		} else {
			out.println("Items with this name were not found");
		}
		return true;
	}
}
