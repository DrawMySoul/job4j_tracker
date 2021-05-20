package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        String startOfFirst = first.split("/")[0];
        String startOfSecond = second.split("/")[0];
        int result = startOfFirst.compareTo(startOfSecond);
        if (result > 0) {
            return -1;
        } else if (result < 0) {
            return 1;
        } else {
            return first.compareTo(second);
        }
    }
}
