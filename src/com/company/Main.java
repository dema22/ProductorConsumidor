package com.company;

public class Main {

    public static void main(String[] args) {
        BeerHouse antares = new BeerHouse(60);
        Producer p1 = new Producer(antares);
        Consumer c1 = new Consumer(antares);
        Consumer c2 = new Consumer(antares);

        p1.start();
        c1.start();
        c2.start();
    }
}
