package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByPriority implements Comparator<Job> {
	@Override
	public int compare(Job firstObject, Job secondObject) {
		return Integer.compare(secondObject.getPriority(), firstObject.getPriority());
	}
}
