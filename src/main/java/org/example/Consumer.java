package org.example;

public class Consumer implements  Runnable {
    BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
         int taskNumber  =   blockingQueue.dequeue();
        System.out.println(taskNumber);
        }
    }
}
