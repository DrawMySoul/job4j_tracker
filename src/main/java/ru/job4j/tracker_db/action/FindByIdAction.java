package ru.job4j.tracker_db.action;

import ru.job4j.tracker_db.Store;
import ru.job4j.tracker_db.model.Item;
import ru.job4j.tracker_db.input.Input;
import ru.job4j.tracker_db.output.Output;

public class FindByIdAction implements UserAction {

    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Wrong id! Not found");
        }
        return true;
    }
}
