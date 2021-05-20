package ru.job4j.function;

import java.util.function.Predicate;

public class StrategyUsage {
    /*public boolean empty(String s) {
        return chek(str -> str.isEmpty(), s);
    }

    public boolean startWith(String s, String pref) {
        return chek(str -> str.startsWith(pref), s);
    }

    public boolean contains(String s, String key) {
        return chek(str -> str.contains(key), s);
    }*/

    public boolean chek(Predicate<String> predicate, String s) {
        return predicate.test(s);
    }

    public static void main(String[] args) {
        StrategyUsage strategyUsage = new StrategyUsage();
        System.out.println(strategyUsage.chek(str -> str.isEmpty(), ""));
        System.out.println(strategyUsage.chek(
                str -> str.startsWith("Fun"),
                "Functional Interface"));
        System.out.println(strategyUsage.chek(str -> str.contains("rn"), "Surname Name"));
    }
}
