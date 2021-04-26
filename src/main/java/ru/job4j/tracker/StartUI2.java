package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI2 {
	public void init(Scanner scanner, Tracker tracker) {
		boolean run = true;
		while (run) {
			showMenu();
			System.out.print("Select: ");
			int select = Integer.parseInt(scanner.nextLine());
			if (select == 0) {
				System.out.println("User selected: " + select);
				System.out.println("=== Create a new Item ====");
				System.out.print("Enter name: ");
				String name = scanner.nextLine();
				Item item = new Item(name);
				tracker.add(item);
				System.out.println("Item added: " + item);
				System.out.println("==========================");
			} else if (select == 1) {
				System.out.println("User selected: " + select);
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
			} else if (select == 6) {
				run = false;
			}
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
		Scanner scanner = new Scanner(System.in);
		Tracker tracker = new Tracker();
		new StartUI2().init(scanner, tracker);
	}
}
