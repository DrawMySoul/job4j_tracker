package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] rightWord = right.toCharArray();
        char[] leftWord = left.toCharArray();
        Map<Character, Integer> leftMap = new HashMap<>();

        for (char value : leftWord) {
            if (leftMap.containsKey(value)) {
                leftMap.put(value, leftMap.get(value) + 1);
            } else {
                leftMap.put(value, 1);
            }
        }

        for (Character rightWordChar : rightWord) {
            if (!leftMap.containsKey(rightWordChar)) {
                return false;
            } else {
                if (leftMap.get(rightWordChar) > 1) {
                    leftMap.put(rightWordChar, leftMap.get(rightWordChar) - 1);
                } else if (leftMap.get(rightWordChar) == 1) {
                    leftMap.remove(rightWordChar);
                }
            }
        }
        return leftMap.size() == 0;
    }
}
