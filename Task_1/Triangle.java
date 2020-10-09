package com.company;

public class Triangle extends Figure {
    public String type = "triangle";
    protected final int a,b,c;
    public String getType() {
        return type;
    }
    public Triangle(int a, int b, int c, String value, String color,String name) {
            this.a = a > 0 ? a : 0;
            this.b = b > 0 ? b : 0;
            this.c = c > 0 ? c : 0;
            this.P = perimeter();
            this.S = area();
            this.color = color;
            this.name = name;
            this.value = (value == "cm" || value == "m" || value == "dm" || value == "km" || value == "mm") ? value : " (undefined value) ";

    }


    @Override
    public double perimeter() {
        if(Math.abs(a+b)>c && Math.abs(c+b)>a && Math.abs(a+c)>b){
            return a+b+c;
        }
        else return 0;
    }

    @Override
    public double area() {
        if(Math.abs(a+b)>c && Math.abs(c+b)>a && Math.abs(a+c)>b){
            double p = perimeter()/2;
            return Math.sqrt(p*(p-a)*(p-b)*(p-c));
        }
       else {
           return 0;
        }
    }

    @Override
    public void informationFigure() {
        System.out.println("color-type-name: "+color+" "+type+" - "+name+"\nSide1 (a): "+a+value+"\nSide2 (b): "+b+value+"\nSide3 (c): "+c+value+"\nPerimeter: "+perimeter()+value+"\nSquare: "+area()+value+"^2");
    }
}
