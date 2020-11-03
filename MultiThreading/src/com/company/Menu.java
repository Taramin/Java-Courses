package com.company;

public class Menu {

    public void start(int iterator) {
        WorkWithFile object = new WorkWithFile();
        object.readFile(iterator);
    }

}
