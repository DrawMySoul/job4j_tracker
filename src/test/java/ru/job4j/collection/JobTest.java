package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class JobTest {
	@Test
	public void chekAscendingByName() {
		Comparator<Job> comparator = new JobAscendingByName();
		int result = comparator.compare(
			new Job("Impl task", 0),
			new Job("Fix bug", 1));
		assertThat(result, greaterThan(0));
	}

	@Test
	public void chekDescByName() {
		Comparator<Job> comparator = new JobDescByName();
		int result = comparator.compare(
			new Job("Impl task", 0),
			new Job("Fix bug", 1));
		assertThat(result, lessThan(0));
	}

	@Test
	public void whenNamesEquals() {
		Comparator<Job> comparator = new JobDescByName();
		int result = comparator.compare(
			new Job("Fix bug", 0),
			new Job("Fix bug", 1));
		assertThat(result, is(0));
	}

	@Test
	public void checkAscendingByPriority() {
		Comparator<Job> comparator = new JobAscendingByPriority();
		int result = comparator.compare(
			new Job("Impl task", 0),
			new Job("Fix bug", 1));
		assertThat(result, lessThan(0));
	}

	@Test
	public void checkDescByPriority() {
		Comparator<Job> comparator = new JobDescByPriority();
		int result = comparator.compare(
			new Job("Impl task", 0),
			new Job("Fix bug", 1));
		assertThat(result, greaterThan(0));
	}

	@Test
	public void whenPrioritiesEquals() {
		Comparator<Job> comparator = new JobDescByPriority();
		int result = comparator.compare(
			new Job("Impl task", 0),
			new Job("Impl task", 0));
		assertThat(result, is(0));
	}

	@Test
	public void chekComparatorDescByNameAndPriority() {
		Comparator<Job> comparator = new JobDescByName().thenComparing(new JobDescByPriority());
		int result = comparator.compare(
			new Job("Impl task", 0),
			new Job("Fix bug", 1));
		assertThat(result, lessThan(0));
	}

	@Test
	public void checkComparatorDescWhenNamesEquals() {
		Comparator<Job> comparator = new JobDescByName().thenComparing(new JobDescByPriority());
		int result = comparator.compare(
			new Job("Impl task", 0),
			new Job("Impl task", 1));
		assertThat(result, greaterThan(0));
	}

	@Test
	public void checkComparatorAscByNameAndPriority() {
		Comparator<Job> comparator = new JobAscendingByName().thenComparing(new JobAscendingByPriority());
		int result = comparator.compare(
			new Job("Impl task", 0),
			new Job("Fix bug", 1));
		assertThat(result, greaterThan(0));
	}

	@Test
	public void checkComparatorWhenAscWhenNamesEquals() {
		Comparator<Job> comparator = new JobAscendingByName().thenComparing(new JobAscendingByPriority());
		int result = comparator.compare(
			new Job("Fix bug", 0),
			new Job("Fix bug", 1));
		assertThat(result, lessThan(0));
	}
}