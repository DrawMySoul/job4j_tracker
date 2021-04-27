package ru.job4j.tracker;

public class FindByIDAction implements UserAction {
	@Override
	public String name() {
		return "Find item by Id";
	}

	@Override
	public boolean execute(Input input, Tracker tracker) {
		System.out.println("=== Find by id ===");
		int id = input.askInt("Enter id: ");
		Item itemById = tracker.findById(id);

		if (itemById != null) {
			System.out.println(itemById);
		} else {
			System.out.println("Item with this id was not found");
		}
		return true;
	}
}
