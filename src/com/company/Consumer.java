package com.company;

public class Consumer extends Thread {
    BeerHouse beerhouse;

    public Consumer(BeerHouse beerhouse) {
        this.beerhouse = beerhouse;
    }

    public void run(){
        while(beerhouse.isOpened()){
            int value = (int) ((Math.random() * ((1 - beerhouse.getMaxCapacity()) + 1)) + beerhouse.getMaxCapacity());
            beerhouse.getBeer(value);
        }
    }
}
