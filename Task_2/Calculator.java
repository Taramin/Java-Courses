package com.company;

public class Calculator {
    public double sum (String numb1, String numb2){
        if((numb1.matches("[-]?\\D+"))||(numb2.matches("[-]?\\D+"))){
            throw new ExceptionIncorrectInput();
        }
        return Double.parseDouble(numb1)+Double.parseDouble(numb2);
    }
    public double difference (String numb1, String numb2){
        if((numb1.matches("[-]?\\D+"))||(numb2.matches("[-]?\\D+"))){
            throw new ExceptionIncorrectInput();
        }
        return Double.parseDouble(numb1)-Double.parseDouble(numb2);
    }
    public double division (String numb1, String numb2){
        if((numb1.matches("[-]?\\D+"))||(numb2.matches("[-]?\\D+"))){
           throw new ExceptionIncorrectInput();
        }
        else if (numb2.equals("0")){
           throw new ExceptionDivisionToZero();
        }
        return Double.parseDouble(numb1)/Double.parseDouble(numb2);
    }
    public double multiplication (String numb1, String numb2){
        if(((numb1.matches("[-]?\\D+"))||(numb2.matches("[-]?\\D+")))){
           throw new ExceptionIncorrectInput();
        }
        return Double.parseDouble(numb1)*Double.parseDouble(numb2);
    }
    public double exponentiation (String numb1, String numb2){
        if((numb1.matches("[-]?\\D+"))||(numb2.matches("[-]?\\D+"))){
           throw new ExceptionIncorrectInput();
        }
        else if (numb2.contains("-")){
         throw new ExceptionNotPositiveNumber();
        }
        return Math.pow(Double.parseDouble(numb1),Double.parseDouble(numb2));
    }
    public double squareRootExtraction (String numb1){
        if(numb1.matches("[-]?\\D+")){
            throw new ExceptionIncorrectInput();
        }
        else if (numb1.startsWith("-")){
            throw new ExceptionNotPositiveNumber();
        }
        return Math.sqrt(Double.parseDouble(numb1));
    }
}
