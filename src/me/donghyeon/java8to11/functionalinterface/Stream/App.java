package me.donghyeon.java8to11.functionalinterface.Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("donghyeon");
        names.add("movehyeon");
        names.add("keesun");
        names.add("toby");

        List<String> collect1 = names.parallelStream().map(String::toUpperCase).collect(Collectors.toList());
        collect1.forEach(System.out::println);

        List<String> collect = names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("===============");

        names.forEach(System.out::println);


    }
}
