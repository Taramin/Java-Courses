package com.company;

import java.util.stream.Collector;

public abstract class Figure {
    protected String name;
    protected String color;
    protected String value;
    public String type;
    public String getType() {
        return type;
    }
    protected double P;
    protected double S;

    public double getS() {
        return S;
    }
    public double getP() {
        return P;
    }

    public abstract double perimeter();
    public abstract double area();
    public abstract void informationFigure();

}
