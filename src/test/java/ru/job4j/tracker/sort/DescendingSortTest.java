package ru.job4j.tracker.sort;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DescendingSortTest {
	@Test
	public void descendingSortTest() {
		Item item = new Item(1, "name4");
		Item item1 = new Item(1, "name2");
		List<Item> items = Arrays.asList(item, item1);
		List<Item> expected = Arrays.asList(item1, item);
		Collections.sort(items, new DescendingSort());
		assertThat(items, is(expected));
	}

}