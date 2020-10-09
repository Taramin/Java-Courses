package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RandomFigureConstructor figs = new RandomFigureConstructor();
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("1 - add random figure\n2 - add defined figure\n3 - print all figures\n4 - print total information\n5 - exit");
            String choice = in.next();
            switch (choice){
                case "1":{
                    figs.addFigure();
                    break;
                }
                case "2":{
                    System.out.println("What figure would you like to add?\n1 - circle\n2 - triangle\n3 - square");
                    String whatFigure = in.next();
                    switch (whatFigure){
                        case "1": {
                            System.out.println("Press radius: ");
                            int r = Integer.parseInt(in.next());
                            System.out.println("Press unit (1 - mm, 2 - cm, 3 - dm, 4 - m, 5 - km): ");
                            String choiceValue = in.next();
                            String val = " (undefined value) ";
                            switch (choiceValue) {
                                case "1": {
                                    val = "mm";
                                    break;
                                }
                                case "2": {
                                    val = "cm";
                                    break;
                                }
                                case "3": {
                                    val = "dm";
                                    break;
                                }
                                case "4": {
                                    val = "m";
                                    break;
                                }
                                case "5": {
                                    val = "km";
                                    break;
                                }
                            }
                            System.out.println("Press color: ");
                            String col = in.next();
                            System.out.println("Press name: ");
                            String name = in.next();
                            figs.figures.add(new Circle(r,val,col,name));
                            break;
                        }
                        case "2":{
                            System.out.println("Press side number 1: ");
                            int a = Integer.parseInt(in.next());
                            System.out.println("Press side number 2: ");
                            int b = Integer.parseInt(in.next());
                            System.out.println("Press side number 3: ");
                            int c = Integer.parseInt(in.next());
                            System.out.println("Press unit (1 - mm, 2 - cm, 3 - dm, 4 - m, 5 - km): ");
                            String choiceValue = in.next();
                            String val = " (undefined value) ";
                            switch (choiceValue) {
                                case "1": {
                                    val = "mm";
                                    break;
                                }
                                case "2": {
                                    val = "cm";
                                    break;
                                }
                                case "3": {
                                    val = "dm";
                                    break;
                                }
                                case "4": {
                                    val = "m";
                                    break;
                                }
                                case "5": {
                                    val = "km";
                                    break;
                                }
                            }
                            System.out.println("Press color: ");
                            String col = in.next();
                            System.out.println("Press name: ");
                            String name = in.next();
                            figs.figures.add(new Triangle(a,b,c,val,col,name));
                            break;
                        }
                        case "3":{
                            System.out.println("Press side: ");
                            int a = Integer.parseInt(in.next());
                            System.out.println("Press unit (1 - mm, 2 - cm, 3 - dm, 4 - m, 5 - km): ");
                            String choiceValue = in.next();
                            String val = " (undefined value) ";
                            switch (choiceValue) {
                                case "1": {
                                    val = "mm";
                                    break;
                                }
                                case "2": {
                                    val = "cm";
                                    break;
                                }
                                case "3": {
                                    val = "dm";
                                    break;
                                }
                                case "4": {
                                    val = "m";
                                    break;
                                }
                                case "5": {
                                    val = "km";
                                    break;
                                }
                            }
                            System.out.println("Press color: ");
                            String col = in.next();
                            System.out.println("Press name: ");
                            String name = in.next();
                            figs.figures.add(new Square(a,val,name,col));
                            break;
                        }
                    }
                    break;
                }
                case "3":{
                figs.printAll();
                break;
                }
                case "4":{
                figs.printTotalCharacteristics();
                break;
                }
                case "5":{
                return;
                }
            }
        }
    }

}
