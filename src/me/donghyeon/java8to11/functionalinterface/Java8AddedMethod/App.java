package me.donghyeon.java8to11.functionalinterface.Java8AddedMethod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class App {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("donghyeon");
        name.add("movehyeon");
        name.add("keesun");
        name.add("toby");

        name.forEach(System.out::println);

        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("=============");
        while (spliterator1.tryAdvance(System.out::println));

        long k = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .count();
        System.out.println(k);

        name.removeIf(s -> s.startsWith("k"));

        name.forEach(System.out::println);

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);
    }
}
