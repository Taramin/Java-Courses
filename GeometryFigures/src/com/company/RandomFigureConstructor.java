package com.company;

import java.util.ArrayList;
import java.util.Random;

public class RandomFigureConstructor {
    public ArrayList<Figure> figures = new ArrayList <Figure>();

    public void addFigure (){
       Random random = new Random();
       int choice = random.nextInt(2);
       if(choice == 0){
           int ch = random.nextInt(4);
           String val = (ch == 0)? "mm" : (ch == 1)? "cm": (ch == 2)? "dm": (ch == 3)? "m": (ch == 4)? "km" : " (undefined value) ";
           ch = random.nextInt(10);
           String col = (ch == 0)? "Red" : (ch == 1)? "Orange": (ch == 2)? "Yellow": (ch == 3)? "Green": (ch == 4)? "Blue" : (ch == 5)? "Purple": (ch == 6)? "Black": (ch == 7)? "White": (ch == 8)? "Pink": (ch == 9)? "Grey": (ch == 10)? "Pidorski" : "Skin";
           ch = random.nextInt(16);
           String name = (ch == 0)? "Mihail" : (ch == 1)? "Misha": (ch == 2)? "Mishanya": (ch == 3)? "Oval": (ch == 4)? "Pointyy" : (ch == 5)? "Kroojok": (ch == 6)? "Miha": (ch == 7)? "Mickle": (ch == 8)? "Zero": (ch == 9)? "Petya": (ch == 10)? "Stepan" : (ch == 11)?"Nikolay" : (ch == 12)? "Dia" : (ch == 13)? "Dasha" : (ch == 14)? "Artem" : (ch == 15)? "Petushok": (ch == 16)? "Igor" : "Stepan";
           figures.add(new Circle (random.nextInt(50), val, col,name));
       }
        else if(choice == 1){
           int ch = random.nextInt(4);
           String val = (ch == 0)? "mm" : (ch == 1)? "cm": (ch == 2)? "dm": (ch == 3)? "m": (ch == 4)? "km" : " (undefined value) ";
           ch = random.nextInt(10);
           String col = (ch == 0)? "Red" : (ch == 1)? "Orange": (ch == 2)? "Yellow": (ch == 3)? "Green": (ch == 4)? "Blue" : (ch == 5)? "Purple": (ch == 6)? "Black": (ch == 7)? "White": (ch == 8)? "Pink": (ch == 9)? "Grey": (ch == 10)? "Pidorski" : "Skin";
           ch = random.nextInt(10);
           String name = (ch == 0)? "Mihail" : (ch == 1)? "Gennadi": (ch == 2)? "Putin": (ch == 3)? "Diana": (ch == 4)? "Alex" : (ch == 5)? "Malevich": (ch == 6)? "Omon": (ch == 7)? "Dog214": (ch == 8)? "Pasha": (ch == 9)? "Vanya": (ch == 10)? "Sergey" : "Nikolay";
           figures.add(new Triangle (random.nextInt(50), random.nextInt(50),random.nextInt(50), val,col, name));
        }
      else if (choice == 2){
           int ch = random.nextInt(4);
           String val = (ch == 0)? "mm" : (ch == 1)? "cm": (ch == 2)? "dm": (ch == 3)? "m": (ch == 4)? "km" : " (undefined value) ";
           ch = random.nextInt(10);
           String col = (ch == 0)? "Red" : (ch == 1)? "Orange": (ch == 2)? "Yellow": (ch == 3)? "Green": (ch == 4)? "Blue" : (ch == 5)? "Purple": (ch == 6)? "Black": (ch == 7)? "White": (ch == 8)? "Pink": (ch == 9)? "Grey": (ch == 10)? "Pidorski" : "Skin";
           ch = random.nextInt(10);
           String name = (ch == 0)? "SpanchBob" : (ch == 1)? "Brat": (ch == 2)? "Lenin": (ch == 3)? "Diana": (ch == 4)? "Alex" : (ch == 5)? "Malevich": (ch == 6)? "Omon": (ch == 7)? "Roger": (ch == 8)? "Who": (ch == 9)? "Vanya": (ch == 10)? "Vasya" : "Nikolay";

           figures.add(new Square (random.nextInt(50), val,name,col));

       }
   }

   public void printAll (){
       for(int i=0; i<figures.size();i++){
           System.out.println("Figure "+(i+1)+":");
           figures.get(i).informationFigure();
       }
   }

    public void printTotalCharacteristics(){
        for(int i=0; i<figures.size(); i++){
            System.out.println("Figure "+(i+1)+": ");
            figures.get(i).informationFigure();
        }
        System.out.println("Amount of figures is: "+figures.size());
        System.out.println("Amount of circles is: "+countFiguresOneType(figures, "circle"));
        System.out.println("Amount of triangles is: "+countFiguresOneType(figures, "triangle"));
        System.out.println("Amount of squares is: "+countFiguresOneType(figures, "square"));
        System.out.println("Total perimeters is: "+sumPerimeters(figures)+"cm + "+undefinedValuesP(figures)+" (undefined value)");
        System.out.println("Total squares is: "+sumSquares(figures)+"cm^2 + "+undefinedValuesS(figures)+" (undefined value)");
    }

    private static int countFiguresOneType(ArrayList<Figure> figures, String type){
        int result=0;
        for(int i=0; i<figures.size(); i++){
            if (type == figures.get(i).getType()){
                result++;
            }
        }
        return result;
    }

    private  static double sumPerimeters (ArrayList<Figure> figures){
        double sum = 0;
        for(int i=0; i<figures.size(); i++){
            if(figures.get(i).value == "cm") {
                sum += figures.get(i).getP();
            }
            else if (figures.get(i).value == "m"){
                sum+=figures.get(i).getP() * 100;
            }
            else if (figures.get(i).value == "dm"){
                sum+=figures.get(i).getP() * 10;
            }
            else if (figures.get(i).value == "km"){
                sum+=figures.get(i).getP() * 1000;
            }
            else if (figures.get(i).value == "mm"){
                sum+=figures.get(i).getP() * 0.1;
            }
        }
        return sum;
    }

    private static double sumSquares (ArrayList<Figure> figures){
        double sum = 0;
        for(int i=0; i<figures.size(); i++){
            if(figures.get(i).value == "cm") {
                sum += figures.get(i).getP();
            }
            else if (figures.get(i).value == "m"){
                sum+=figures.get(i).getP() * 10000;
            }
            else if (figures.get(i).value == "dm"){
                sum+=figures.get(i).getP() * 100;
            }
            else if (figures.get(i).value == "km"){
                sum+=figures.get(i).getP() * 1000000;
            }
            else if (figures.get(i).value == "mm"){
                sum+=figures.get(i).getP() * 0.01;
            }
        }
        return sum;
    }

    private static double undefinedValuesP(ArrayList<Figure> figures){
        double undef = 0;
        for(int i=0; i<figures.size(); i++){
            if (figures.get(i).value != "cm" && figures.get(i).value != "m" && figures.get(i).value != "dm" && figures.get(i).value != "km"&& figures.get(i).value != "mm"){
                undef+= figures.get(i).perimeter();
            }
        }
        return undef;
    }
    private static double undefinedValuesS(ArrayList<Figure> figures){
        double undef = 0;
        for(int i=0; i<figures.size(); i++){
            if (figures.get(i).value != "cm" && figures.get(i).value != "m" && figures.get(i).value != "dm" && figures.get(i).value != "km"&& figures.get(i).value != "mm"){
                undef+= figures.get(i).area();
            }
        }
        return undef;
    }
}
