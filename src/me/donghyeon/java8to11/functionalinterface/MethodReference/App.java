package me.donghyeon.java8to11.functionalinterface.MethodReference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();

        // '::' 메소드 레퍼런스
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("donghyeon"));

        UnaryOperator<String> hi = Greeting::hi;
        System.out.println(hi.apply("donghyeon"));

        Supplier<Greeting> newGreeting = Greeting::new; // 문자를 받는 생성자 사용
        Greeting greeting1 = newGreeting.get();

        Function<String, Greeting> donghyeonGreeting = Greeting::new; // 빈 생성자 사용
        Greeting donghyeon = donghyeonGreeting.apply("donghyeon");
        System.out.println(donghyeon.getName());

        String[] names = {"donghyeon", "whiteship", "toby"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));

    }
}
