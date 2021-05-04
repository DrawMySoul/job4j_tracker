package ru.job4j.tracker;

import java.util.ArrayList;

public class Tracker {
	private final ArrayList<Item> items = new ArrayList<>();
	private int ids = 1;

	public Item add(Item item) {
		item.setId(ids++);
		items.add(item);
		return item;
	}

	public ArrayList<Item> findAll() {
		return items;
	}

	public ArrayList<Item> findByName(String key) {
		ArrayList<Item> itemsFindByName = new ArrayList<>();
		for (int i = 0; i < items.size(); i++) {
			if (key.equals(items.get(i).getName())) {
				itemsFindByName.add(items.get(i));
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