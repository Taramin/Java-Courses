package com.company;

public class Circle extends Figure{
    public String type = "circle";
    protected final int R;

    public Circle(int radius, String value, String color, String name) {
        R = radius>0 ? radius : 0;
        area();
        perimeter();
        this.color = color;
        this.name = name;
        this.P = perimeter();
        this.S = area();
        this.value = (value == "cm" || value == "m" || value == "dm" || value == "km"|| value == "mm")? value : " (undefined value) ";
    }
    public String getType() {
        return type;
    }

    @Override
    public double area() {
        return 3.141592*R*R;
    }

    @Override
    public double perimeter() {
        return 2*3.141592*R;
    }

    @Override
    public void informationFigure() {
        System.out.println("color-type-name: "+color+" "+type+" - "+name+"\nRadius: "+R+value+"\nPerimeter: "+perimeter()+value+"\nSquare: "+area()+value+"^2");
    }
}
