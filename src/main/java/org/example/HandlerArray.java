package org.example;

public class HandlerArray {

    public Object[] filter(Object[] array, Filter filter) {

        for (int i = 0; i < array.length; i++) {
            array[i] = filter.apply(array[i]);

        }
        return array;
    }

}