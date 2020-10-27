package com.company;

public class ExceptionIncorrectInput extends RuntimeException{
    @Override
    public String getMessage() {
        System.out.println("\nвведи нормальные числа блин без букв\n");
        return null;
    }
}
