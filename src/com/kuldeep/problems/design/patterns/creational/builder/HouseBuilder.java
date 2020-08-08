package com.kuldeep.problems.design.patterns.creational.builder;

public interface HouseBuilder {
    public HouseBuilder buildFloor();
    public HouseBuilder buildRoof();
    public HouseBuilder buildWall();
    public House build();
}
