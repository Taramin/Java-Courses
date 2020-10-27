package com.company;

public class ExceptionNotPositiveNumber extends RuntimeException {
    @Override
    public String getMessage() {
        System.out.println("\nне надо писать отрицательные числа там где нельзя\n");
        return null;
    }
}
