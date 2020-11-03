package com.company;

import java.util.List;

public class Operation {

    public double sum(List<Double> numb) {
        double result = 0;

        for (int i = 0; i < numb.size(); i++) {
            result += numb.get(i);
        }

        return result;
    }

    public double multiplication(List<Double> numb) {
        double result = 1;
        for (int i = 0; i < numb.size(); i++) {
            result *= numb.get(i);
        }

        return result;
    }

    public double average(List<Double> numb) {
        double result = 0;

        for (int i = 0; i < numb.size(); i++) {
            result += numb.get(i);
        }

        result = result/(numb.size());

        return result;
    }
}
