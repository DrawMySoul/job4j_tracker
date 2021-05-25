package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Transformation {
    public static Map<String, Student> listToMap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        Student::getSurname,
                        value -> value,
                        (oldStudent, newStudent) -> newStudent
                ));
    }

    public static List<Integer> arrToList(Integer[][] array) {
        return Stream.of(array)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
