package ru.job4j.tracker;

public class StartUI {
	public void init(Input input, Tracker tracker) {
		boolean run = true;
		while (run) {
			this.showMenu();
			int select = input.askInt("Select: ");

			if (select == 0) {
				createItem(input, tracker);
			} else if (select == 1) {
				showAllItems(input, tracker);
			} else if (select == 2) {
				editItem(input, tracker);
			} else if (select == 3) {
				deleteItem(input, tracker);
			} else if (select == 4) {
				findByID(input, tracker);
			} else if (select == 5) {
				findByID(input, tracker);
			} else if (select == 6) {
				run = false;
			}

		}
	}

	private static void createItem(Input input, Tracker tracker) {
		System.out.println("=== Create a new Item ====");
		String name = input.askStr("Enter name: ");
		Item item = new Item(name);
		tracker.add(item);
		System.out.println("Item added: " + item);
		System.out.println("==========================");
	}

	private static void showAllItems(Input input, Tracker tracker) {
		Item[] allItems = tracker.findAll();
		System.out.println("=== Show all items ===");

		if (allItems.length > 0) {
			for (Item item : allItems) {
				System.out.println(item);
			}
		} else {
			System.out.println("Storage does not contain any items");
		}
		System.out.println("=================");
	}

	private static void editItem(Input input, Tracker tracker) {
		System.out.println("=== What items do you want to change? ===");
		int id = input.askInt("Enter id: ");
		String name = input.askStr("Enter new name: ");
		Item newItem = new Item(name);

		if (tracker.replace(id, newItem)) {
			System.out.println("=== Successful ===");
		} else {
			System.out.println("=== Failed  ===");
		}
	}

	private static void deleteItem(Input input, Tracker tracker) {
		System.out.println("=== Delete item ===");
		int id = input.askInt("Enter id: ");

		if (tracker.delete(id)) {
			System.out.println("=== Successful ===");
		} else {
			System.out.println("=== Failed  ===");
		}
	}

	private static void findByID(Input input, Tracker tracker) {
		System.out.println("=== Find by id ===");
		int id = input.askInt("Enter id: ");
		Item itemById = tracker.findById(id);

		if (itemById != null) {
			System.out.println(itemById);
		} else {
			System.out.println("Item with this id was not found");
		}
	}

	private static void findByName(Input input, Tracker tracker) {
		System.out.println("=== Find by name ===");
		String name = input.askStr("Enter name: ");
		Item[] itemsByName = tracker.findByName(name);

		if (itemsByName.length != 0) {
			for (Item item : itemsByName) {
				System.out.println(item);
			}
		} else {
			System.out.println("Items with this name were not found");
		}
	}

	private void showMenu() {
		String[] menu = {
			"Add new Item", "Show all items", "Edit item",
			"Delete item", "Find item by id", "Find items by name",
			"Exit Program"
		};
		System.out.println("Menu:");
		for (int i = 0; i < menu.length; i++) {
			System.out.println(i + ". " + menu[i]);
		}
	}

	public static void main(String[] args) {
		Input input = new ConsoleInput();
		Tracker tracker = new Tracker();
		new StartUI().init(input, tracker);
	}
}
