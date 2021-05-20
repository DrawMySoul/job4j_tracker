package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        if (first.charAt(1) > second.charAt(1)) {
            return -1;
        } else if (first.charAt(1) < second.charAt(1)) {
            return 1;
        } else {
            return first.compareTo(second);
        }
    }
}
