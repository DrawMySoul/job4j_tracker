package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = List.of(new Order("3sfe", "Dress"));
        Map<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenSomeOrders() {
        List<Order> orders = List.of(
                new Order("lafd4", "Coffee"),
                new Order("3sfe", "Dress"),
                new Order("3sfe", "Dress"),
                new Order("3sfe", "Dress"),
                new Order("lafd4", "Coffee")
        );
        Map<String, Order> map = OrderConvert.process(orders);
        assertThat(map.size(), is(2));
    }
}