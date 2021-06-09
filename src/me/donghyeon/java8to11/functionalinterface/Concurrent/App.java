package me.donghyeon.java8to11.functionalinterface.Concurrent;

public class App {
    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
        myThread.start();

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread : " + Thread.currentThread().getName());
//            }
//        });

//        Thread thread = new Thread(() -> System.out.println("Thread : " + Thread.currentThread().getName()));

//        Thread thread = new Thread(() -> {
//            while(true) {
//                System.out.println("Thread : " + Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    System.out.println("exit!!");
//                    return;
//                }
//            }
//        });
//        thread.start();
//
//        System.out.println("Hello : " + Thread.currentThread().getName());
//        Thread.sleep(3000L);
//        thread.interrupt();

        Thread thread = new Thread(() -> {
            System.out.println("Thread : " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });
        thread.start();

        System.out.println("Hello : " + Thread.currentThread().getName());
        thread.join(); // thread 를 기다린다.
        System.out.println(thread + " is finished");
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello : " + Thread.currentThread().getName());
        }
    }
}
