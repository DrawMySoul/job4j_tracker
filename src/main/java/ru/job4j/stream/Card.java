package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" + "suit=" + suit + ", value=" + value + '}';
    }

    public static void main(String[] args) {
        Suit[] suits = {Suit.Diamonds, Suit.Hearts, Suit.Spades, Suit.Clubs};
        Value[] values = {Value.V_6, Value.V_7, Value.V_8};
        Stream.of(suits)
                .flatMap(s -> Stream.of(values)
                        .map(v -> new Card(s, v)))
                .forEach(System.out::println);
    }
}