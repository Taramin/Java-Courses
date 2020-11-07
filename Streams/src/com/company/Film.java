package com.company;

public class Film {
    private String name;
    private double rang;

    public Film(String name, double rang) {
        this.name = name;
        this.rang = ((rang<=10)&&(rang>=0)) ? rang : 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRang() {
        return rang;
    }

    public void setRang(double rang) {
        this.rang = rang;
    }

    public Film(){}

    public void printInfo (){
        System.out.println("Фильм: "+ getName() + ", рейтинг: "+getRang());
    }

    public int compareTo(Film o2) {
        if (o2.equals(this)){
            return 0;
        }
        return (o2.getRang() > this.getRang()) ? -1 : 1;
    }
}
