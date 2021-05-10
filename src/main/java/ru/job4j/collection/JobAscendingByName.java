package ru.job4j.collection;

import java.util.Comparator;

public class JobAscendingByName implements Comparator<Job> {
	@Override
	public int compare(Job firstObject, Job secondObject) {
		return firstObject.getName().compareTo(secondObject.getName());
	}
}
