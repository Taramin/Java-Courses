package com.company;

public class ExceptionDivisionToZero extends RuntimeException {
    @Override
    public String getMessage() {
        System.out.println("\nне дели на ноль, так нельзя\n");

        return null;
    }
}
