package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
       /* List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> supplier = () -> new HashSet<>(list);
        Set<String> strings = supplier.get();
        BiConsumer<Integer, String> consumer = (s, s1) -> System.out.println(s + " is " + s1);
        int count = 1;
        for (String s : strings) {
            consumer.accept(count++, s);
        }*/

        /*Supplier<String> supplier = () -> "string for interface";
        BiConsumer<String, String> consumer = (s, s1) -> System.out.println(s + s1);
        consumer.accept(supplier.get(), " and Second String");*/

        /*BiPredicate<String, Integer> predicate = (s, i) -> s.contains(i.toString());
        System.out.println(predicate.test("Name123", 123));
        System.out.println(predicate.test("Name", 567));*/

        Function<String, Character> function = s -> s.charAt(2);
        System.out.println("Третий символ в строке " + function.apply("first"));
        System.out.println("Третий символ в строке " + function.apply("Second"));
    }
}
