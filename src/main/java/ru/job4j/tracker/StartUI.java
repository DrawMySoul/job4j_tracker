package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
	private final Output out;

	public StartUI(Output out) {
		this.out = out;
	}

	public void init(Input input, Tracker tracker, List<UserAction> actions) {
		boolean run = true;

		while (run) {
			this.showMenu(actions);
			int select = input.askInt("Select: ");
			if (select < 0 || select >= actions.size()) {
				out.println("Wrong input, you can select: 0 .. "
					+ (actions.size() - 1));
				continue;
			}
			UserAction action = actions.get(select);
			run = action.execute(input, tracker);
		}
	}

	private void showMenu(List<UserAction> actions) {
		out.println("Menu:");
		for (int i = 0; i < actions.size(); i++) {
			out.println(i + ". " + actions.get(i).name());
		}
	}

	public static void main(String[] args) {
		Tracker tracker = new Tracker();
		Output output = new ConsoleOutput();
		Input input = new ValidateInput(output, new ConsoleInput());

		List<UserAction> actions = new ArrayList<>();
		actions.add(new CreateAction(output));
		actions.add(new ShowAction(output));
		actions.add(new EditAction(output));
		actions.add(new DeleteAction(output));
		actions.add(new FindByIDAction(output));
		actions.add(new FindByNameAction(output));
		actions.add(new ExitAction());

		new StartUI(output).init(input, tracker, actions);
	}
}
