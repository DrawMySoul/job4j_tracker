package ru.job4j.tracker.action;

import ru.job4j.tracker.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

import java.util.ArrayList;
import java.util.List;

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
		List<Item> allItems = tracker.findAll();
		out.println("=== Show all items ===");

		if (!allItems.isEmpty()) {
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
