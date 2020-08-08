package com.kuldeep.problems.design.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class CompleteOrderTopic implements  Topic {
    List<Observer> list = new ArrayList<>();
    @Override
    public void register(Observer ob) {
        list.add(ob);
    }

    @Override
    public void notifyObservers(String line) {
for(Observer ob : list){
    ob.update(line);
}
    }
}
