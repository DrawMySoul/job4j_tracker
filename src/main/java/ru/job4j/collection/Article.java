package ru.job4j.collection;

import java.util.*;

public class Article {
    public static boolean generateBy(String origin, String line) {
        line = line.replaceAll("\\p{P}", "");
        Set<String> check = new HashSet<>(Arrays.asList(line.split("\\s")));

        for (String word : check) {
            if (!origin.contains(word)) {
                return false;
            }
        }
        return true;
    }
}