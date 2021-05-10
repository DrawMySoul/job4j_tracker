package ru.job4j.tracker.sort;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AscendingSortTest {
	@Test
	public void ascendingSortTest() {
		Item item = new Item(1, "name4");
		Item item1 = new Item(1, "name2");
		List<Item> items = Arrays.asList(item1, item);
		List<Item> expected = Arrays.asList(item, item1);
		Collections.sort(items, new AscendingSort());
		assertThat(items, is(expected));
	}
}