package ru.job4j.oop;

public class Max {
	public int max(int first, int second) {
		return first > second ? first : second;
	}

	public int max(int first, int second, int third) {
		int result = max(first, second);
		return max(result, third);
	}

	public int max(int first, int second, int third, int fourth) {
		int result = max(first, second, third);
		return max(result, fourth);
	}

}
