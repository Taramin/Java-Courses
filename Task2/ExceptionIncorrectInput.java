package com.company;

public class ExceptionIncorrectInput extends RuntimeException{
    public ExceptionIncorrectInput() {
        super("введи нормальные числа блин без букв");
    }
}
