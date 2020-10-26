package com.company;

public class Circle extends Figure{
    public static String type = "circle";
    protected final int radius;

    public Circle(int radius, String value, String color, String name) {
        this.radius = radius>0 ? radius : 0;
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
        return 3.141592* radius * radius;
    }

    @Override
    public double perimeter() {
        return 2*3.141592* radius;
    }

    @Override
    public void informationFigure() {
        System.out.println("color-type-name: "+color+" "+type+" - "+name+"\nRadius: "+ radius +value+"\nPerimeter: "+perimeter()+value+"\nSquare: "+area()+value+"^2");
    }
}
