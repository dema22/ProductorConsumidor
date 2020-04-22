package com.company;

public class Producer extends Thread {
    private BeerHouse beerhouse;

    public Producer(BeerHouse beerhouse) {
        this.beerhouse = beerhouse;
    }

    public void run(){
        while(beerhouse.isOpened()) {
            int value = (int) ((Math.random() * ((1 - beerhouse.getMaxCapacity()) + 1)) + beerhouse.getMaxCapacity());
            beerhouse.putBeer(value);
        }
    }
}
