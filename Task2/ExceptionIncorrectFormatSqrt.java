package com.company;

public class ExceptionIncorrectFormatSqrt extends RuntimeException {
    public ExceptionIncorrectFormatSqrt() {
        super("корень можно извлекать только в формате sqrt(a)");
    }
}
