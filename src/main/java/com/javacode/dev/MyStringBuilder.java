package com.javacode.dev;

import java.util.ArrayList;
import java.util.List;

public class MyStringBuilder {
    private StringBuilder stringBuilder;
    private List<Memento> history;
    private int currentIndex;

    public MyStringBuilder() {
        this.stringBuilder = new StringBuilder();
        this.history = new ArrayList<>();
        this.currentIndex = -1;
    }

    public void append(String str) {
        stringBuilder.append(str);
        saveState();

    }

    public void delete(int start, int end) {
        saveState();
        stringBuilder.delete(start, end);
    }

    public void clear() {
        saveState();
        stringBuilder.setLength(0);
    }

    public String toString() {
        return stringBuilder.toString();
    }

    private void saveState() {

        if (currentIndex < history.size() - 1) {
            history.subList(currentIndex + 1, history.size()).clear();
        }
        history.add(new Memento(stringBuilder.toString()));
        currentIndex++;
    }

    public void undo() {
        if (currentIndex > 0) {
            currentIndex--;
            Memento memento = history.get(currentIndex);
            stringBuilder = new StringBuilder(memento.state());
        } else {
            System.out.println("Отсутствуют сохранненые состояния");
        }
    }

    public void redo() {
        if (currentIndex < history.size() - 1) {
            currentIndex++;
            Memento memento = history.get(currentIndex);
            stringBuilder = new StringBuilder(memento.state());
        } else {
            System.out.println("Отсутствуют  состояния для восстановления");
        }
    }
    private record Memento(String state) {
    }
}