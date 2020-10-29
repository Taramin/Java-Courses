package com.company;

public class ExceptionIncorrectInputOfOperations extends RuntimeException {
    @Override
    public String getMessage(){
        System.out.println("\nнеправильно введенные операторы!!!! пробелы тоже нельзя ставить\n");

        return null;
    }
}
