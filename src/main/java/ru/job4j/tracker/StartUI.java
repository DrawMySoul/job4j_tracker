package ru.job4j.tracker;

import ru.job4j.tracker.Action.*;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;

public class StartUI {
	private final Output out;

	public StartUI(Output out) {
		this.out = out;
	}

	public void init(Input input, Tracker tracker, UserAction[] actions) {
		boolean run = true;

		while (run) {
			this.showMenu(actions);
			int select = input.askInt("Select: ");
			if (select < 0 || select >= actions.length) {
				out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
				continue;
			}
			UserAction action = actions[select];
			run = action.execute(input, tracker);
		}
	}

	private void showMenu(UserAction[] actions) {
		out.println("Menu:");
		for (int i = 0; i < actions.length; i++) {
			out.println(i + ". " + actions[i].name());
		}
	}

	public static void main(String[] args) {
		Tracker tracker = new Tracker();
		Output output = new ConsoleOutput();
		Input input = new ValidateInput(output, new ConsoleInput());
		UserAction[] actions = {new CreateAction(output), new ShowAction(output), new EditAction(output),
			new DeleteAction(output), new FindByIDAction(output),
			new FindByNameAction(output), new ExitAction()};
		new StartUI(output).init(input, tracker, actions);
	}
}
