package com.company;

public class ExceptionIncorrectFormatSqrt extends RuntimeException {
    @Override
    public String getMessage() {
        System.out.println("\nкорень можно извлекать только в формате sqrt(a)\n");
        return null;
    }
}
