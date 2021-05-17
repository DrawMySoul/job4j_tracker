package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
	public static boolean eq(String left, String right) {
		char[] leftWord = left.toCharArray();
		char[] rightWord = right.toCharArray();
		Map<Character, Integer> leftMap = new HashMap<>();
		Map<Character, Integer> rightMap = new HashMap<>();

		for (char value : leftWord) {
			int count = 0;
			for (char checkValue : leftWord) {
				if (value == checkValue) {
					count++;
				}
			}
			leftMap.put(value, count);
		}

		for (char value : rightWord) {
			int count = 0;
			for (char checkValue : rightWord) {
				if (value == checkValue) {
					count++;
				}
			}
			rightMap.put(value, count);
		}

		for (Map.Entry<Character, Integer> chekChar : rightMap.entrySet()) {
			if (leftMap.containsKey(chekChar.getKey())) {
				if (!leftMap.get(chekChar.getKey()).equals(chekChar.getValue())) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String left = "Hello";
		String right = "Hlloe";
		char[] leftWord = left.toCharArray();
		char[] rightWord = right.toCharArray();

		Arrays.sort(leftWord);
		Arrays.sort(rightWord);
		System.out.println(Arrays.toString(leftWord));
		System.out.println(Arrays.toString(rightWord));
	}
}
