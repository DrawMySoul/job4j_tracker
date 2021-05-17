package ru.job4j.collection;

import java.util.*;

public class Article {
	public static boolean generateBy(String origin, String line) {
		Set<String> originText = new HashSet<>(Arrays.asList(origin.split("[\\s\\.\\,\\:\\!\\?]")));
		Set<String> check = new HashSet<>(Arrays.asList(line.split("[\\s\\.\\,\\:\\!\\?]")));

		for (String word : check) {
			if (!originText.contains(word)) {
				return false;
			}
		}
		return true;
	}
}
