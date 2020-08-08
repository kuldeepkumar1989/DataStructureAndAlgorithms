package com.kuldeep.problems.design.patterns.behavioral.observer;

public class ObserverClient {
    public static void main(String args[]){
        Order or = new Order();

        or.addItem(new Item("apple", 90));
        or.addItem(new Item("biscuit", 10));

        or.makePayment(new Payment("cash", 10));
        or.makePayment(new Payment("card", 90));

        or.completeOrder();
    }
}
