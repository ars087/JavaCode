package org.example;

import java.util.List;
import java.util.concurrent.CyclicBarrier;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


      ComplexTaskExecutor complexTaskExecutor = new ComplexTaskExecutor(5);
        complexTaskExecutor.executeTasks(5, List.of("сЕМЕН","Федр","каТя","сЕргей","алена"));
//      Runnable runnable =() ->{
//          complexTaskExecutor.executeTasks(5, List.of("сЕМЕН","Федр","АнТон","сЕргей","александр"));
//      };
//        System.out.println(complexTaskExecutor.tasks.size());
//
//        Thread one =  new  Thread(runnable);
//
//    one.start();
    }

}