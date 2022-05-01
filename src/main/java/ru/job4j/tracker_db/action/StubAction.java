package ru.job4j.tracker_db.action;

import ru.job4j.tracker_db.Store;
import ru.job4j.tracker_db.input.Input;

public class StubAction implements UserAction {
    private boolean call = false;

    @Override
    public String name() {
        return "Stub action";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}
