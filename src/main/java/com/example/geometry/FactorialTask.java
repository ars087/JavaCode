package com.example.geometry;

import java.util.concurrent.RecursiveTask;

class FactorialTask extends RecursiveTask<Long> {
    private final int n;

    public FactorialTask(int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {

        if (n <= 1) {
            return 1L;
        }


        FactorialTask task1 = new FactorialTask(n - 1);
        task1.fork();
        long result = n * task1.join();
        return result;
    }
}