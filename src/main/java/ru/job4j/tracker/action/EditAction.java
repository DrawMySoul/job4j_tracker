package ru.job4j.tracker.action;

import ru.job4j.tracker.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class EditAction implements UserAction {
	private final Output out;

	public EditAction(Output out) {
		this.out = out;
	}

	@Override
	public String name() {
		return "Edit item";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		out.println("=== What items do you want to change? ===");
		int id = input.askInt("Enter id: ");
		String name = input.askStr("Enter new name: ");
		Item newItem = new Item(name);

		if (tracker.replace(id, newItem)) {
			out.println("=== Successful ===");
		} else {
			out.println("=== Failed  ===");
		}
		return true;
	}
}
