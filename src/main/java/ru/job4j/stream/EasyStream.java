package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
	private List<Integer> source;
	private static EasyStream easyStream;

	public EasyStream(List<Integer> source) {
		this.source = source;
	}

	public static EasyStream of(List<Integer> source) {
		easyStream = new EasyStream(source);
		return easyStream;
	}

	public EasyStream map(Function<Integer, Integer> fun) {
		List<Integer> mappedList = new ArrayList<>();
		for (Integer value : source) {
			mappedList.add(fun.apply(value));
		}
		source = mappedList;
		return easyStream;
	}

	public EasyStream filter(Predicate<Integer> fun) {
		List<Integer> filteredList = new ArrayList<>();
		for (Integer value : source) {
			if (fun.test(value)) {
				filteredList.add(value);
			}
		}
		source = filteredList;
		return easyStream;
	}

	public List<Integer> collect() {
		return source;
	}
}
