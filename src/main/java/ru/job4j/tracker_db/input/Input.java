package ru.job4j.tracker_db.input;

public interface Input {
    String askStr(String question);
    int askInt(String question);
    int askInt(String question, int max);
}
