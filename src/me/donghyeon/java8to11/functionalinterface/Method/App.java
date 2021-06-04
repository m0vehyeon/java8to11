package me.donghyeon.java8to11.functionalinterface.Method;

public class App {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("donghyeon");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAnything();
    }
}
