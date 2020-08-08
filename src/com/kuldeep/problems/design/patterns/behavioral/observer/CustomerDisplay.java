package com.kuldeep.problems.design.patterns.behavioral.observer;

public class CustomerDisplay extends Observer {
    @Override
    public void update(String str) {
        System.out.println("Customer Display : "+ str);
    }
}
