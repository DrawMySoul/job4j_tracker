package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
	public static void main(String[] args) {
		Map<String, String> users = new HashMap<>();
		users.put("qwerty@yandex.ru", "Ivan Ivanov");
		users.put("qwerty123@yandex.ru", "Nikolay Nikolaev");
		users.put("qwerty0000@yandex.ru", "Nikolay Ivanov");

		for (String key : users.keySet()) {
			System.out.println(key + " " + users.get(key));
		}
	}
}
