package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
	private List<Integer> source;

	private EasyStream(List<Integer> source) {
		this.source = source;
	}

	public static EasyStream of(List<Integer> source) {
		return new EasyStream(source);
	}

	public EasyStream map(Function<Integer, Integer> fun) {
		List<Integer> mappedList = new ArrayList<>();
		for (Integer value : source) {
			mappedList.add(fun.apply(value));
		}
		source = mappedList;
		return this;
	}

	public EasyStream filter(Predicate<Integer> fun) {
		List<Integer> filteredList = new ArrayList<>();
		for (Integer value : source) {
			if (fun.test(value)) {
				filteredList.add(value);
			}
		}
		source = filteredList;
		return this;
	}

	public List<Integer> collect() {
		return new ArrayList<>(source);
	}
}
