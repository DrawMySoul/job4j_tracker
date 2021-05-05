package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
	private final List<Item> items = new ArrayList<>();
	private int ids = 1;

	public Item add(Item item) {
		item.setId(ids++);
		items.add(item);
		return item;
	}

	public List<Item> findAll() {
		return List.copyOf(items);
	}

	public List<Item> findByName(String key) {
		List<Item> itemsFindByName = new ArrayList<>();
		for (Item value : items) {
			if (key.equals(value.getName())) {
				itemsFindByName.add(value);
			}
		}
		return itemsFindByName;
	}

	public Item findById(int id) {
		int index = indexOf(id);
		return index != -1 ? items.get(index) : null;
	}

	private int indexOf(int id) {
		int rsl = -1;
		for (int index = 0; index < items.size(); index++) {
			if (items.get(index).getId() == id) {
				rsl = index;
				break;
			}
		}
		return rsl;
	}

	public boolean replace(int id, Item item) {
		int index = indexOf(id);
		boolean result = index >= 0;
		if (result) {
			item.setId(id);
			items.set(index, item);
		}
		return result;
	}

	public boolean delete(int id) {
		int index = indexOf(id);
		boolean result = index >= 0;
		if (result) {
			items.remove(index);
		}
		return result;
	}
}