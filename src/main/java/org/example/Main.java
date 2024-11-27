package org.example;

public class Main {
    public static void main(String[] args) {

        String[] str = new String[] {"Один", "Два"};

//        Integer[] num = new Integer[] {1, 2, 3, 6, 8};
//
//        Character[] chars = new Character[] {'s', 'r'};
//
//        Boolean [] boolean = new Boolean[] {false, false, true};

        HandlerArray handlerArray = new HandlerArray();
        FilterImpl filter = new FilterImpl();
        Object[] p = handlerArray.filter(str, filter);

        for (Object d : p) {

            System.out.println(d);

        }

    }
}