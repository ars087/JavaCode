package com.javacode.dev;


public class Main {
    public static void main(String[] args) {

        MyStringBuilder myStringBuilder = new MyStringBuilder();
        myStringBuilder.append("One");
        myStringBuilder.append(" day");
        myStringBuilder.append("  next");
        System.out.println(myStringBuilder);
        myStringBuilder.undo();
        System.out.println(myStringBuilder);
        myStringBuilder.redo();
        System.out.println(myStringBuilder);

    }
}