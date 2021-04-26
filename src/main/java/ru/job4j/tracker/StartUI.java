package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
	public void init(Scanner scanner, Tracker tracker) {
		boolean run = true;
		while (run) {
			this.showMenu();
			System.out.print("Select: ");
			int select = Integer.valueOf(scanner.nextLine());

			if (select == 0) {
				System.out.println("=== Create a new Item ====");
				System.out.print("Enter name: ");
				String name = scanner.nextLine();
				Item item = new Item(name);
				tracker.add(item);
			} else if (select == 1) {
				Item[] allItems = tracker.findAll();
				System.out.println("=== All items ===");
				for (Item item : allItems) {
					System.out.println(item);
				}
				System.out.println("=================");
			} else if (select == 2) {
				System.out.println("=== What items do you want to change? ===");
				System.out.print("Enter id: ");
				int id = Integer.parseInt(scanner.nextLine());
				System.out.print("Enter new name: ");
				String name = scanner.nextLine();
				Item newItem = new Item(name);

				if (tracker.replace(id, newItem)) {
					System.out.println("=== Successful ===");
				} else {
					System.out.println("=== Failed  ===");
				}
			} else if (select == 3) {
				System.out.println("=== Delete item ===");
				System.out.print("Enter id: ");
				int id = Integer.parseInt(scanner.nextLine());

				if (tracker.delete(id)) {
					System.out.println("=== Successful ===");
				} else {
					System.out.println("=== Failed  ===");
				}
			} else if (select == 4) {
				System.out.println("=== Find by id ===");
				System.out.print("Enter id: ");
				int id = Integer.parseInt(scanner.nextLine());
				Item itemById = tracker.findById(id);

				if (itemById == null) {
					System.out.println("Item with this id was not found");
				} else {
					System.out.println(itemById);
				}
			} else if (select == 5) {
				System.out.println("=== Find by name ===");
				System.out.print("Enter name: ");
				String name = scanner.nextLine();
				Item[] itemsByName = tracker.findByName(name);

				if (itemsByName.length == 0) {
					System.out.println("Items with this name were not found");
				} else {
					for (Item item : itemsByName) {
						System.out.println(item);
					}
				}
			} else if (select == 6) {
				run = false;
			}

		}
	}

	private void showMenu() {
		System.out.println("Menu.");
		System.out.println("0. Add new Item");
		System.out.println("1. Show all items");
		System.out.println("2. Edit item");
		System.out.println("3. Delete item");
		System.out.println("4. Find item by Id");
		System.out.println("5. Find items by name");
		System.out.println("6. Exit Program");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Tracker tracker = new Tracker();
		new StartUI().init(scanner, tracker);
	}
}
