package me.donghyeon.java8to11.functionalinterface.Concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("Hello" + Thread.currentThread().getName());
//            return "Hello";
//        }).thenApply((s) -> {
//            System.out.println(Thread.currentThread().getName());
//            return s.toUpperCase();
//        });
//
//        System.out.println(future.get());

//        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("Hello" + Thread.currentThread().getName());
//            return "Hello";
//        }).thenAccept((s) -> {
//            System.out.println(Thread.currentThread().getName());
//            System.out.println(s.toUpperCase());
//        });
//
//        future.get();

//        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("Hello" + Thread.currentThread().getName());
//            return "Hello";
//        }).thenRun(() -> {
//            System.out.println(Thread.currentThread().getName());
//        });
//
//        future.get();

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello" + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> future = hello.thenCompose(CompletableFutureApp::getWorld);

        System.out.println(future.get());

        hello.thenCombine(getWorld(""), (h,w) -> h + " " + w);
        System.out.println(future.get());

        CompletableFuture.allOf(hello, getWorld(""))
                .thenAccept(System.out::println);
        System.out.println(future.get());


        // 예외처리
        boolean throwError =true;
        CompletableFuture<String> errorHello = CompletableFuture.supplyAsync(() -> {
            if(throwError) throw new IllegalArgumentException();
            System.out.println("Hello" + Thread.currentThread().getName());
            return "Hello";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "Error!";
        });

        CompletableFuture<String> errorHelloHandle = CompletableFuture.supplyAsync(() -> {
            if(throwError) throw new IllegalArgumentException();
            System.out.println("Hello" + Thread.currentThread().getName());
            return "Hello";
        }).handle((result, ex) -> {
            if(ex!=null) {
                System.out.println(ex);
                return "ERROR";
            }
            return result;
        });
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World" + Thread.currentThread().getName());
            return message + "World";
        });
    }
}
