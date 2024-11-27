package org.example;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueue<T> {
    private final Queue<T> queue;
    private final int maxCapacity;

    public BlockingQueue(int maxSize) {
        this.maxCapacity = maxSize;
        this.queue = new LinkedBlockingQueue<>(maxCapacity);

    }

    public synchronized void enqueue(T item) {
        if (getQueueSize() == maxCapacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        queue.add(item);
        notifyAll();
    }

    public synchronized T dequeue() {
        if (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        T item = queue.poll();
        notify();
        return item;
    }

    public synchronized int getQueueSize() {
        return queue.size();
    }

}
