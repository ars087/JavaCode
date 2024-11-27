package org.example;

public class Producer implements Runnable {
    BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i <=100; i++) {
            blockingQueue.enqueue(i);

        }

    }
}
