package me.donghyeon.java8to11.functionalinterface.Concurrent;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "java";
        };

        Callable<String> donghyeon = () -> {
            Thread.sleep(1000L);
            return "Donghyeon";
        };

//        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello,java,donghyeon)); // invokeAll => 다 끝날때까지 기다림
        String s = executorService.invokeAny(Arrays.asList(hello, java, donghyeon));// invokeAny => 먼저 된 것 하나만 가져온다
        System.out.println(s);

//        for(Future<String> f : futures) System.out.println(f.get());

//        Future<String> helloFuture = executorService.submit(hello);
//        System.out.println(helloFuture.isDone());
//        System.out.println("Started");
//
////        helloFuture.get(); // 블로킹
//        helloFuture.cancel(false);
//
//        System.out.println(helloFuture.isDone());
//        System.out.println("End!!");

        executorService.shutdown();
    }
}
