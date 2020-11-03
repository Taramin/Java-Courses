package com.company;

public class ExceptionIncorrectFormatInFile extends RuntimeException {
    public void message(){
        System.out.println("Incorrect format in file: file should be in the format \"operation (*/+/#/^) x*10^y!!! (x,y - numbers)\"");
    }
}
