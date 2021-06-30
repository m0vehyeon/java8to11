package me.donghyeon.java8to11.functionalinterface.Concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsApp {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();

//        ExecutorService executorService = Executors.newFixedThreadPool(2);

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

//        executorService.submit(() -> System.out.println("Thread " + Thread.currentThread().getName()));

//        executorService.submit(getRunnable("Hi"));
//        executorService.submit(getRunnable("The"));
//        executorService.submit(getRunnable("Java"));
//        executorService.submit(getRunnable("Thread"));
//        executorService.submit(getRunnable("Donghyeon"));

//        executorService.schedule(getRunnable("Hello"), 3, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(getRunnable("Hello"),1, 2, TimeUnit.SECONDS);

//        executorService.shutdown();
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + " " + Thread.currentThread().getName());
    }
}
