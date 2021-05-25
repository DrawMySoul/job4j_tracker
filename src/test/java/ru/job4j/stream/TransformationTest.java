package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TransformationTest {
    @Test
    public void checkListToMap() {
        List<Student> students = List.of(
                new Student(4, "Ivanov"),
                new Student(5, "Smirnov"),
                new Student(6, "Smirnov"),
                new Student(7, "Ivanov")
        );
        Map<String, Student> expected = Map.of(
                "Smirnov", new Student(6, "Smirnov"),
                "Ivanov", new Student(7, "Ivanov")
        );
        Map<String, Student> result = Transformation.listToMap(students);
        assertThat(result, is(expected));
    }

    @Test
    public void checkArrayToList() {
        Integer[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10}
        };
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = Transformation.arrToList(array);
        assertThat(result, is(expected));
    }
}