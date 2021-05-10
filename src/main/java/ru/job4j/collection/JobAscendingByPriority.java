package ru.job4j.collection;

import java.util.Comparator;

public class JobAscendingByPriority implements Comparator<Job> {
	@Override
	public int compare(Job firstObject, Job secondObject) {
		return Integer.compare(firstObject.getPriority(), secondObject.getPriority());
	}
}
