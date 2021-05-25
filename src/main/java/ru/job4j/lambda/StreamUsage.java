package ru.job4j.lambda;

import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5);
		List<Integer> evenNumbers = numbers.stream().filter(
			number -> number % 2 == 0
		).collect(Collectors.toList());
	}
}
