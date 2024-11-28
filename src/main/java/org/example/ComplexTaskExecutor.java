package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ComplexTaskExecutor {
    private CyclicBarrier barrier;
    List<ComplexTask> tasks = new ArrayList<>();

    public ComplexTaskExecutor(int number) {
        settingNumberTasks(number);
    }


    public void executeTasks(int numberOfTasks, List<String> list) {

        ExecutorService executor = Executors.newFixedThreadPool(numberOfTasks);

        for (int i = 0; i < numberOfTasks; i++) {

            ComplexTask task = new ComplexTask(i, list.get(i), barrier);
            tasks.add(task);
            executor.submit(task);
        }

        executor.shutdown();
        try {

            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public void settingNumberTasks(int number) {
        barrier = new CyclicBarrier(number, () -> {
            System.out.println("Все задачи завершены. Объединение результатов.");

            for (ComplexTask task : tasks) {
                System.out.println("Результат задачи " + task.getTaskId() + ": " + task.getResult());
            }
        });
    }

}