package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        String startOfSecond = second.split("/")[0];
        String startOfFirst = first.split("/")[0];
        int result = startOfSecond.compareTo(startOfFirst);
        return result == 0 ? first.compareTo(second) : result;
    }
}
