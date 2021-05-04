package ru.job4j.tracker;

import java.util.ArrayList;

public class SingleTracker {
	private static SingleTracker singleTracker = null;
	private Tracker tracker = new Tracker();

	private SingleTracker() {
	}

	public static SingleTracker getInstance() {
		if (singleTracker == null) {
			singleTracker = new SingleTracker();
		}
		return singleTracker;
	}

	public Item add(Item item) {
		return tracker.add(item);
	}

	public ArrayList<Item> findAll() {
		return tracker.findAll();
	}

	public ArrayList<Item> findByName(String key) {
		return tracker.findByName(key);
	}

	public Item findById(int id) {
		return tracker.findById(id);
	}

	public boolean replace(int id, Item item) {
		return tracker.replace(id, item);
	}

	public boolean delete(int id) {
		return tracker.delete(id);
	}
}
