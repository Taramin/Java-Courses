package com.company;

public class ExceptionDivisionToZero extends RuntimeException {
    public ExceptionDivisionToZero() {
        super("не дели на ноль, так нельзя");
    }
}
