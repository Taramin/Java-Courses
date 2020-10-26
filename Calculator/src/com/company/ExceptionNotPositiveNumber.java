package com.company;

public class ExceptionNotPositiveNumber extends RuntimeException {
    public ExceptionNotPositiveNumber() {
        super("не надо писать отрицательные числа там где нельзя");
    }
}
