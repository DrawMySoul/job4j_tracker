package ru.job4j.tracker.action;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIDActionTest {

    @Test
    public void execute() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("New item");
        tracker.add(item);
        FindByIDAction rep = new FindByIDAction(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("=== Find by id ===" + ln + item + ln));
        assertThat(tracker.findAll().get(0).getName(), is(item.getName()));
    }
}