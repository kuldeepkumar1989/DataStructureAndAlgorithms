package com.kuldeep.problems.design.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List cart = new ArrayList<>();
    List payments = new ArrayList<>();

    private Topic addItemTopic;
    private Topic addPaymentTopic;
    private Topic completeOrderTopic;

    public Order(){
        this.addItemTopic = new AddItemTopic();
        this.addPaymentTopic = new AddPaymentTopic();
        this.completeOrderTopic = new CompleteOrderTopic();

        Observer cashierDisplay = new CashierDisplay();
        Observer customerDisplay = new CustomerDisplay();

        // customer display suscribed to all Topic

        addPaymentTopic.register(customerDisplay);
        addItemTopic.register(customerDisplay);
        completeOrderTopic.register(customerDisplay);

        addItemTopic.register(cashierDisplay);
        addPaymentTopic.register(cashierDisplay);
        completeOrderTopic.register(cashierDisplay);
    }

    public void addItem(Item item){
        cart.add(item);
        String line = item.name + " $ " +item.price;
        addItemTopic.notifyObservers(line);
    }

    public void makePayment(Payment payment){
        payments.add(payment);
        String line = payment.type +" $ "+payment.amount;
        addPaymentTopic.notifyObservers(line);
    }

    public void completeOrder(){
        String line = "Order complete";
        completeOrderTopic.notifyObservers(line);
    }
}
