package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
	public static void main(String[] args) {
		Attachment[] atts = {
			new Attachment("image 1", 20),
			new Attachment("image 3", 120),
			new Attachment("image 2", 23)
		};
		Comparator<Attachment> comparator = (left, right) -> right.getSize() - left.getSize();
		Comparator<Attachment> cmtText = (left, right) -> left.toString().compareTo(right.toString());

		String[] strings = {"a", "aa", "aaa"};

		Comparator<String> cmpDescSize = (left, right) -> Integer.compare(right.length(), left.length());

	}
}
