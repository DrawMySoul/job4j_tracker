package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Transformation {
    public static Map<String, Student> listToMap(List<Student> students) {
       return  students.stream()
                .collect(Collectors.toMap(
                        Student::getSurname,
                        value -> value,
                        (oldStudent, newStudent) -> newStudent
                        ));
    }
}
