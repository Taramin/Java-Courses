package com.company;

public class Square extends Figure{
    public static String type = "square";
    protected final int side;
    public String getType() {
        return type;
    }

    public Square(int a, String value, String name, String color) {
        this.side = a > 0 ? a : 0;
        this.name = name;
        this.color = color;
        this.value = (value == "cm" || value == "m" || value == "dm" || value == "km"|| value == "mm")? value : " (undefined value) ";
        this.P = perimeter();
        this.S = area();
    }

    @Override
    public double perimeter() {
        return 4* side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public void informationFigure() {
        System.out.println("color-type-name: "+color+" "+type+" - "+name+"\nSide: "+ side +value+"\nPerimeter: "+perimeter()+value+"\nSquare: "+area()+value+"^2");
    }
}
