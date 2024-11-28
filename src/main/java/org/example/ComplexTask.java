package org.example;

import java.util.concurrent.CyclicBarrier;

public class ComplexTask implements Runnable {
    private int taskId;
    private CyclicBarrier cyclicBarrier;


    public String result;
    public String word;

    public ComplexTask(int taskId, String word, CyclicBarrier cyclicBarrier) {
        this.taskId = taskId;
        this.word = word;
        this.cyclicBarrier = cyclicBarrier;

    }

    @Override
    public void run() {

        execute(word);
        try {

            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void execute(String word) {

        StringBuilder wordBuild = new StringBuilder();

        char firstChar = word.charAt(0);
        if (Character.isLowerCase(firstChar)) {
            wordBuild.append(Character.toUpperCase(firstChar));
        } else {
            wordBuild.append(firstChar);
        }

        word.chars()
            .skip(1)
            .mapToObj(c -> (char) c)
            .forEach(c -> {
                if (Character.isUpperCase(c)) {
                    wordBuild.append(Character.toLowerCase(c));
                } else {
                    wordBuild.append(c);
                }
            });
       wordBuild.append(" -" + Thread.currentThread().getName().toString());
        result = wordBuild.toString();
    }

    public String getResult() {
        return result;
    }

    public int getTaskId() {
        return taskId;
    }
}
