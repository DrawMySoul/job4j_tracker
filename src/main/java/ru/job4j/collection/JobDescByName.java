package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByName implements Comparator<Job> {
	@Override
	public int compare(Job firstObject, Job secondObject) {
		return secondObject.getName().compareTo(firstObject.getName());
	}
}
