package com.kuldeep.problems.design.patterns.creational.builder;

public class BuilderClient {
    public static void main(String args[]){
        HouseBuilder builder = new ConcreteHouseBuilder();

        HouseBuildDirector director = new HouseBuildDirector(builder);
        System.out.println(director.construct());
    }
}

/**
 * java.lang.StringBuilder append()
 * java.lang.StringBuffer append()
 *
 */
