package com.kuldeep.problems.design.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class AddItemTopic implements Topic {
    List<Observer> addItemObservers = new ArrayList<>();
    @Override
    public void register(Observer ob) {
        addItemObservers.add(ob);
    }

    @Override
    public void notifyObservers(String line) {
        for(Observer o: addItemObservers){
         o.update(line);
        }
    }
}
