package me.donghyeon.java8to11.functionalinterface.Function;

import java.util.function.*;

//Function<T, R>
//BiFunction<T, U, R>
//Consumer<T>
//Supplier<T>
//Predicate<T>
//UnaryOperator<T>
//BinaryOperator<T>

public class Foo {
    public static void main(String[] args) {
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));

        //T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스
        //apply, andThen, compose
        Function<Integer, Integer> plus11 = (i) -> i + 11;
        System.out.println(plus11.apply(1));

        Function<Integer, Integer> multiply2 = (i) -> i * 2;
        System.out.println(multiply2.apply(1));

        // 1. multiply2 2. plus11
        System.out.println(plus11.compose(multiply2).apply(2));
        // 1. plus11 2. multiply2
        System.out.println(plus11.andThen(multiply2).apply(2));

        //T 타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스
        //accept, andThen
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        //T 타입의 값을 제공하는 함수 인터페이스
        //get
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        //T 타입을 받아서 boolean을 리턴하는 함수 인터페이스
        //test, and,or,negate
        Predicate<String> startsWithDonghyeon = (s) -> s.startsWith("donghyeon");
        Predicate<Integer> isOdd = (i) -> i%2==1;

        System.out.println(startsWithDonghyeon.test("donghyeonhihi"));
        System.out.println(isOdd.test(3));

        //Function<T, R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴하는 함수 인터페이스
        //apply
        UnaryOperator<Integer> plus12 = (i) -> i + 12;
        System.out.println(plus12.apply(10));
    }
}
