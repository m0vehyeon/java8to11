package me.donghyeon.java8to11.functionalinterface.lambda;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Foo {
    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.run();
    }

    private void run() {
        int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber); // 11 (쉐도잉이 일어남 내부 변수가 뒤에 스코프를 가림)
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber); // 스코프 내의 baseNumber를 따르게 됨
            }
        };

        // 람다
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
            // run 메소드 내의 baseNumber를 따르게 되고 i에다가 baseNumber를 넣게되면 컴파일 에러가 발생하게됨
            // 람다가 참조하고 있는 변수는 바뀌면 안됨
            // java 8 이전에는 final int baseNumber 로 사용했어야함함
       };

        printInt.accept(10);

    }
}
