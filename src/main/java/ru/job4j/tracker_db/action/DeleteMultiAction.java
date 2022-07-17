package ru.job4j.tracker_db.action;

import ru.job4j.tracker_db.Store;
import ru.job4j.tracker_db.input.Input;
import ru.job4j.tracker_db.output.Output;

public class DeleteMultiAction implements UserAction {
    private final Output out;

    public DeleteMultiAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete multiple items ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("How mane items do you want to delete? Enter amount: ");
        for (int i = 0; i < id; i++) {
            if (!tracker.delete(i)) {
                out.println("Wrong id! id = " + i);
            }
        }
        out.println("Items successfully deleted!");
        return true;
    }
}
