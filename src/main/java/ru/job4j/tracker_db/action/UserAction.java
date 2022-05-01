package ru.job4j.tracker_db.action;

import ru.job4j.tracker_db.Store;
import ru.job4j.tracker_db.input.Input;

public interface UserAction {
    String name();
    boolean execute(Input input, Store tracker);
}
