package ru.job4j.tracker.action;

import ru.job4j.tracker.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class FindByIDAction implements UserAction {
	private final Output out;

	public FindByIDAction(Output out) {
		this.out = out;
	}

	@Override
	public String name() {
		return "Find item by Id";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		out.println("=== Find by id ===");
		int id = input.askInt("Enter id: ");
		Item itemById = tracker.findById(id);

		if (itemById != null) {
			out.println(itemById);
		} else {
			out.println("Item with this id was not found");
		}
		return true;
	}
}
