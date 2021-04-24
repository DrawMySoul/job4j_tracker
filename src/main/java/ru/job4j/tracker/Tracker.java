package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
	private final Item[] items = new Item[100];
	private int ids = 1;
	private int size = 0;

	public Item add(Item item) {
		item.setId(ids++);
		items[size++] = item;
		return item;
	}

	public Item[] findAll() {
		int length = 0;
		Item[] itemsWithoutNull = new Item[items.length];

		for (Item item : items) {
			if (item != null) {
				itemsWithoutNull[length++] = item;
			}
		}
		return Arrays.copyOf(itemsWithoutNull, length);
	}

	public Item[] findByName(String key) {
		int length = 0;
		Item[] itemsFindByName = new Item[items.length];

		for (Item item : items) {
			if (item.getName().equals(key)) {
				itemsFindByName[length++] = item;
			}
		}
		return Arrays.copyOf(itemsFindByName, length);
	}

	public Item findById(int id) {
		Item rsl = null;
		for (int index = 0; index < size; index++) {
			Item item = items[index];
			if (item.getId() == id) {
				rsl = item;
				break;
			}
		}
		return rsl;
	}
}