package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class NewCollege {
    private final Map<Student, Set<Subject>> students;

    public NewCollege(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> foundStudent = Optional.empty();
        for (Student student : students.keySet()) {
            if (account.equals(student.getAccount())) {
                foundStudent = Optional.of(student);
                break;
            }
        }
        return foundStudent;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> foundSubject = Optional.empty();
        Optional<Student> student = findByAccount(account);
        if (student.isPresent()) {
            Set<Subject> subjects = students.get(student.get());
            for (Subject subject : subjects) {
                if (name.equals(subject.getName())) {
                    foundSubject = Optional.of(subject);
                    break;
                }
            }
        }
        return foundSubject;
    }
}
