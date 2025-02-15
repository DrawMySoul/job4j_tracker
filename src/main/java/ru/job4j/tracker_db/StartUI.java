package ru.job4j.tracker_db;

import ru.job4j.tracker_db.action.*;
import ru.job4j.tracker_db.input.ConsoleInput;
import ru.job4j.tracker_db.input.Input;
import ru.job4j.tracker_db.input.ValidateInput;
import ru.job4j.tracker_db.output.ConsoleOutput;
import ru.job4j.tracker_db.output.Output;
import ru.job4j.tracker_db.store.MemTracker;

import java.util.List;

public class StartUI {

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Enter select: ");
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (int i = 0; i < actions.size(); i++) {
            System.out.printf("%d. %s%n", i, actions.get(i).name());
        }
    }


    public static void main(String[] args) {
        Input validate = new ValidateInput(
            new ConsoleInput()
        );
        Output output = new ConsoleOutput();
        List<UserAction> actions = List.of(
            new CreateAction(output),
            new ReplaceAction(output),
            new DeleteAction(output),
            new FindAllAction(output),
            new FindByIdAction(output),
            new FindByNameAction(output),
            new CreateMultiAction(output),
            new DeleteMultiAction(output),
            new ExitAction()
        );
        MemTracker tracker = new MemTracker();
        new StartUI().init(validate, tracker, actions);
    }
}
