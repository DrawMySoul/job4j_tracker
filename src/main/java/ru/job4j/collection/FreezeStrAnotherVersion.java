package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FreezeStrAnotherVersion {
    public static boolean eq(String left, String right) {
        char[] leftWord = left.toCharArray();
        char[] rightWord = right.toCharArray();
        Map<Integer, Character> leftMap = new HashMap<>();
        Map<Integer, Character> rightMap = new HashMap<>();

        for (int i = 0; i < leftWord.length; i++) {
            leftMap.put(i, leftWord[i]);
            rightMap.put(i, rightWord[i]);
        }

        for (Map.Entry<Integer, Character> check : rightMap.entrySet()) {
            if (!leftMap.get(check.getKey()).equals(check.getValue())) {
                return false;
            }
        }
        return true;
    }
}
