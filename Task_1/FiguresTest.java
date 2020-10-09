package com.company;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;


public class FiguresTest {
    @Test
    public void problemsWithValueTest(){
        RandomFigureConstructor figs = new RandomFigureConstructor();
        figs.figures.add(new Circle(12,"cm","red", "dasha"));
        String expected = "cm";
        String actual =  figs.figures.get(0).value;
        assertEquals(expected,actual);
        Scanner in = new Scanner(System.in);
        expected = in.next();
        assertEquals(expected,actual);

    }
}
