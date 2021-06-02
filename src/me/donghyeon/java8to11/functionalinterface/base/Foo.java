package me.donghyeon.java8to11.functionalinterface.base;

public class Foo {
    public static void main(String[] args) {
        RunSomething runSomething = number -> {
            System.out.println(number);
            System.out.println("Lambda");
        };

        runSomething.doIt(2);
    }
}
