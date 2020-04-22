package com.company;

public class BeerHouse {
    private static int maxCapacity = 100;
    private int stock;
    private boolean isOpened = true;

    public BeerHouse(int stock) {
        this.stock = stock;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public static int getMaxCapacity() {
        return maxCapacity;
    }

    public static void setMaxCapacity(int maxCapacity) {
        BeerHouse.maxCapacity = maxCapacity;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public synchronized void  putBeer (int value){
        // Cuando el stock llegue a 100 lo paro al productor
        while(stock == maxCapacity){
            try {
                System.out.println("Se llegaron a las 100 cervezas.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Si esta abierta la cerveceria produzco
        if(isOpened) {
            int stockToSum =  ( value > (maxCapacity - stock) )  ? 1  : value;
            stock = stock + stockToSum;
            System.out.println("AGREGO  : " + stockToSum);
            System.out.println("Stock disponible: " + stock);
            notifyAll(); // Consulta aca German : Aca estoy diciendole a los hilos consumidores que pueden entrar al getBeer
                        // y tambien si hay otro productor que puede entrar a producir... ?
        }
    }


    public synchronized void getBeer (int value) {
        // Si hay cervezas entro a consumir
        if(stock > 0) {
            int stockToSubtract = value < stock  ?  value  : 1;
            stock = stock - stockToSubtract;
            System.out.println("Me tomo : " + stockToSubtract);
            System.out.println("Stock disponible: " + stock);
            notifyAll(); // Lo mismo aca aviso a los demas consumidores o a los productores
        }else {
            // se termina el programa
            isOpened = false;
            System.out.println("Se cerro antares");
        }
    }
}
