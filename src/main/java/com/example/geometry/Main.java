package com.example.geometry;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "apple", "orange", "banana", "banana"};
        System.out.println(countElements(array));


    }

    public static Map<String, Integer> countElements(String[] elements) {
        Map<String, Integer> elementCountMap = new HashMap<>();

        for (String element : elements) {
            elementCountMap.put(element, elementCountMap.getOrDefault(element, 0) + 1);
        }
        return elementCountMap;
    }
}