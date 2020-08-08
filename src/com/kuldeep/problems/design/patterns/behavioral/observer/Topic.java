package com.kuldeep.problems.design.patterns.behavioral.observer;

public interface Topic {
    void register(Observer ob);
    void notifyObservers(String line);
}
