package ru.job4j.tracker;

public class EditAction implements UserAction {
	@Override
	public String name() {
		return "Edit item";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		System.out.println("=== What items do you want to change? ===");
		int id = input.askInt("Enter id: ");
		String name = input.askStr("Enter new name: ");
		Item newItem = new Item(name);

		if (tracker.replace(id, newItem)) {
			System.out.println("=== Successful ===");
		} else {
			System.out.println("=== Failed  ===");
		}
		return true;
	}
}
