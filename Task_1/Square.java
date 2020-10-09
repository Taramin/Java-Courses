package com.company;

public class Square extends Figure{
    public String type = "square";
    protected final int a;
    public String getType() {
        return type;
    }

    public Square(int a, String value, String name, String color) {
        this.a = a > 0 ? a : 0;
        this.name = name;
        this.color = color;
        this.value = (value == "cm" || value == "m" || value == "dm" || value == "km"|| value == "mm")? value : " (undefined value) ";
        this.P = perimeter();
        this.S = area();
    }

    @Override
    public double perimeter() {
        return 4*a;
    }

    @Override
    public double area() {
        return a*a;
    }

    @Override
    public void informationFigure() {
        System.out.println("color-type-name: "+color+" "+type+" - "+name+"\nSide: "+a+value+"\nPerimeter: "+perimeter()+value+"\nSquare: "+area()+value+"^2");
    }
}
