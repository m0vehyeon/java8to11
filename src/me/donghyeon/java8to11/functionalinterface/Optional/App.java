package me.donghyeon.java8to11.functionalinterface.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean present = spring.isPresent();
        System.out.println(present);

        OnlineClass onlineClass1 = spring.get();
        System.out.println(onlineClass1.getTitle());

        Optional<OnlineClass> onlineClass = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        boolean presentjpa = onlineClass.isPresent();
        System.out.println(presentjpa);


//        OnlineClass onlineClass2 = onlineClass.get();
//        System.out.println(onlineClass2.getTitle());

        spring.ifPresent(oc -> System.out.println(oc.getTitle()));
        OnlineClass onlineClass2 = spring.orElse(createNewJpaClass()); // 없으면 괄호 안의 인스턴스를 만든다, 있더라도 createNewJpaClass() 가 실행이됨
        OnlineClass onlineClass3 = spring.orElseGet(App::createNewJpaClass); // 없으면 괄호 안의 인스턴스를 호출해서 만든다, 있으면 createNewJpaClass() 가 실행이 안됨
        OnlineClass onlineClass4 = spring.orElseThrow(IllegalStateException::new);
        Optional<OnlineClass> onlineClass5 = spring.filter(oc -> !oc.isClosed());
        System.out.println(onlineClass5.isEmpty());
        Optional<Integer> integer = spring.map(OnlineClass::getId);
        System.out.println(integer.isPresent());

        Optional<Optional<Progress>> progress = spring.map(OnlineClass::getProgress);
        Optional<Progress> progress1 = progress.orElseThrow();

        Optional<Progress> progress2 = spring.flatMap(OnlineClass::getProgress);


        System.out.println(onlineClass2.getTitle());

        onlineClass.ifPresent(oc -> System.out.println(oc.getTitle()));

    }

    private static OnlineClass createNewJpaClass() {
        System.out.println("create new online class");
        return new OnlineClass(10,"New class",false);
    }
}
