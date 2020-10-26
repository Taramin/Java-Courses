package com.company;

public class Triangle extends Figure {
    public static String type = "triangle";
    protected final int side1, side2, side3;
    public String getType() {
        return type;
    }
    public Triangle(int a, int b, int c, String value, String color,String name) {
            this.side1 = a > 0 ? a : 0;
            this.side2 = b > 0 ? b : 0;
            this.side3 = c > 0 ? c : 0;
            this.P = perimeter();
            this.S = area();
            this.color = color;
            this.name = name;
            this.value = (value == "cm" || value == "m" || value == "dm" || value == "km" || value == "mm") ? value : " (undefined value) ";

    }


    @Override
    public double perimeter() {
        if(Math.abs(side1 + side2)> side3 && Math.abs(side3 + side2)> side1 && Math.abs(side1 + side3)> side2){
            return side1 + side2 + side3;
        }
        else return 0;
    }

    @Override
    public double area() {
        if(Math.abs(side1 + side2)> side3 && Math.abs(side3 + side2)> side1 && Math.abs(side1 + side3)> side2){
            double p = perimeter()/2;
            return Math.sqrt(p*(p- side1)*(p- side2)*(p- side3));
        }
       else {
           return 0;
        }
    }

    @Override
    public void informationFigure() {
        System.out.println("color-type-name: "+color+" "+type+" - "+name+"\nSide1 (a): "+ side1 +value+"\nSide2 (b): "+ side2 +value+"\nSide3 (c): "+ side3 +value+"\nPerimeter: "+perimeter()+value+"\nSquare: "+area()+value+"^2");
    }
}
