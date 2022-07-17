package ru.job4j.tracker_db.action;

import ru.job4j.tracker_db.Store;
import ru.job4j.tracker_db.input.Input;
import ru.job4j.tracker_db.model.Item;
import ru.job4j.tracker_db.output.Output;

public class CreateMultiAction implements UserAction {
    private final Output out;

    public CreateMultiAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Create multiple new Items ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int amount = input.askInt("How many items do you want to create? Enter amount: ");
        for (int i = 0; i < amount; i++) {
            Item item = new Item("Item #" + i);
            tracker.add(item);
        }
        out.println("Items successfully added!");
        return true;
    }
}
