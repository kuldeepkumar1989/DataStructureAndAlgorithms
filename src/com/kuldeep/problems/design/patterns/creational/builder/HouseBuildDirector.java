package com.kuldeep.problems.design.patterns.creational.builder;

public class HouseBuildDirector {
    private HouseBuilder builder;

    HouseBuildDirector(HouseBuilder builder){
        this.builder = builder;
    }

    public House construct(){
        return builder.buildFloor().buildWall().buildRoof().build();
    }
}
