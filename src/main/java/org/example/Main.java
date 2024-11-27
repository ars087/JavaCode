package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new BlockingQueue<>(50);
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        executorService.execute(new Producer(queue));
        executorService.execute(new Consumer(queue));

//        Thread producerThread = new Thread(new Producer(queue));
//        Thread consumerThread = new Thread(new Consumer(queue));
//
//        producerThread.start();
//        consumerThread.start();
//
//        try {
//            producerThread.join();
//            consumerThread.join();
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

    }


}
